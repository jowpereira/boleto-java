package br.com.moduloboleto.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moduloboleto.entities.BoletoTracking;
import br.com.moduloboleto.repositories.BoletoTrackingRepository;

@Service
public class BoletoTrackingService {

	@Autowired
	private BoletoTrackingRepository repoBoletoTracking;
	
	public List<BoletoTracking> findByStatus(String stuatus) {
		return this.repoBoletoTracking.findByStatus(stuatus);
	}
	
	public List<BoletoTracking> findByStatusAndDate(String stuatus, Date dataini, Date datafim) {
		return this.repoBoletoTracking.findByStatusAndDate(stuatus, dataini, datafim);
	}

	public List<BoletoTracking> findAll() {
		return this.repoBoletoTracking.findAll();
}
	
}
