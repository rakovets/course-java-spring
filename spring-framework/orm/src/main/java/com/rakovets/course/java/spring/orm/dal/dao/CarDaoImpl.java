package com.rakovets.course.java.spring.orm.dal.dao;

import com.rakovets.course.java.spring.orm.dal.dao.common.BaseDaoImpl;
import com.rakovets.course.java.spring.orm.dal.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDao {

    @Override
    public Car findByBrandAndModel(String brand, String model) {
        List<Car> cars = getSessionFactory().getCurrentSession().createQuery(
                "select c from Car c where c.brand=:brand and c.model=:model", Car.class)
                .setParameter("brand", brand)
                .setParameter("model", model)
                .getResultList();
        return cars.size() > 0 ? cars.get(0) : null;
    }
}
