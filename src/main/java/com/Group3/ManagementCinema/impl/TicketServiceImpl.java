package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.repository.AccountRepository;
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
	
	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}
	
	@Override
	public Ticket getTicketById(String id) {
		// TODO Auto-generated method stub
		Optional < Ticket > optional = ticketRepository.findById(id);
		Ticket ticket = null;
		if (optional.isPresent()) {
			ticket = optional.get();
		}
		return ticket;
	}
	
	@Override
	public void deleteTicketById(String id) {
		// TODO Auto-generated method stub
		this.ticketRepository.deleteById(id);
	}
	
	@Override
	public Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		this.ticketRepository.save(ticket);
	}
	
	@Override
	public void saveTicket(String idVe, String lichChieuId, String email, float gia, java.sql.Date thoigianMua) {
		// TODO Auto-generated method stub
		MovieSchedule lichChieu = movieScheduleRepository.findById(lichChieuId).orElseThrow(() -> new RuntimeException("MovieSchedule not found"));
		Account taiKhoan = accountRepository.findById(email).orElseThrow(() -> new RuntimeException("Account not found"));

		Ticket ticket = new Ticket(idVe, lichChieu, taiKhoan, gia, thoigianMua);
      
		ticketRepository.save(ticket);
	}
	
	@Override
	public long countTicket() {
		// TODO Auto-generated method stub
		return ticketRepository.count();
	}
}
