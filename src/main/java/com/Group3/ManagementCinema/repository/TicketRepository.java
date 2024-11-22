package com.Group3.ManagementCinema.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
}
