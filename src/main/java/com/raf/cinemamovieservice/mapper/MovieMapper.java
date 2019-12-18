package com.raf.cinemamovieservice.mapper;

import com.raf.cinemamovieservice.domain.Movie;
import com.raf.cinemamovieservice.dto.MovieCreateDto;
import com.raf.cinemamovieservice.dto.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDto movieToMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        return movieDto;
    }

    public Movie movieCreateDtoToMovie(MovieCreateDto movieCreateDto) {
        Movie movie = new Movie();
        movie.setTitle(movieCreateDto.getTitle());
        movie.setDescription(movieCreateDto.getDescription());
        return movie;
    }
}
