package com.hlc.apespace.spitslot.controller;

import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.common.entity.ResultPage;
import com.hlc.apespace.spitslot.entity.Spitslot;
import com.hlc.apespace.spitslot.service.SpitslotService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
    *@ClassName SpitslotController
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 14:12
    *@Version 1.0
**/
@RestController
@RequestMapping("/spitslot")
@CrossOrigin
@Api(tags = "吐槽服务")
public class SpitslotController {

    @Autowired
    private SpitslotService spitslotService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping("/")
    public Result findAll() {
        List<Spitslot> spitslots = spitslotService.findAll();
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO, spitslots);
    }

    /**
     * 根据Id获取单个数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findOne(@PathVariable String id) {
        Spitslot spitslot = spitslotService.findById(id);
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO, spitslot);
    }

    /**
     * 新增吐槽
     * @param spitslot
     * @return
     */
    @PostMapping("/")
    public Result add(@RequestBody Spitslot spitslot) {
        spitslotService.add(spitslot);
        return Result.ok();
    }

    /**
     * 更新吐槽信息
     * @param spitslot
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Spitslot spitslot,@PathVariable(name = "id") String id) {
        spitslot.set_id(id);
        spitslotService.update(spitslot);
        return Result.ok();
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(name = "id") String id) {
        spitslotService.deleteById(id);
        return Result.ok();
    }

    @GetMapping("/comment/{parentId}/{page}/{size}")
    public ResultPage<Spitslot> findByParentid(@PathVariable(name = "parentId") String parentId,
                                  @PathVariable(name="page") int page,
                                  @PathVariable(name = "size") int size) {
        Page<Spitslot> spitpage = spitslotService.findByParentId(parentId, size, page);
        ResultPage<Spitslot> resultPage = new ResultPage(StatusCode.OK, StatusCode.OK_INFO, spitpage.getTotalElements(), spitpage.getContent(), spitpage.getNumber(), spitpage.getSize());
        return resultPage;
    }


    @PutMapping("/thumbup/{userid}/{id}")
    public Result updateThumbup(@PathVariable(name = "userid") String userid,@PathVariable(name = "id") String id) {
        if (redisTemplate.opsForValue().get("spitslot_" + userid + id) != null) {
            return new Result(false, StatusCode.ERROR, "你已经点赞过了", null);
        }
        spitslotService.updateThumbup(id);
        redisTemplate.opsForValue().set("spitslot_" + userid + id, "1");
        return Result.ok();
    }


}
