package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.Rate;
import com.Group3.ManagementCinema.repository.AccountRepository;
import com.Group3.ManagementCinema.repository.MovieRepository;
import com.Group3.ManagementCinema.repository.RateRepository;
import com.Group3.ManagementCinema.service.RateService;

@Service
public class RateServiceImpl implements RateService {
	@Autowired
	private RateRepository rateRepository;
	@Autowired
    private AccountRepository accountRepository;
	@Autowired
    private MovieRepository movieRepository;
	
	@Override
	public List<Rate> getAllRates() {
		// TODO Auto-generated method stub
		return rateRepository.findAll();
	}

	@Override
	public Rate getRateById(Long id) {
		// TODO Auto-generated method stub
		Optional < Rate > optional = rateRepository.findById(id);
		Rate rate = null;
		if (optional.isPresent()) {
			rate = optional.get();
		}
		return rate;
	}

	@Override
	public void deleteRateById(Long id) {
		// TODO Auto-generated method stub
		this.rateRepository.deleteById(id);
	}

	@Override
	public Page<Rate> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRate(Rate rate) {
		// TODO Auto-generated method stub
		this.rateRepository.save(rate);
	}

	@Override
	public void saveRate(Long idDanhGia, String email, String idPhim, int diem, String binhLuan) {
		// TODO Auto-generated method stub
		Account taiKhoan = accountRepository.findById(email).orElseThrow(() -> new RuntimeException("Account not found"));
		Movie phim = movieRepository.findById(idPhim).orElseThrow(() -> new RuntimeException("Movie not found"));

		Rate rate = new Rate(idDanhGia, taiKhoan, phim, diem, binhLuan);
      
		rateRepository.save(rate);
	}

	@Override
	public long countRate() {
		// TODO Auto-generated method stub
		return rateRepository.count();
	}
	
}
