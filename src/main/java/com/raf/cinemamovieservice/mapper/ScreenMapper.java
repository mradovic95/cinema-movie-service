package com.raf.cinemamovieservice.mapper;

import com.raf.cinemamovieservice.domain.Screen;
import com.raf.cinemamovieservice.dto.ScreenCreateDto;
import com.raf.cinemamovieservice.dto.ScreenDto;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {

    public ScreenDto screenToScreenDto(Screen screen) {
        ScreenDto screenDto = new ScreenDto();
        screenDto.setId(screen.getId());
        screenDto.setNumberOfSeats(screen.getNumberOfSeats());
        return screenDto;
    }

    public Screen screenCreateDtoToScreen(ScreenCreateDto screenCreateDto) {
        Screen screen = new Screen();
        screen.setNumberOfSeats(screenCreateDto.getNumberOfSeats());
        return screen;
    }
}

