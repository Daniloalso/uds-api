package br.com.uds.api.service;


import br.com.uds.api.model.Pedido;

public interface PedidoService {
	
	Pedido getById(Integer id);
	Pedido save(Pedido pedido) ;

}
