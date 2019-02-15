package com.hlc.apespace.user.dao;

import com.hlc.apespace.user.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName AdminDao
 * @Description todo
 * @Author Liang
 * @Date 2019/2/14 10:19
 * @Version 1.0
 **/

public interface AdminDao extends JpaRepository<Admin,String>,JpaSpecificationExecutor<Admin> {

    public Admin findByLoginname(String loginName);

}
