package com.Group3.ManagementCinema.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.entity.MovieSchedule;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	List<Ticket> findByIdLichChieu(MovieSchedule id);
	
	@Query(value = """
	    SELECT m.month, COALESCE(t.ticket_count, 0) AS ticket_count
	    FROM (
	        SELECT 1 AS month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
	        UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8
	        UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12
	    ) m
	    LEFT JOIN (
	        SELECT MONTH(thoigian_mua) AS month, COUNT(*) AS ticket_count
	        FROM ve
	        GROUP BY MONTH(thoigian_mua)
	    ) t ON m.month = t.month ORDER BY m.month;
	""", nativeQuery = true)
	List<Object[]> countTicketsByMonth();
	
	@Query(value = """
		SELECT m.month, COALESCE(SUM(g.gia_ghe), 0) AS total_price
		FROM (
			SELECT 1 AS month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
			UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8
			UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12
		) m
		LEFT JOIN ve v ON EXTRACT(MONTH FROM v.thoigian_mua) = m.month
		LEFT JOIN ghe g ON v.id_ghe = g.id_ghe GROUP BY m.month ORDER BY m.month;
	""", nativeQuery = true)
	List<Object[]> priceOnMonth();
	
	@Query(value = """
		SELECT SUM(g.gia_ghe) FROM ve v JOIN ghe g ON v.id_ghe = g.id_ghe;
	""", nativeQuery = true)
	BigDecimal totalRevenue();
}
