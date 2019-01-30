package com.hlc.apespace.article.service;

import com.hlc.apespace.article.dao.ArticleDao;
import com.hlc.apespace.article.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
    *@ClassName ArticleService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 9:12
    *@Version 1.0
**/

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 文章审核
     *
     * @param id
     */
    @Transactional
    public void examine(String id) {
        articleDao.examine(id);
    }

    /**
     * 文章点赞
     * @param id
     * @return
     */
    @Transactional
    public int updateThumbup(String id) {
        return articleDao.updateThumbup(id);
    }

    /**
     * 根据Id查询实体
     *
     * @param id
     * @return
     */
    public Article findById(String id) {
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        if (article == null) {
            article = articleDao.findById(id).get();
            //设置缓存过期
            redisTemplate.opsForValue().set("article_" + id, article,10, TimeUnit.SECONDS);
        }
        return article;
    }

    /**
     * 修改
     *
     * @param article
     */
    public void update(Article article) {
        redisTemplate.delete("article_" + article.getId());
        articleDao.save(article);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id) {
        redisTemplate.delete("article_" + id);
        articleDao.deleteById(id);
    }

}
