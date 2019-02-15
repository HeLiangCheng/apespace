package com.hlc.apespace.friend.dao;

import com.hlc.apespace.friend.entity.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
    *@ClassName NoFriendDao
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 13:01
    *@Version 1.0
**/

public interface NoFriendDao extends JpaRepository<NoFriend,String>,JpaSpecificationExecutor<NoFriend> {

}
