package com.rakovets.course.java.spring.orm.dal.dao;


import com.rakovets.course.java.spring.orm.dal.dao.common.BaseDao;
import com.rakovets.course.java.spring.orm.dal.entity.Car;

public interface CarDao extends BaseDao<Car> {
    Car findByBrandAndModel(String brand, String model);
}
