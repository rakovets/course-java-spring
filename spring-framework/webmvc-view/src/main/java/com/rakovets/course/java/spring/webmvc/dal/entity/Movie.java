package com.rakovets.course.java.spring.webmvc.dal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie extends BaseEntity {

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "release_year")
    @Getter
    @Setter
    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    @Getter
    @Setter
    private Genre genre;
}
