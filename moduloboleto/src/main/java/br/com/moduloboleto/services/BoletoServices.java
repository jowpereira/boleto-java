package br.com.moduloboleto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moduloboleto.entities.Boleto;
import br.com.moduloboleto.repositories.BoletoRepository;
import br.com.moduloboleto.services.exceptions.ObjectNotFoundException;

@Service
public class BoletoServices {

	@Autowired
	private BoletoRepository repo;

	public Boleto find(Integer id) {
		Optional<Boleto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Boleto.class.getName()));
	}
	
	public List<Boleto> findAll() {
		return this.repo.findAll();
	}
		
}
