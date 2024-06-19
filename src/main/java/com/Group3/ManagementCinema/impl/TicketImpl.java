package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.repository.TicketRepository;
import com.Group3.ManagementCinema.service.TicketService;

@Service
public class TicketImpl  implements TicketService {
	@Autowired
	private TicketRepository TicketRepository;
	
	@Override
	public List < Ticket > getAllTickets() {
		return TicketRepository.findAll();
	}
	
	@Override
	public void saveTicket(Ticket Ticket) {
		this.TicketRepository.save(Ticket);
	}
	
	@Override
	public Ticket getTicketById(String id) {
		Optional < Ticket > optional = TicketRepository.findById(id);
		Ticket Ticket = null;
		if (optional.isPresent()) {
			Ticket = optional.get();
		} else {
			throw new RuntimeException("Ticket not found for id :: " + id);
		}
		return Ticket;
	}
	
	@Override
	public void deleteTicketById(String id) {
		this.TicketRepository.deleteById(id);
	}
	
	@Override
	public Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	// TODO Auto-generated method stub
		return null;
	}
}
