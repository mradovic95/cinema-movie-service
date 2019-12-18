package com.raf.cinemamovieservice.service;

import com.raf.cinemamovieservice.dto.MovieCreateDto;
import com.raf.cinemamovieservice.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    Page<MovieDto> findAll(Pageable pageable);

    MovieDto findById(Long id);

    MovieDto add(MovieCreateDto movieCreateDto);

    void deleteById(Long id);
}
