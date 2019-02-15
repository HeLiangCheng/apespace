package com.hlc.apespace.user.service;

import com.hlc.apespace.user.config.IdWorkerConfig;
import com.hlc.apespace.user.dao.AdminDao;
import com.hlc.apespace.user.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
    *@ClassName AdminService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 13:53
    *@Version 1.0
**/
@Service
public class AdminService {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private IdWorkerConfig idWorkerConfig;
    @Autowired
    private AdminDao adminDao;

    public void add(Admin admin) {
        admin.setId(idWorkerConfig.idWorker().nextId() + "");
        admin.setPassword(encoder.encode(admin.getPassword()));
        adminDao.save(admin);
    }

    public Admin findByLoginNameAndPaddword(String loginName, String passWord) {
        Admin admin = adminDao.findByLoginname(loginName);
        if (admin != null && encoder.matches(passWord, admin.getPassword())) {
            return admin;
        }
        return null;
    }

}
