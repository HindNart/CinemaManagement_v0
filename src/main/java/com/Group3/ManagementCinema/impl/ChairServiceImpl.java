package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.repository.ChairRepository;
import com.Group3.ManagementCinema.service.ChairService;
@Service
public class ChairServiceImpl implements ChairService{
	@Autowired
	private ChairRepository chairRepository;
	
	@Override
	public List<Chair> getAllChair() {
		return chairRepository.findAll();
	}

	@Override
	public void saveChair(Chair chair) {
		this.chairRepository.save(chair);
	}

	@Override
	public Chair getChairById(int id) {
		Optional < Chair > optional = chairRepository.findById(id);
		Chair chair = null;
		if (optional.isPresent()) {
			chair = optional.get();
		} else {
			throw new RuntimeException("Chair not found for id :: " + id);
		}
		return chair;
	}

	@Override
	public void deleteChair(int id) {
		this.chairRepository.deleteById(id);
	}

	@Override
	public Page<Chair> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

}
