package com.hlc.apespace.recruit.dao;

import com.hlc.apespace.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
    *@ClassName RecruitDao 职位存储
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:45
    *@Version 1.0
**/
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit> {

    /**
     * 查询最新职位列表（按创建日期降序排序）
     *
     * @param state
     * @return
     */
    List<Recruit> findTop5ByStateOrderByCreatetimeDesc(String state);

}
