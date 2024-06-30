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
	@Query(value = "SELECT lc.phim_id_phim, COUNT(tc.chair_id) " +
            "FROM ticket_chair tc " +
            "JOIN ve v ON tc.ticket_id = v.id_ve " +
            "JOIN lichchieu lc ON v.lich_chieu_id_lich_chieu = lc.id_lich_chieu " +
            "GROUP BY lc.phim_id_phim", nativeQuery = true)
    List<Object[]> countChairsByMovie();
}
