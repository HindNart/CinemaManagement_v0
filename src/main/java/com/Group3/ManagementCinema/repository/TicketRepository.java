package com.Group3.ManagementCinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Group3.ManagementCinema.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
