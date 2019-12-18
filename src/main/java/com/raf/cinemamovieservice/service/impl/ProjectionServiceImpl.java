package com.raf.cinemamovieservice.service.impl;


import com.raf.cinemamovieservice.domain.Projection;
import com.raf.cinemamovieservice.dto.ProjectionCreateDto;
import com.raf.cinemamovieservice.dto.ProjectionDto;
import com.raf.cinemamovieservice.exception.NotFoundException;
import com.raf.cinemamovieservice.mapper.ProjectionMapper;
import com.raf.cinemamovieservice.repository.ProjectionRepository;
import com.raf.cinemamovieservice.service.ProjectionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private ProjectionRepository projectionRepository;
    private ProjectionMapper projectionMapper;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository, ProjectionMapper projectionMapper) {
        this.projectionRepository = projectionRepository;
        this.projectionMapper = projectionMapper;
    }

    @Override
    public Page<ProjectionDto> findAll(Pageable pageable) {
        return projectionRepository.findAll(pageable)
                .map(projectionMapper::projectionToProjectionDto);
    }

    @Override
    public ProjectionDto findById(Long id) {
        return projectionRepository.findById(id)
                .map(projectionMapper::projectionToProjectionDto)
                .orElseThrow(() -> new NotFoundException(String.format("Projection with id: %d does not exists.", id)));
    }

    @Override
    public ProjectionDto add(ProjectionCreateDto projectionCreateDto) {
        Projection projection = projectionMapper.projectionCreateDtoToProjection(projectionCreateDto);
        projectionRepository.save(projection);
        return projectionMapper.projectionToProjectionDto(projection);
    }

    @Override
    public void deleteById(Long id) {
        projectionRepository.deleteById(id);
    }
}

