package com.hlc.apespace.article.service;

import com.hlc.apespace.article.dao.CommentDao;
import com.hlc.apespace.article.entity.Comment;
import com.hlc.apespace.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
    *@ClassName CommentService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 10:29
    *@Version 1.0
**/
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdWorker idWorker;

    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        commentDao.save(comment);
    }

    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }

    public void delete(String articleid) {
        commentDao.deleteCommentByArticleid(articleid);
    }

}
