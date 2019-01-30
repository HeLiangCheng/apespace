package com.hlc.apespace.base.service;

import com.hlc.apespace.base.entity.Label;
import org.springframework.data.domain.Page;

/**
    *@ClassName LabelService
    *@Description todo
    *@Author Liang
    *@Date 2019/1/28 17:21
    *@Version 1.0
**/
public interface LabelService {

    /**
     * 新增label
     *
     * @param label 对象
     */
    void save(Label label);

    /**
     * 根据Id获取单个Label
     * @param id
     * @return
     */
    Label getLabel(String id);

    /**
     * 分页获取Label列表
     * @param pageSize
     * @param pageIndex
     * @param label
     * @return
     */
    Page<Label> listLabelByPage(int pageSize, int pageIndex, Label label);

    /**
     * 根据条件获取Label数量
     * @param label
     * @return
     */
    long count(Label label);

    /**
     * 根据Id删除Label
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 更新Label对象
     * @param label
     */
    void update(Label label);

}
