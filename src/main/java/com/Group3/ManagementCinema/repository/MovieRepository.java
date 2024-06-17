package com.Group3.ManagementCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String>{
	
}