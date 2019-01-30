package com.hlc.apespace.recruit.controller;

import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.recruit.entity.Recruit;
import com.hlc.apespace.recruit.service.RecruitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
    *@ClassName RecruitController
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 15:01
    *@Version 1.0
**/
@RestController
@RequestMapping("/recruit")
@Api(tags = "招聘控制器")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @ApiOperation(value = "招聘列表获取", notes = "招聘列表获取")
    @GetMapping(value = "/search/newlist")
    public Result recommend() {
        List<Recruit> list = recruitService.listLatestByStateOrder("2");
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO, list);
    }



}
