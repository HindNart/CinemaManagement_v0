package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.CinemaRoom;


public interface ChairService {
	List<Chair> getAllChair();
	void saveChair(Chair chair);
	Chair getChairById(int id);
	void deleteChair(int id);
	Page<Chair> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List<Chair> findAllByIdPhong(CinemaRoom loaiPhongKeyword);
	Chair findByHangGheAndIdPhongAndGheSo(String hangghe, CinemaRoom idPhong, int gheSo);
}
