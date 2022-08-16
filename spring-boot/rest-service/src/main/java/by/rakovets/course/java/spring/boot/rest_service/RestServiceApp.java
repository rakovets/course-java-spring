package by.rakovets.course.java.spring.boot.rest_service;

import by.rakovets.course.java.spring.boot.rest_service.dal.entity.Movie;
import by.rakovets.course.java.spring.boot.rest_service.dal.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return strings -> movieRepository.save(new Movie("The Godfather"));
    }
}
