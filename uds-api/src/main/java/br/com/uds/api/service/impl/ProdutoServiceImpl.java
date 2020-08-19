package br.com.uds.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uds.api.model.Produto;
import br.com.uds.api.repository.ProdutoRepository;
import br.com.uds.api.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public List<Produto> getAll() {
		
		return produtoRepository.findAll();
	}

}
