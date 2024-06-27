package com.Group3.ManagementCinema.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();
	Ticket getTicketById(long id);
	void deleteTicketById(long id);
	Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	void saveTicket(Ticket ticket);
	void saveTicket(long idVe, String lichChieuId, String email, float gia, Date thoigianMua);
	long countTicket();
}
