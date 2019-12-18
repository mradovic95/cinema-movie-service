package com.raf.cinemamovieservice.mapper;

import com.raf.cinemamovieservice.domain.Projection;
import com.raf.cinemamovieservice.dto.ProjectionCreateDto;
import com.raf.cinemamovieservice.dto.ProjectionDto;
import com.raf.cinemamovieservice.exception.NotFoundException;
import com.raf.cinemamovieservice.repository.MovieRepository;
import com.raf.cinemamovieservice.repository.ScreenRepository;
import org.springframework.stereotype.Component;

@Component
public class ProjectionMapper {

    private MovieRepository movieRepository;
    private ScreenRepository screenRepository;
    private MovieMapper movieMapper;
    private ScreenMapper screenMapper;

    public ProjectionMapper(MovieRepository movieRepository, ScreenRepository screenRepository, MovieMapper movieMapper, ScreenMapper screenMapper) {
        this.movieRepository = movieRepository;
        this.screenRepository = screenRepository;
        this.movieMapper = movieMapper;
        this.screenMapper = screenMapper;
    }

    public ProjectionDto projectionToProjectionDto(Projection projection) {
        ProjectionDto projectionDto = new ProjectionDto();
        projectionDto.setId(projection.getId());
        projectionDto.setMovieDto(movieMapper.movieToMovieDto(projection.getMovie()));
        projectionDto.setScreenDto(screenMapper.screenToScreenDto(projection.getScreen()));
        projectionDto.setPrice(projection.getPrice());
        return projectionDto;
    }

    public Projection projectionCreateDtoToProjection(ProjectionCreateDto projectionCreateDto) {
        Projection projection = new Projection();
        projection.setMovie(movieRepository.findById(projectionCreateDto.getMovieId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("Movie with id: %d does not exists.", projectionCreateDto.getMovieId()))));
        projection.setScreen(screenRepository.findById(projectionCreateDto.getScreenId())
                .orElseThrow(() -> new NotFoundException(String
                        .format("Screen with id: %d does not exists.", projectionCreateDto.getScreenId()))));
        projection.setPrice(projectionCreateDto.getPrice());
        return projection;
    }
}
