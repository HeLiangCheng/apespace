package com.hlc.apespace.user.dao;

import com.hlc.apespace.user.entity.Admin;
import com.hlc.apespace.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
    *@ClassName UserDao
    *@Description todo
    *@Author Liang
    *@Date 2019/2/14 10:20
    *@Version 1.0
**/

public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {

    public User findByMobile(String mobile);

    @Modifying
    @Query("update User u set u.fanscount=u.fanscount+?2 where u.id=?1")
    public void incFanscount(String userid, int num);

    @Modifying
    @Query("update User u set u.followcount=u.followcount+?2 where u.id=?1")
    public void incFollowcount(String userid, int num);


}
