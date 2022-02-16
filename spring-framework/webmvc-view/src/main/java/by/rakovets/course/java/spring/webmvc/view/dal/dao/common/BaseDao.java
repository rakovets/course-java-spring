package by.rakovets.course.java.spring.webmvc.view.dal.dao.common;

import by.rakovets.course.java.spring.webmvc.view.dal.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    T findOne(Long id);

    void save(T entity);

    List<T> findAll();
}
