package com.hlc.apespace.gathering.dao;

import com.hlc.apespace.gathering.entity.Usergath;
import com.hlc.apespace.gathering.entity.UsergathPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
    *@ClassName UsergathDao
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 13:27
    *@Version 1.0
**/
public interface UsergathDao extends JpaRepository<Usergath,UsergathPrimaryKey>,JpaSpecificationExecutor<Usergath> {

}
