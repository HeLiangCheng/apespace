package com.hlc.apespace.base.dao;

import com.hlc.apespace.base.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName LabelDao
 * @Description JpaRepository提供基本的增删改查，JpaSpecificationExecutor用于做复杂的条件查询
 * @Author Liang
 * @Date 2019/1/29 8:49
 * @Version 1.0
 **/
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

}
