package br.com.moduloboleto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.moduloboleto.dtos.BoletoDTO;
import br.com.moduloboleto.entities.Boleto;
import br.com.moduloboleto.services.BoletoServices;

@RestController
@RequestMapping(value = "/boletos")
public class BoletoResource {

	@Autowired
	private BoletoServices service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Boleto> find(@PathVariable Integer id) {
		Boleto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<BoletoDTO>> findAll() {
		List<Boleto> list = service.findAll();
		List<BoletoDTO> listDto = list.stream().map(obj -> new BoletoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
