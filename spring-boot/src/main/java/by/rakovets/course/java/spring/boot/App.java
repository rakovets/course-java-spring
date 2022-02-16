package by.rakovets.course.java.spring.boot;

import by.rakovets.course.java.spring.boot.dal.entity.Movie;
import by.rakovets.course.java.spring.boot.dal.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return strings -> movieRepository.save(new Movie("The Godfather"));
    }
}
