package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.MovieSchedule;

public interface MovieScheduleService {
	List<MovieSchedule> getAllMovieSchedules();
	void saveMovieSchedule(MovieSchedule movieSchedule);
	MovieSchedule getMovieScheduleById(String id);
	void deleteMovieScheduleById(String id);
	Page<MovieSchedule> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}