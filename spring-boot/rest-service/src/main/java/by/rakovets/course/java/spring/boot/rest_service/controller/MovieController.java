package by.rakovets.course.java.spring.boot.rest_service.controller;

import by.rakovets.course.java.spring.boot.rest_service.dal.entity.Movie;
import by.rakovets.course.java.spring.boot.rest_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @GetMapping("{id}")
    public Movie getById(@PathVariable("id") Long id) {
        return movieService.findOne(id);
    }
}
