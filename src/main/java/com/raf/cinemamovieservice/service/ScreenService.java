package com.raf.cinemamovieservice.service;


import com.raf.cinemamovieservice.dto.ScreenCreateDto;
import com.raf.cinemamovieservice.dto.ScreenDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScreenService {

    Page<ScreenDto> findAll(Pageable pageable);

    ScreenDto findById(Long id);

    ScreenDto add(ScreenCreateDto screenCreateDto);

    void deleteById(Long id);
}
