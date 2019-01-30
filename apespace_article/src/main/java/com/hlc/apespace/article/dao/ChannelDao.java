package com.hlc.apespace.article.dao;

import com.hlc.apespace.article.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName ChannelDao
 * @Description todo
 * @Author Liang
 * @Date 2019/1/30 9:11
 * @Version 1.0
 **/

public interface ChannelDao extends JpaRepository<Channel,String>,JpaSpecificationExecutor<Channel> {

}
