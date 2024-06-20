package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();
	void saveTicket(Ticket ticket);
	Ticket getTicketById(String id);
	void deleteTicketById(String id);
	Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
