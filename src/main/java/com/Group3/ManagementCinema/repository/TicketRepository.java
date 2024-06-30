package com.Group3.ManagementCinema.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	@Query("SELECT new map(m.phim.tenPhim as tenPhim, COUNT(t.idVe) as soLuongVe) " +
	           "FROM Ticket t JOIN t.lichChieu l JOIN l.phim m " +
	           "GROUP BY m.phim.tenPhim")
	    List<Map<String, Object>> findTicketCountByMovieName();
}
