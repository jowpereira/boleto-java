package br.com.moduloboleto.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.moduloboleto.dtos.BoletoTrackingDTO;
import br.com.moduloboleto.entities.BoletoTracking;
import br.com.moduloboleto.services.BoletoTrackingService;

@RestController
@RequestMapping(value="/BoletoTrackings")
public class BoletoTrackingResource {
	
	@Autowired 
	private BoletoTrackingService service;
	
	@GetMapping(value="/{status}")
	public ResponseEntity<?> find(@PathVariable String status){
		
		List<BoletoTracking> obj = service.findByStatus(status);
		
		List<BoletoTrackingDTO> listDTO = new ArrayList<BoletoTrackingDTO>();
		BoletoTrackingDTO boletoTrackingDTO = new BoletoTrackingDTO();
		
		for(BoletoTracking result : obj) {
		  	boletoTrackingDTO.setAjusteId(result.getAjusteId());
		  	boletoTrackingDTO.setStatus(result.getStatus());
		  	boletoTrackingDTO.setCreateTime(result.getCreateTime());
		  	boletoTrackingDTO.setBoletoId(result.getBoleto().getBoletoId());
		  	
		  	listDTO.add(boletoTrackingDTO);
		  	System.out.println(boletoTrackingDTO.getBoletoId());
		    
		}		
		
		return ResponseEntity.ok().body(listDTO);
	}

}
