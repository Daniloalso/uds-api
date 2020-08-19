 package br.com.uds.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.api.componentes.ResponseUds;
import br.com.uds.api.service.TamanhoService;

@RestController
@RequestMapping("/tamanhos")
public class TamanhoController {
	
	@Autowired
	private TamanhoService tamanhoService;
	
	@GetMapping("/todos")	
	public ResponseEntity<ResponseUds> getTamanhos() {
		return ResponseEntity.ok(new ResponseUds(tamanhoService.getAll()));
		
	}
}
