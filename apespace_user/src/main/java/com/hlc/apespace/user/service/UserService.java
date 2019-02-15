package com.hlc.apespace.user.service;

import com.hlc.apespace.common.util.IdWorker;
import com.hlc.apespace.user.dao.UserDao;
import com.hlc.apespace.user.entity.User;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
    *@ClassName UserService
    *@Description todo
    *@Author Liang
    *@Date 2019/2/1 10:17
    *@Version 1.0
**/
@Service
public class UserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserDao userDao;

    /**
     * 发送短信验证码
     * @param mobile
     */
    public void sendSms(String mobile) {
        //1.生成6位短信验证码
        Random random = new Random();
        int max = 999999;
        int min = 100000;
        int code = random.nextInt(max);
        if (code < min) {
            code += min;
        }
        System.out.println(mobile + "生成的验证码是：" + code);
        //2.将验证码存入redis
        redisTemplate.opsForValue().set("smscode_" + mobile, code + "", 5, TimeUnit.MINUTES);

        //3.将验证码和手机号发送到rabbitMQ中
        Map<String, String> map = new HashMap<String, String>();
        map.put("mobile", mobile);
        map.put("code", code + "");
        redisTemplate.convertAndSend("sms", map);
    }

    /**
     * 添加用户信息
     * @param user
     */
    public void addUser(User user) {
        user.setId(idWorker.nextId() + "");
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    /**
     * 根据手机号码和密码登录
     * @param mobile
     * @param password
     * @return
     */
    public User findByMobileAndPassword(String mobile,String password) {
        User user = userDao.findByMobile(mobile);
        if (user != null && encoder.matches(user.getPassword(), password)) {
            return user;
        }
        return null;
    }

    /**
     * 删除用户信息
     * @param id
     */
    public void deleteUserById(String id) {
        userDao.deleteById(id);
    }

    /**
     *  更新粉丝数量
     * @param userid  用户ID
     * @param num   粉丝数量
     */
    public void incFanscount(String userid,int num) {
        userDao.incFanscount(userid, num);
    }


    /**
     * 更新关注数
     * @param userid
     * @param num
     */
    public void incFollowcount(String userid,int num){
        userDao.incFollowcount(userid,num);
    }

}
