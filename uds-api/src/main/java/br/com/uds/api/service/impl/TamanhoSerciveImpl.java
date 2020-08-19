package br.com.uds.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uds.api.model.Tamanho;
import br.com.uds.api.repository.TamanhoRepository;
import br.com.uds.api.service.TamanhoService;

@Service
public class TamanhoSerciveImpl implements TamanhoService {

	@Autowired
	private TamanhoRepository tamanhoRepository;
	
	@Override
	public List<Tamanho> getAll() {		
		return tamanhoRepository.findAll();
	}

}
