package br.com.moduloboleto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moduloboleto.entities.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Long>  {

}
