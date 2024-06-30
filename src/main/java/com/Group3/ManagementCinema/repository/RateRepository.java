package com.Group3.ManagementCinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long>{
	List<Rate> findByPhimIdPhim(String idPhim);
}
