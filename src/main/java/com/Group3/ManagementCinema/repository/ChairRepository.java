package com.Group3.ManagementCinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.CinemaRoom;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Integer> {
	List<Chair> findByIdPhong(CinemaRoom loaiPhongKeyword);
	Chair findByHangGheAndIdPhongAndGheSo(String hangGhe, CinemaRoom idPhong, int gheSo);
}
