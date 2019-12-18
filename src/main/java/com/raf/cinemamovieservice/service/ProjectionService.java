package com.raf.cinemamovieservice.service;

import com.raf.cinemamovieservice.dto.ProjectionCreateDto;
import com.raf.cinemamovieservice.dto.ProjectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectionService {

    Page<ProjectionDto> findAll(Pageable pageable);

    ProjectionDto findById(Long id);

    ProjectionDto add(ProjectionCreateDto projectionCreateDto);

    void deleteById(Long id);
}
