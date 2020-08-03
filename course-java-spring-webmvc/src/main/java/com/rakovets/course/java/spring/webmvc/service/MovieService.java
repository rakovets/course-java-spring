package com.rakovets.course.java.spring.webmvc.service;

import com.rakovets.course.java.spring.webmvc.dal.entity.Movie;

public interface MovieService {
    Long save(Movie movie);

    Movie findById(Long movieId);
}
