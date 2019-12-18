package com.raf.cinemamovieservice.runner;


import com.raf.cinemamovieservice.domain.Movie;
import com.raf.cinemamovieservice.domain.Projection;
import com.raf.cinemamovieservice.domain.Screen;
import com.raf.cinemamovieservice.repository.MovieRepository;
import com.raf.cinemamovieservice.repository.ProjectionRepository;
import com.raf.cinemamovieservice.repository.ScreenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private MovieRepository movieRepository;
    private ScreenRepository screenRepository;
    private ProjectionRepository projectionRepository;

    public TestDataRunner(MovieRepository movieRepository, ScreenRepository screenRepository, ProjectionRepository projectionRepository) {
        this.movieRepository = movieRepository;
        this.screenRepository = screenRepository;
        this.projectionRepository = projectionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //insert movies
        Movie movie1 = movieRepository.save(new Movie("movie 1", "description movie 1"));
        Movie movie2 = movieRepository.save(new Movie("movie 2", "description movie 2"));
        //insert screens
        Screen screen1 = screenRepository.save(new Screen(20));
        Screen screen2 = screenRepository.save(new Screen(30));
        //insert projections
        projectionRepository.save(new Projection(movie1, screen1, BigDecimal.TEN));
        projectionRepository.save(new Projection(movie1, screen2, BigDecimal.TEN));
        projectionRepository.save(new Projection(movie2, screen2, BigDecimal.TEN));
    }
}
