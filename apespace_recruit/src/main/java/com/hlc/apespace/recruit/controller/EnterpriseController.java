package com.hlc.apespace.recruit.controller;

import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.recruit.entity.Enterprise;
import com.hlc.apespace.recruit.service.EnterpriseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
    *@ClassName EnterpriseController
    *@Description 热门企业控制器
    *@Author Liang
    *@Date 2019/1/29 14:47
    *@Version 1.0
**/
@RestController
@RequestMapping("/enterprise")
@Api(tags = "热门企业控制器")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @ApiOperation(value = "热门企业列表获取", notes = "热门企业列表获取")
    @GetMapping(value = "/search/hotlist")
    public Result hotlist() {
        List<Enterprise> enterpriseList = enterpriseService.hotlist();
        Result result = new Result();
        result.setFlag(true);
        result.setCode(StatusCode.OK);
        result.setMessage(StatusCode.OK_INFO);
        result.setData(enterpriseList);
        return result;
    }


}
