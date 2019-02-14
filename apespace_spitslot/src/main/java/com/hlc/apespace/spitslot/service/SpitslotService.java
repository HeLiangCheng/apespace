package com.hlc.apespace.spitslot.service;

import com.hlc.apespace.common.util.IdWorker;
import com.hlc.apespace.spitslot.dao.SpitslotDao;
import com.hlc.apespace.spitslot.entity.Spitslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
    *@ClassName SpitslotService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 14:05
    *@Version 1.0
**/
@Service
public class SpitslotService {

    @Autowired
    private SpitslotDao spitslotDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate  mongoTemplate;

    /**
     * 查询全部记录
     *
     * @return
     */
    public List<Spitslot> findAll() {
        return spitslotDao.findAll();
    }

    /**
     * 根据主键查询实体
     *
     * @param id
     * @return
     */
    public Spitslot findById(String id) {
        Spitslot spit = spitslotDao.findById(id).get();
        return spit;
    }

    /**
     * 增加
     *
     * @param spit
     */
    public void add(Spitslot spit) {
        spit.set_id(idWorker.nextId() + "");
        spit.setPublishtime(new Date());
        spit.setVisits(0);
        spit.setShare(0);
        spit.setThumbup(0);
        spit.setComment(0);
        spit.setState("1");
        if(spit.getParentid()!=null && !"".equals(spit.getParentid())) {
            //如果存在上级ID，评论
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
        spitslotDao.save(spit);
    }

    /**
     * 修改
     *
     * @param spit
     */
    public void update(Spitslot spit) {
        spitslotDao.save(spit);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id) {
        spitslotDao.deleteById(id);
    }

    /**
     * 根据上级ID查询吐槽列表
     * @param parentId
     * @param pageSize
     * @param pageIndex
     * @return
     */
    public Page<Spitslot> findByParentId(String parentId,int pageSize,int pageIndex) {
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        return spitslotDao.findByParentid(parentId, pageRequest);
    }

    /**
     * 吐槽点赞
     * @param id
     */
    public void updateThumbup(String id) {
        /*
         //使用mongo jpa提供的方法效率较低
        Spitslot spit = spitslotDao.findById(id).get();
        spit.setThumbup(spit.getThumbup() + 1);
        spitslotDao.save(spit);
        */

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spitslot");

    }

}
