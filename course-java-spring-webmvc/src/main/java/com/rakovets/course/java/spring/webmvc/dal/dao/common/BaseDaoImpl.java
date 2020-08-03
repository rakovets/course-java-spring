package com.rakovets.course.java.spring.webmvc.dal.dao.common;

import com.rakovets.course.java.spring.webmvc.dal.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    @Override
    public T findOne(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(modelClass, id);
    }

    @Override
    public void save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    @Override
    public List<T> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from " + modelClass.getSimpleName(), modelClass).getResultList();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
