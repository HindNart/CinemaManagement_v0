package com.Group3.ManagementCinema.impl;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.repository.CinemaRoomRepository;
import com.Group3.ManagementCinema.repository.MovieRepository;
import com.Group3.ManagementCinema.repository.MovieScheduleRepository;
import com.Group3.ManagementCinema.service.MovieScheduleService;

@Service
public class MovieScheduleServiceImpl implements MovieScheduleService {
	@Autowired
	private MovieScheduleRepository movieScheduleRepository;
	@Autowired
	private CinemaRoomRepository cinemaRoomRepository;
	@Autowired
    private MovieRepository movieRepository;

	@Override
	public List<MovieSchedule> getAllMovieSchedules() {
		return movieScheduleRepository.findAll();
	}

	@Override
	public void saveMovieSchedule(String idLichChieu, String phongChieuId, String phimId, Time thoigianBD, Time thoigianKT, Date ngayChieu) {
		CinemaRoom phongChieu = cinemaRoomRepository.findById(phongChieuId).orElseThrow(() -> new RuntimeException("CinemaRoom not found"));
		Movie phim = movieRepository.findById(phimId).orElseThrow(() -> new RuntimeException("Movie not found"));

		MovieSchedule movieSchedule = new MovieSchedule(idLichChieu, phongChieu, phim, thoigianBD, thoigianKT, (java.sql.Date) ngayChieu);
      
		movieScheduleRepository.save(movieSchedule);
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