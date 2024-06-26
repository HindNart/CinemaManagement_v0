package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Rate;
import com.Group3.ManagementCinema.entity.RateId;

public interface RateService {
	List<Rate> getAllRates();
	Rate getRateById(RateId key);
	void deleteRateById(RateId id);
	Page<Rate> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	void saveRate(Rate rate);
	void saveRate(String email, String idPhim, String noiDung);
	long countRate();
	
}
