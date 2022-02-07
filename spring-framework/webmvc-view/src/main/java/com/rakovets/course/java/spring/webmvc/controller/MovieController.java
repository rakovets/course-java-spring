package com.rakovets.course.java.spring.webmvc.controller;

import com.rakovets.course.java.spring.webmvc.dal.entity.Movie;
import com.rakovets.course.java.spring.webmvc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/movie")
    public String showMovieForm() {
        return "movie-form";
    }

    @PostMapping(path = "/movie")
    public String saveMovie(Movie movie, Model model) {
        Long id = movieService.save(movie);
        model.addAttribute("movieId", id);
        return "redirect:/movie-info/{movieId}";
    }

    // /movie-info/4
    @GetMapping(path = "/movie-info/{movieId}")
    public String showMovieInfo(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.findById(movieId);
        model.addAttribute("movie", movie);
        return "movie-info";
    }
}
