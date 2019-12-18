package com.raf.cinemamovieservice.service.impl;

import com.raf.cinemamovieservice.domain.Screen;
import com.raf.cinemamovieservice.dto.ScreenCreateDto;
import com.raf.cinemamovieservice.dto.ScreenDto;
import com.raf.cinemamovieservice.exception.NotFoundException;
import com.raf.cinemamovieservice.mapper.ScreenMapper;
import com.raf.cinemamovieservice.repository.ScreenRepository;
import com.raf.cinemamovieservice.service.ScreenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImpl implements ScreenService {

    private ScreenRepository screenRepository;
    private ScreenMapper screenMapper;

    public ScreenServiceImpl(ScreenRepository screenRepository, ScreenMapper screenMapper) {
        this.screenRepository = screenRepository;
        this.screenMapper = screenMapper;
    }

    @Override
    public Page<ScreenDto> findAll(Pageable pageable) {
        return screenRepository.findAll(pageable)
                .map(screenMapper::screenToScreenDto);
    }

    @Override
    public ScreenDto findById(Long id) {
        return screenRepository.findById(id)
                .map(screenMapper::screenToScreenDto)
                .orElseThrow(() -> new NotFoundException(String.format("Screen with id: %d does not exists.", id)));
    }

    @Override
    public ScreenDto add(ScreenCreateDto screenCreateDto) {
        Screen screen = screenMapper.screenCreateDtoToScreen(screenCreateDto);
        screenRepository.save(screen);
        return screenMapper.screenToScreenDto(screen);
    }

    @Override
    public void deleteById(Long id) {
        screenRepository.deleteById(id);
    }

}
