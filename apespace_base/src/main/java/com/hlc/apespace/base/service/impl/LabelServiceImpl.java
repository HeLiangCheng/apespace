package com.hlc.apespace.base.service.impl;

import com.hlc.apespace.base.dao.LabelDao;
import com.hlc.apespace.base.entity.Label;
import com.hlc.apespace.base.service.LabelService;
import com.hlc.apespace.common.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
    *@ClassName LabelServiceImpl
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 9:03
    *@Version 1.0
**/
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    @Override
    public Label getLabel(String id) {
        return labelDao.getOne(id);
    }

    @Override
    public Page<Label> listLabelByPage(int pageSize, int pageIndex, Label label) {
        Specification<Label> specification = new Specification<Label>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>(5);
                if (StringUtils.isNotEmpty(label.getLabelname())) {
                    predicateList.add(cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%"));
                }
                if (StringUtils.isNotEmpty(label.getState())) {
                    predicateList.add(cb.equal(root.get("state").as(String.class), label.getState()));
                }
                if (StringUtils.isNotEmpty(label.getRecommend())) {
                    predicateList.add(cb.equal(root.get("recommend").as(String.class), label.getRecommend()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        PageRequest page = PageRequest.of(pageIndex - 1, pageSize);
        return labelDao.findAll(specification, page);
    }

    @Override
    public long count(Label label) {
        Specification<Label> specification = new Specification<Label>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>(5);
                if (StringUtils.isNotEmpty(label.getLabelname())) {
                    predicateList.add(cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%"));
                }
                if (StringUtils.isNotEmpty(label.getState())) {
                    predicateList.add(cb.equal(root.get("state").as(String.class), label.getState()));
                }
                if (StringUtils.isNotEmpty(label.getRecommend())) {
                    predicateList.add(cb.equal(root.get("recommend").as(String.class), label.getRecommend()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return labelDao.count(specification);
    }

    @Override
    public void delete(String id) {
        labelDao.deleteById(id);
    }

    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

}
