package com.Group3.ManagementCinema.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;

@Repository
public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, Long>{
	MovieSchedule findByNgayChieuAndThoigianBDAndThoigianKTAndPhongChieu(Date date, String tgbd, String tgkt, CinemaRoom phongchieu);
	List<MovieSchedule> findByPhim(Movie phim);
	List<MovieSchedule> findByPhimTenPhimContaining(String tenPhim);
	List<MovieSchedule> findAll();
	List<MovieSchedule> findByNgayChieuAndPhongChieu(Date date, CinemaRoom phongchieu);
}
