package com.Group3.ManagementCinema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findByDaoDienContainingOrDienVienContainingOrTenPhimContainingOrTheLoaiContaining(String key1, String key2, String key3, String key4);
	Movie findByIdPhim(Long id);
	Optional<Movie> findByTenPhim(String tenPhim);
	List<Movie> findByTheLoaiContainingOrQuocGiaContaining(String theLoai, String quocGia);
	List<Movie> findByTheLoaiContainingAndQuocGiaContaining(String theLoai, String quocGia);
}