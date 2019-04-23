package br.com.moduloboleto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moduloboleto.entities.BoletoTracking;

public interface BoletoTrackingRepository extends JpaRepository<BoletoTracking, Long>  {

}
