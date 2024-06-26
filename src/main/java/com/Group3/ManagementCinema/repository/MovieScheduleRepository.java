package com.Group3.ManagementCinema.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Group3.ManagementCinema.entity.MovieSchedule;

@Repository
public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, String>{
	List<MovieSchedule> findByNgayChieuAndThoigianBDAndThoigianKT(Date date, String tgbd, String tgkt);
}
