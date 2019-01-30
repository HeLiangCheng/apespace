package com.hlc.apespace.gathering.dao;

import com.hlc.apespace.gathering.entity.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName GatheringDao
 * @Description todo
 * @Author Liang
 * @Date 2019/1/30 13:26
 * @Version 1.0
 **/
public interface GatheringDao extends JpaRepository<Gathering,String>,JpaSpecificationExecutor<Gathering> {

}
