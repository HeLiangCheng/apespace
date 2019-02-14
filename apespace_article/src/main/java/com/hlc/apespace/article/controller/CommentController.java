package com.hlc.apespace.article.controller;

import com.hlc.apespace.article.entity.Comment;
import com.hlc.apespace.article.service.CommentService;
import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
    *@ClassName CommentController
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 10:32
    *@Version 1.0
**/
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO);
    }

    @GetMapping("/article/{articleid}")
    public Result findByArticleid(@PathVariable String articleid) {
        List<Comment> commentList = commentService.findByArticleid(articleid);
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO, commentList);
    }

    @DeleteMapping("/{articleid}")
    public Result deleteByArticleid(@PathVariable String articleid) {
        commentService.delete(articleid);
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO);
    }

}
