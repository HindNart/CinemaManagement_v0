package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.CinemaRoom;

public interface CinemaRoomService  {
	List<CinemaRoom> getAllCinemaRooms();
	void saveCinemaRoom(CinemaRoom cinemaRoom);
	CinemaRoom getCinemaRoomById(String id);
	List<CinemaRoom> findCinemaRoom(String keyword);
	void deleteCinemaRoomById(String id);
	Page<CinemaRoom> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long countCinemaRoom();
}