package com.hlc.apespace.spitslot.dao;

import com.hlc.apespace.spitslot.entity.Spitslot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
    *@ClassName SpitslotDao
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 14:04
    *@Version 1.0
**/
public interface SpitslotDao extends MongoRepository<Spitslot,String> {

    /**
     * 根据上级ID查询吐槽列表（分页）
     *
     * @param parentId
     * @param pageable
     * @return
     */
    Page<Spitslot> findByParentid(String parentId, Pageable pageable);

}
