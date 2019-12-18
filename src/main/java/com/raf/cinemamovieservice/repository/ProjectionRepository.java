package com.raf.cinemamovieservice.repository;

import com.raf.cinemamovieservice.domain.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
}
