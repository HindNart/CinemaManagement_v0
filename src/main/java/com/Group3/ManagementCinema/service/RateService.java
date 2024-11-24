package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Rate;

public interface RateService {
	List<Rate> getAllRates();
	Rate getRateById(Long id);
	void deleteRateById(Long id);
	Page<Rate> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	void saveRate(Rate rate);
	void saveRate(Long idDanhGia, String email, Long idPhim, int diem, String binhLuan);
	long countRate();
}
