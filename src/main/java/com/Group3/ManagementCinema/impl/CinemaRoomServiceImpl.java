package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.repository.CinemaRoomRepository;
import com.Group3.ManagementCinema.service.CinemaRoomService;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService {
	@Autowired
	private CinemaRoomRepository cinemaRoomRepository;
	
	@Override
	public List < CinemaRoom > getAllCinemaRooms() {
		return cinemaRoomRepository.findAll();
	}
	
	@Override
	public void saveCinemaRoom(CinemaRoom cinemaRoom) {
		this.cinemaRoomRepository.save(cinemaRoom);
	}
	
	@Override
	public CinemaRoom getCinemaRoomById(String id) {
		Optional < CinemaRoom > optional = cinemaRoomRepository.findById(id);
		CinemaRoom cinemaRoom = null;
		if (optional.isPresent()) {
			cinemaRoom = optional.get();
		} else {
			throw new RuntimeException("Cinema room not found for id :: " + id);
		}
		return cinemaRoom;
	}
	
	@Override
	public void deleteCinemaRoomById(String id) {
		this.cinemaRoomRepository.deleteById(id);
	}
	
	@Override
	public Page< CinemaRoom > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	// TODO Auto-generated method stub
		return null;
	}
}
