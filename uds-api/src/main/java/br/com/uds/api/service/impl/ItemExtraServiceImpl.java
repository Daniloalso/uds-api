package br.com.uds.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uds.api.model.ItemExtra;
import br.com.uds.api.repository.ItemExtraRepository;
import br.com.uds.api.service.ItemExtraService;

@Service
public class ItemExtraServiceImpl implements ItemExtraService{

	@Autowired
	ItemExtraRepository itenExtraRepository;

	@Override
	public List<ItemExtra> getAll() {
		
		return itenExtraRepository.findAll();
	}
	
	
	
}
