package by.rakovets.course.java.spring.boot.service.impl;

import by.rakovets.course.java.spring.boot.dal.entity.Movie;
import by.rakovets.course.java.spring.boot.dal.repository.MovieRepository;
import by.rakovets.course.java.spring.boot.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MovieServiceBase implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceBase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie findOne(Long id) {
        return movieRepository.findById(id).orElseThrow();
    }
}
