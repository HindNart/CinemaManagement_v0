package com.Group3.ManagementCinema.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Movie;

public interface MovieService {
	List<Movie> getAllMovies();
	void saveMovie(Movie movie);
	Movie getMovieById(Long id);
	void deleteMovieById(Long id);
	Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long countMovie();
	List<Movie> searchMovie (String key);
	
}
