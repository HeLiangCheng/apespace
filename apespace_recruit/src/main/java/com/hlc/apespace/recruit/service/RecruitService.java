package com.hlc.apespace.recruit.service;

import com.hlc.apespace.recruit.entity.Recruit;
import org.springframework.data.domain.Page;

import java.util.List;

/**
    *@ClassName RecruitService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:47
    *@Version 1.0
**/
public interface RecruitService {

    /**
     * 新增recruit
     *
     * @param recruit 对象
     */
    void save(Recruit recruit);

    /**
     * 根据Id获取单个recruit
     *
     * @param id
     * @return
     */
    Recruit getRecruit(String id);

    /**
     * 分页获取recruit列表
     *
     * @param pageSize
     * @param pageIndex
     * @param recruit
     * @return
     */
    Page<Recruit> listRecruitByPage(int pageSize, int pageIndex, Recruit recruit);

    /**
     * 根据条件获取recruit数量
     *
     * @param recruit
     * @return
     */
    long count(Recruit recruit);

    /**
     * 根据Id删除recruit
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 更新recruit对象
     *
     * @param recruit
     */
    void update(Recruit recruit);

    /**
     * 根据状态查询
     *
     * @param state
     * @return
     */
    List<Recruit> listLatestByStateOrder(String state);

}
