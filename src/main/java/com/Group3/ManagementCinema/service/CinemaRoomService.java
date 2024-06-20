package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.entity.Customer;

public interface CinemaRoomService  {
	List<CinemaRoom> getAllCinemaRooms();
	void saveCinemaRoom(CinemaRoom cinemaRoom);
	CinemaRoom getCinemaRoomById(String id);
	void deleteCinemaRoomById(String id);
	List<CinemaRoom> findByRoom(String keyword);
	Page<CinemaRoom> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}