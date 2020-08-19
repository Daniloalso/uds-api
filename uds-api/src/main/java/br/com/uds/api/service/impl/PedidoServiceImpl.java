package br.com.uds.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uds.api.exception.PedidoException;
import br.com.uds.api.model.Pedido;
import br.com.uds.api.repository.PedidoRepository;
import br.com.uds.api.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public Pedido getById(Integer id) {
		
		return pedidoRepository.findById(id).get();
	}

	@Override
	public Pedido save(Pedido pedido) {
		
		if (pedido.getTamanho() == null  ) {
			throw new PedidoException("Tamanho do produto é obrigatório");
		}
		
		if (pedido.getSabor() == null  ) {
			throw new PedidoException("Sabor do produto é obrigatório");
		}
		
		return pedidoRepository.save(pedido);
	}
	
	

}
