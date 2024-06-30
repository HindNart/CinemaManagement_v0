package com.Group3.ManagementCinema.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.repository.AccountRepository;
import com.Group3.ManagementCinema.repository.ChairRepository;
import com.Group3.ManagementCinema.repository.MovieRepository;
import com.Group3.ManagementCinema.repository.MovieScheduleRepository;
import com.Group3.ManagementCinema.repository.TicketRepository;
import com.Group3.ManagementCinema.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private MovieScheduleRepository movieScheduleRepository;
	@Autowired
    private AccountRepository accountRepository;
	@Autowired
    private ChairRepository chairRepository;
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}
	
	@Override
	public Ticket getTicketById(Long id) {
		// TODO Auto-generated method stub
		Optional < Ticket > optional = ticketRepository.findById(id);
		Ticket ticket = null;
		if (optional.isPresent()) {
			ticket = (optional.get());
		}
		return ticket;
	}
	
	@Override
	public void deleteTicketById(Long id) {
		// TODO Auto-generated method stub
		this.ticketRepository.deleteById(id);
	}
	
	@Override
	public Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Ticket saveTicket(Ticket ticket) {
		return this.ticketRepository.save(ticket);
	}
	
	@Override
	public long countTicket() {
		// TODO Auto-generated method stub
		return ticketRepository.count();
	}

	@Override
	public Ticket saveTicket(Long idVe, String lichChieuId, String email, Long idGhe, Date thoigianMua) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTicket(long idVe, String lichChieuId, String email, float gia, Date thoigianMua, List<Chair> list) {
		// TODO Auto-generated method stub
		
	}
	@Override
    public List<Map<String, Object>> getTicketCountByMovieName() {
        List<Object[]> results = ticketRepository.countChairsByMovie();
        List<Map<String, Object>> ticketCountByMovie = new ArrayList<>();
        
        for (Object[] result : results) {
            String movieId = (String) result[0];
            Long ticketCount = ((Number) result[1]).longValue();

            // Get movie name by movie id
            Optional<Movie> movieOpt = movieRepository.findById(movieId);
            String movieName = movieOpt.map(Movie::getTenPhim).orElse("Unknown");

            Map<String, Object> map = new HashMap<>();
            map.put("tenPhim", movieName);
            map.put("soLuongVe", ticketCount);
            ticketCountByMovie.add(map);
        }
        
        return ticketCountByMovie;
    }
	
}
