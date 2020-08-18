package com.rakovets.course.java.spring.orm.dal.dao;

import com.rakovets.course.java.spring.orm.dal.entity.Knight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@Transactional
public class KnightDaoTest {
    @Autowired
    private KnightDao knightDao;

    @Test
    void testFindByName() {
        Knight knight = new Knight();
        knight.setName("Arthur");

        knightDao.save(knight);

        Knight arthur = knightDao.findByName("Arthur");
        assertNotNull(arthur);
    }
}
