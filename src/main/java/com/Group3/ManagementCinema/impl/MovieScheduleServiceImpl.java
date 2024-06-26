package com.Group3.ManagementCinema.impl;

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
	public long countMovieSchedule() {
        return movieScheduleRepository.count();
    }
	@Override
	public List<MovieSchedule> getAllMovieSchedules() {
		return movieScheduleRepository.findAll();
	}

	@Override
	public void saveMovieSchedule(MovieSchedule movieSchedule) {
		this.movieScheduleRepository.save(movieSchedule);
		
	}
	
	@Override
	public void saveMovieSchedule(String idLichChieu, String phongChieuId, String phimId, String thoigianBD, String thoigianKT, Date ngayChieu) {
		CinemaRoom phongChieu = cinemaRoomRepository.findById(phongChieuId).orElseThrow(() -> new RuntimeException("CinemaRoom not found"));
		Movie phim = movieRepository.findById(phimId).orElseThrow(() -> new RuntimeException("Movie not found"));

		MovieSchedule movieSchedule = new MovieSchedule(idLichChieu, phongChieu, phim, thoigianBD, thoigianKT, ngayChieu);
      
		movieScheduleRepository.save(movieSchedule);
	}

	@Override
	public MovieSchedule getMovieScheduleById(String id) {
		Optional < MovieSchedule > optional = movieScheduleRepository.findById(id);
		MovieSchedule movieSchedule = null;
		if (optional.isPresent()) {
			movieSchedule = optional.get();
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

	@Override
	public List<MovieSchedule> checkMS(java.sql.Date date, String tgbd, String tgkt) {
		// TODO Auto-generated method stub
		return movieScheduleRepository.findByNgayChieuAndThoigianBDAndThoigianKT(date, tgbd, tgkt);
	}
	
	
}
