package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.repository.MovieScheduleRepository;
import com.Group3.ManagementCinema.service.MovieScheduleService;

@Service
public class MovieScheduleServiceImpl implements MovieScheduleService {
	@Autowired
	private MovieScheduleRepository movieScheduleRepository;

	@Override
	public List<MovieSchedule> getAllMovieSchedules() {
		return movieScheduleRepository.findAll();
	}

	@Override
	public void saveMovieSchedule(MovieSchedule movieSchedule) {
		this.movieScheduleRepository.save(movieSchedule);
	}

	@Override
	public MovieSchedule getMovieScheduleById(String id) {
		Optional < MovieSchedule > optional = movieScheduleRepository.findById(id);
		MovieSchedule movieSchedule = null;
		if (optional.isPresent()) {
			movieSchedule = optional.get();
		} else {
			throw new RuntimeException("Cinema room not found for id :: " + id);
		}
		return movieSchedule;
	}

	@Override
	public void deleteMovieScheduleById(String id) {
		this.movieScheduleRepository.deleteById(id);;
		
	}

	@Override
	public Page<MovieSchedule> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
