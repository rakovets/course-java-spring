package com.rakovets.course.java.spring.security.dal.dao.common;

import java.util.List;

public interface BaseDao<T> {
    T findOne(Long id);

    void save(T entity);

    List<T> findAll();
}
