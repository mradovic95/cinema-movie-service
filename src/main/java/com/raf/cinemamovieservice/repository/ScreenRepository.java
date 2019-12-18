package com.raf.cinemamovieservice.repository;

import com.raf.cinemamovieservice.domain.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
