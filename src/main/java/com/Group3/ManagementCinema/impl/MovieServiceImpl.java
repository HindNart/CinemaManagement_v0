package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.Rate;
import com.Group3.ManagementCinema.repository.MovieRepository;
import com.Group3.ManagementCinema.repository.RateRepository;
import com.Group3.ManagementCinema.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RateRepository rateRepository;
	
	@Override
	public long countMovie() {
        return movieRepository.count();
    }
	@Override
	public List < Movie > getAllMovies() {
		return movieRepository.findAll();
	}
	
	@Override
	public void saveMovie(Movie movie) {
		this.movieRepository.save(movie);
	}
	
	@Override
	public Movie getMovieById(Long id) {
		Movie movie = movieRepository.findByIdPhim(id);
		return movie;
	}
	
	@Override
	public void deleteMovieById(Long id) {
		this.movieRepository.deleteById(id);
	}
	
	@Override
	public Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Movie> searchMovie(String key) {
		// TODO Auto-generated method stub
		return movieRepository.findByDaoDienContainingOrDienVienContainingOrTenPhimContainingOrTheLoaiContaining(key, key, key, key);
	}
	@Override
	public Movie getMovieByName(String name) {
		Optional < Movie > optional = movieRepository.findByTenPhim(name);
        Movie movie = null;
        if (optional.isPresent()) {
            movie = optional.get();
        }
        return movie;
	}
	@Override
	public List<Movie> getMovieByTheLoaiOrQuocGia(String key) {
		// TODO Auto-generated method stub
		return movieRepository.findByTheLoaiContainingOrQuocGiaContaining(key, key);
	}
	@Override
	public List<Movie> getMovieByTheLoaiAndQuocGia(String theLoai, String quocGia) {
		// TODO Auto-generated method stub
		return movieRepository.findByTheLoaiContainingAndQuocGiaContaining(theLoai, quocGia);
	}
}
