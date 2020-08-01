package com.rakovets.course.java.spring.orm.dal.dao.common;

import com.rakovets.course.java.spring.orm.dal.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    void save(T entity);

    List<T> findAll();
}
