package com.rakovets.course.java.spring.orm.dal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "brand")
    @Getter
    @Setter
    private String brand;

    @Column(name = "model")
    @Getter
    @Setter
    private String model;
}
