package br.com.uds.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uds.api.model.Sabor;
import br.com.uds.api.repository.SaborRepository;
import br.com.uds.api.service.SaborService;

@Service
public class SaborServiceImpl implements SaborService{

	@Autowired
	SaborRepository saborRepository;
	
	@Override
	public List<Sabor> getAll() {
		
		return saborRepository.findAll();
	}

}
