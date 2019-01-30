package com.hlc.apespace.base.controller;

import com.hlc.apespace.base.entity.Label;
import com.hlc.apespace.base.service.LabelService;
import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.common.entity.ResultPage;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
    *@ClassName LabelController
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 9:42
    *@Version 1.0
**/
@Api(tags = "基础服务-label管理器")
@RequestMapping("/label")
@RestController
public class LabelController {

    @Autowired
    private LabelService labelService;

    @ApiOperation(value = "分页获取label列表", notes = "分页获取label列表")
    @GetMapping("/")
    public ResultPage<Label> list(@RequestParam(value = "index",required = true,defaultValue = "1") int pageindex,
                                   @RequestParam(value = "size",required = true,defaultValue = "10") int pageSize,
                                   @RequestParam(value = "labelname",required = false) String labelname,
                                   @RequestParam(value = "recommend",required = false) String recommend,
                                   @RequestParam(value = "state",required = false) String state) {
        Label label = new Label();
        label.setLabelname(labelname);
        label.setRecommend(recommend);
        label.setState(state);
        Page<Label> labelPage = labelService.listLabelByPage(pageSize, pageindex, label);
        //封装分页对象
        ResultPage<Label> resultPage = new ResultPage<Label>();
        resultPage.setCode(StatusCode.OK);
        resultPage.setMessage(StatusCode.OK_INFO);
        resultPage.setRows(labelPage.getContent());
        resultPage.setTotal(labelPage.getTotalElements());
        resultPage.setPageIndex(labelPage.getNumber());
        resultPage.setPageSize(labelPage.getSize());
        return resultPage;
    }


    @ApiOperation(value = "根据Id获取label数据", notes = "根据Id获取label数据")
    @GetMapping("/{id}")
    public Result findById(@PathVariable(value = "id") String id) {
        Label label = labelService.getLabel(id);
        Result result = new Result();
        result.setFlag(true);
        result.setCode(StatusCode.OK);
        result.setMessage(StatusCode.OK_INFO);
        result.setData(label);
        return result;
    }

    @ApiOperation(value = "保存或者更新label", notes = "保存或者更新label")
    @PostMapping("/")
    public Result save(@RequestBody Label label) {
        if (StringUtils.isEmpty(label.getId())) {
            labelService.save(label);
            return Result.ok();
        } else {
            labelService.update(label);
            return Result.ok();
        }
    }

    @ApiOperation(value = "根据Id删除label", notes = "根据Id删除label")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(value = "id") String id) {
        labelService.delete(id);
        return Result.ok();
    }

}
