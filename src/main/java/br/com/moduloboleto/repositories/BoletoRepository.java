package br.com.moduloboleto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.moduloboleto.entities.Boleto;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Integer>  {
	
}