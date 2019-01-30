package com.hlc.apespace.faqs.controller;

import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.common.entity.ResultPage;
import com.hlc.apespace.faqs.entity.Problem;
import com.hlc.apespace.faqs.service.ProblemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
    *@ClassName ProblemController
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 16:55
    *@Version 1.0
**/
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 最新问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "最新问题列表", notes = "最新问题列表")
    @GetMapping(value = "/newlist/{labelid}/{page}/{size}")
    public Result findNewList(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pagelist = problemService.findNewListByLabelId(labelid, page, size);
        ResultPage<Problem> pageResult = new ResultPage<Problem>();
        pageResult.setRows(pagelist.getContent());
        pageResult.setTotal(pagelist.getTotalElements());
        pageResult.setPageSize(size);
        pageResult.setPageIndex(page);
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }


    /**
     * 热门问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "热门问题列表", notes = "热门问题列表")
    @GetMapping(value = "/hotlist/{labelid}/{page}/{size}")
    public Result findHotList(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pagelist = problemService.findHotListbyLabelId(labelid, page, size);
        ResultPage<Problem> pageResult = new ResultPage<Problem>();
        pageResult.setRows(pagelist.getContent());
        pageResult.setTotal(pagelist.getTotalElements());
        pageResult.setPageSize(size);
        pageResult.setPageIndex(page);
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }


    /**
     * 等待回答的问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "等待回答的问题列表", notes = "等待回答的问题列表")
    @GetMapping(value = "/waitlist/{labelid}/{page}/{size}")
    public Result findWaitList(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pagelist = problemService.findWaitListbyLabelId(labelid, page, size);
        ResultPage<Problem> pageResult = new ResultPage<Problem>();
        pageResult.setRows(pagelist.getContent());
        pageResult.setTotal(pagelist.getTotalElements());
        pageResult.setPageSize(size);
        pageResult.setPageIndex(page);
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }


}
