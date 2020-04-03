package br.com.moduloboleto.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.moduloboleto.dtos.BoletoTrackingDTO;
import br.com.moduloboleto.entities.BoletoTracking;
import br.com.moduloboleto.services.BoletoTrackingService;

@RestController
@RequestMapping(value = "/trakingBoletos")
public class BoletoTrackingResource {

	@Autowired
	private BoletoTrackingService service;

	@GetMapping(value = "/alltrackigs/")
	public ResponseEntity<List<BoletoTrackingDTO>> findAll() {
		List<BoletoTracking> list = service.findAll();
		List<BoletoTrackingDTO> listDto = list.stream().map(obj -> new BoletoTrackingDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{status}")
	public ResponseEntity<List<BoletoTrackingDTO>> findTrackingByStatus(@PathVariable String status) {

		List<BoletoTracking> list = service.findByStatus(status);
		List<BoletoTrackingDTO> listDTO = list.stream().map(obj -> new BoletoTrackingDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/findbystatusanddate")
	public ResponseEntity<List<BoletoTrackingDTO>> findTrackingByStatusAndDate(
			@RequestParam(value = "status", defaultValue = "Ativo", required = false) String status,
			@RequestParam(value = "dataini", defaultValue = "null", required = false) String dateini,
			@RequestParam(value = "datafim", defaultValue = "null", required = false) String datefim)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dataini = (Date) format.parse(dateini);
		Date datafim = (Date) format.parse(datefim);
		List<BoletoTracking> list = service.findByStatusAndDate(status, dataini, datafim);
		List<BoletoTrackingDTO> listDTO = list.stream().map(obj -> new BoletoTrackingDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

}
