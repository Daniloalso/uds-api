package br.com.uds.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.api.componentes.ErrorResponseUds;
import br.com.uds.api.componentes.ResponseUds;
import br.com.uds.api.exception.PedidoException;
import br.com.uds.api.model.Pedido;
import br.com.uds.api.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	public static final Logger log = LoggerFactory.getLogger(PedidoController.class);
	
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Pedido> savePedido(@Valid @RequestBody Pedido pedido)  {
		
		return new ResponseEntity<>(pedidoService.save(pedido),HttpStatus.CREATED); 
		
	}
	
	@GetMapping("/{idPedido}")	
	public ResponseEntity<ResponseUds> getPedido(@PathVariable(value="idPedido") Integer idPedido ) {
		return ResponseEntity.ok(new ResponseUds(pedidoService.getById(idPedido)));
		
	}
	
	@ExceptionHandler(PedidoException.class)
	public ResponseEntity<ErrorResponseUds> exceptionHandler(PedidoException pedidoException){
		ErrorResponseUds error = new ErrorResponseUds();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(pedidoException.getErrorMessage());
		log.error("[PedidoController.exceptionHandler]", pedidoException);
		return new ResponseEntity<>(error, HttpStatus.PRECONDITION_FAILED);
		
	}

}
