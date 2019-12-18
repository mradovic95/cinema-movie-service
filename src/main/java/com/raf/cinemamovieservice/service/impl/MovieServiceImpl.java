package com.raf.cinemamovieservice.service.impl;

import com.raf.cinemamovieservice.domain.Movie;
import com.raf.cinemamovieservice.dto.MovieCreateDto;
import com.raf.cinemamovieservice.dto.MovieDto;
import com.raf.cinemamovieservice.exception.NotFoundException;
import com.raf.cinemamovieservice.mapper.MovieMapper;
import com.raf.cinemamovieservice.repository.MovieRepository;
import com.raf.cinemamovieservice.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public Page<MovieDto> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable)
                .map(movieMapper::movieToMovieDto);
    }

    @Override
    public MovieDto findById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::movieToMovieDto)
                .orElseThrow(() -> new NotFoundException(String.format("Movie with id: %d does not exists.", id)));
    }

    @Override
    public MovieDto add(MovieCreateDto movieCreateDto) {
        Movie movie = movieMapper.movieCreateDtoToMovie(movieCreateDto);
        movieRepository.save(movie);
        return movieMapper.movieToMovieDto(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
