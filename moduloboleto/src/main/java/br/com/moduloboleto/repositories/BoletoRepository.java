package br.com.moduloboleto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.moduloboleto.entities.Boleto;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Integer>  {
	
	@Query("select b from Boleto b inner join BoletoTracking c on b.boleto_id = c.boleto_id where c.status = :status")
	public List<Optional<Boleto>> findByStatus(@Param("status") String status);
	
}