package com.Group3.ManagementCinema.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.repository.AccountRepository;
import com.Group3.ManagementCinema.repository.ChairRepository;
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
	public List<Map<String, Object>> getTicketCountByMovieName() {
        return ticketRepository.findTicketCountByMovieName();
    }
	
}
