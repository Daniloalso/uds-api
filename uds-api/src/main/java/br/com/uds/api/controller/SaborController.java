package br.com.uds.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.api.componentes.ResponseUds;
import br.com.uds.api.service.SaborService;

@RestController
@RequestMapping("/sabor")
public class SaborController {
	
	@Autowired
	private SaborService saborService;
	
	@GetMapping("/todos")	
	public ResponseEntity<ResponseUds> getSabores() {
		return ResponseEntity.ok(new ResponseUds(saborService.getAll()));
		
	}

}
