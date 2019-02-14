package com.hlc.apespace.article.dao;

import com.hlc.apespace.article.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
    *@ClassName CommentDao
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 10:28
    *@Version 1.0
**/
public interface CommentDao extends MongoRepository<Comment,String> {

    /**
     * 根据文章ID查询评论列表
     *
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);

    /**
     * 删除评论
     *
     * @param articleid
     * @return
     */
    public void deleteCommentByArticleid(String articleid);

}
