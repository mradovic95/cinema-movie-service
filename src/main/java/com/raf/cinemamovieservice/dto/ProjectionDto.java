package com.raf.cinemamovieservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProjectionDto {

    private Long id;
    @JsonProperty("movie")
    private MovieDto movieDto;
    @JsonProperty("screen")
    private ScreenDto screenDto;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieDto movieDto) {
        this.movieDto = movieDto;
    }

    public ScreenDto getScreenDto() {
        return screenDto;
    }

    public void setScreenDto(ScreenDto screenDto) {
        this.screenDto = screenDto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
