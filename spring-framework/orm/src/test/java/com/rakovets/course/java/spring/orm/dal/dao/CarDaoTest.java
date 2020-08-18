package com.rakovets.course.java.spring.orm.dal.dao;

import com.rakovets.course.java.spring.orm.dal.entity.Car;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@Transactional
public class CarDaoTest {
    @Autowired
    private CarDao carDao;

    @BeforeAll
    static void init() {
        // ....
    }

    @Test
    @Rollback(value = false)
    void testFindByBrandAndModel() {
        Car car = new Car();
        car.setBrand("Toyota");
        car.setModel("Corolla");
        carDao.save(car);

        Car foundCar = carDao.findByBrandAndModel("Toyota", "Corolla");
        assertNotNull(foundCar);
    }

    @AfterAll
    static void finish() {
        // ...
    }
}
