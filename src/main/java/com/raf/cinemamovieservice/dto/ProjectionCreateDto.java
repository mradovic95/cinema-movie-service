package com.raf.cinemamovieservice.dto;

import java.math.BigDecimal;

public class ProjectionCreateDto {

    private Long movieId;
    private Long screenId;
    private BigDecimal price;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
