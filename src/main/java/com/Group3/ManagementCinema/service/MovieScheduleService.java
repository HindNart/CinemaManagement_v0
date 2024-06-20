package com.Group3.ManagementCinema.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.MovieSchedule;

public interface MovieScheduleService {
	List<MovieSchedule> getAllMovieSchedules();
	void saveMovieSchedule(String idLichChieu, String phongChieuId, String phimId, Time thoigianBD, Time thoigianKT, Date ngayChieu);
	MovieSchedule getMovieScheduleById(String id);
	void deleteMovieScheduleById(String id);
	Page<MovieSchedule> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}