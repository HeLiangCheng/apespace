package com.hlc.apespace.friend.dao;

import com.hlc.apespace.friend.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
    *@ClassName FriendDao
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 9:08
    *@Version 1.0
**/
public interface FriendDao extends JpaRepository<Friend,String>,JpaSpecificationExecutor<String> {

    /**
     * 根据用户ID与被关注用户ID查询记录个数
     *
     * @param userid
     * @param friendid
     * @return
     */
    @Query("select count(f) from Friend f where f.userid=?1 and f.friendid=?2")
    public int selectCount(String userid, String friendid);

    /**
     * 更新为互为喜欢
     *
     * @param userid
     * @param friendid
     * @param islike
     */
    @Modifying
    @Query("update Friend f set f.islike=?3 where f.userid=?1 and f.friendid=?2")
    public void updateLike(String userid, String friendid, String islike);

    /**
     * 删除好友关系
     * @param userid
     * @param friendid
     */
    @Modifying
    @Query("delete from Friend  f where f.userid=?1 and f.friendid=?2")
    public void deleteFriend(String userid, String friendid);

}
