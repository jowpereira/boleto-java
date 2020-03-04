package br.com.moduloboleto.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.moduloboleto.entities.BoletoTracking;

public interface BoletoTrackingRepository extends JpaRepository<BoletoTracking, Integer>  {
	
	@Query("select a from BoletoTracking a where status = :status")
	public List<BoletoTracking> findByStatus(@Param("status")String status);
	
	@Query("select a from BoletoTracking a where status = :status and create_time >= :dataini and create_time <= :datafim order by create_time, boleto_id asc")
	public List<BoletoTracking> findByStatusAndDate(@Param("status")String status, @Param("dataini")Date dataini, @Param("datafim")Date datafim);
	
}
