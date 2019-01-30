package com.hlc.apespace.article.dao;

import com.hlc.apespace.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
    *@ClassName ArticleDao
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 9:10
    *@Version 1.0
**/

public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article> {

    /**
     * 审核文章
     *
     * @param id
     */
    @Modifying
    @Query("update Article set state='1' where id = ?1 ")
    void examine(String id);


    /**
     * 点赞
     * @param id
     * @return
     */
    @Modifying
    @Query(" update Article set thumbup = thumbup +1 where id = ?1 ")
    int updateThumbup(String id);

}
