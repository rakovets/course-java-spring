package com.rakovets.course.java.spring.webmvc.dal.dao.common;

import com.rakovets.course.java.spring.webmvc.dal.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    T findOne(Long id);

    void save(T entity);

    List<T> findAll();
}
