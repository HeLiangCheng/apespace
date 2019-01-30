package com.hlc.apespace.recruit.dao;

import com.hlc.apespace.recruit.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
    *@ClassName EnterpriseDao  企业存储
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:34
    *@Version 1.0
**/
public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise> {

    /**
     * 根据热门状态获取企业列表
     * @param ishot
     * @return
     */
    List<Enterprise> findByIshot(String ishot);

}
