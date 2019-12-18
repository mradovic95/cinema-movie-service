package com.raf.cinemamovieservice.repository;

import com.raf.cinemamovieservice.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
