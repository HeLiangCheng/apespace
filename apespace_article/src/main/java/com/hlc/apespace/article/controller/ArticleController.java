package com.hlc.apespace.article.controller;

import com.hlc.apespace.article.service.ArticleService;
import com.hlc.apespace.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
    *@ClassName ArticleController
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 9:47
    *@Version 1.0
**/
@Api(tags = "文章相关微服务")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "审核文章", notes = "审核文章")
    @PutMapping(value = "/examine/{id}")
    public Result examine(@PathVariable String id) {
        articleService.examine(id);
        return Result.ok();
    }


    @ApiOperation(value = "文章点赞", notes = "文章点赞")
    @PutMapping(value = "/thumbup/{id}")
    public Result updateThumbup(@PathVariable String id) {
        articleService.updateThumbup(id);
        return Result.ok();
    }



}

