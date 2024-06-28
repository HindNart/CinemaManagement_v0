package com.Group3.ManagementCinema.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();
	Ticket getTicketById(Long id);
	void deleteTicketById(Long id);
	Page<Ticket> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	Ticket saveTicket(Ticket ticket);
	long countTicket();
	Ticket saveTicket(Long idVe, String idLichChieu, String email, Date thoigianMua);
	Ticket getChairByTicketId(Long ticketId);
}
