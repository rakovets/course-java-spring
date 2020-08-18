package com.rakovets.course.java.spring.orm.dal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "knights")
@ToString(callSuper = true)
public class Knight extends BaseEntity {

    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}
