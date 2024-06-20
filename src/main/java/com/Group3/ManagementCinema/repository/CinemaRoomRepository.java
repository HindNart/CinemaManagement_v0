package com.Group3.ManagementCinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.CinemaRoom;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, String> {
	List<CinemaRoom> findByLoaiPhongContaining(String loaiPhongKeyword);
}