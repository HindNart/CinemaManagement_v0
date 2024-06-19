package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Chair;


public interface ChairService {
	List<Chair> getAllChair();
	void saveChair(Chair chair);
	Chair getChairById(int id);
	void deleteChair(int id);
	Page<Chair> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
