package com.hlc.apespace.recruit.service;

import com.hlc.apespace.recruit.entity.Enterprise;
import org.springframework.data.domain.Page;

import java.util.List;

/**
    *@ClassName EnterpriseService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 13:46
    *@Version 1.0
**/
public interface EnterpriseService {

    /**
     * 新增Enterprise
     *
     * @param enterprise 对象
     */
    void save(Enterprise enterprise);

    /**
     * 根据Id获取单个enterprise
     *
     * @param id
     * @return
     */
    Enterprise getEnterprise(String id);

    /**
     * 分页获取列表
     *
     * @param pageSize
     * @param pageIndex
     * @param enterprise
     * @return
     */
    Page<Enterprise> listEnterpriseByPage(int pageSize, int pageIndex, Enterprise enterprise);

    /**
     * 根据条件获取Enterprise数量
     *
     * @param enterprise
     * @return
     */
    long count(Enterprise enterprise);

    /**
     * 根据Id删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 更新Enterprise对象
     *
     * @param enterprise
     */
    void update(Enterprise enterprise);

    /**
     * 热门企业列表
     * @return
     */
    List<Enterprise> hotlist();

}
