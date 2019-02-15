package com.hlc.apespace.friend.service;

import com.hlc.apespace.friend.dao.FriendDao;
import com.hlc.apespace.friend.dao.NoFriendDao;
import com.hlc.apespace.friend.entity.Friend;
import com.hlc.apespace.friend.entity.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
    *@ClassName FriendService
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 10:27
    *@Version 1.0
**/
@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;
    @Autowired
    private NoFriendDao noFriendDao;

    /**
     * 新增好友信息
     *
     * @param userid
     * @param friendid
     * @return
     */
    public int addFriend(String userid, String friendid) {
        //判断该用户已经添加这个好友，则不进行任何操作，返回0
        if (friendDao.selectCount(userid, friendid) > 0) {
            return 0;
        }
        //不存在则添加好友信息
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        //判断对方是否喜欢你，如果喜欢将islike设置为1
        if (friendDao.selectCount(friendid, userid) > 0) {
            friendDao.updateLike(userid, friendid, "1");
            friendDao.updateLike(friendid, userid, "1");
        }
        return 1;
    }

    /**
     * 向不喜欢的列表中添加朋友
     *
     * @param userid
     * @param friendid
     */
    public void addNoFriend(String userid, String friendid) {
        NoFriend noFriend = new NoFriend();
        noFriend.setFriendid(friendid);
        noFriend.setUserid(userid);
        noFriendDao.save(noFriend);
    }

    /**
     * 删除好友
     *
     * @param userid
     * @param friendid
     */
    @Transactional
    public void deleteFriend(String userid, String friendid) {
        friendDao.deleteFriend(userid, friendid);
        friendDao.updateLike(friendid, userid, "0");
        addFriend(userid, friendid);
    }

}
