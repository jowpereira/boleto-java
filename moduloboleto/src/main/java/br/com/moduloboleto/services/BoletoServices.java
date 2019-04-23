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
	
/*	@SuppressWarnings("unchecked")
	public List<Boleto> findBoletoByStatus(String status){
		List<Optional<Boleto>> obj = repo.findByStatus(status);
		Optional<Boleto> newObj;
		
		for(Optional<Boleto> x :obj)
		{
			newObj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + status + ", Tipo: " + x.getClass().getName()));
		}*/
		
	
}
