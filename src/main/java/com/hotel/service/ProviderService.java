package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.Provider;
import com.hotel.repository.ProviderRepository;

@Service
public class ProviderService {

	@Autowired
	private ProviderRepository providerRepository;

	public List<Provider> getAll() {
		return providerRepository.findAll();
	}
	
	/**
	  * Guarda un usuario
	  * @param user
	  * @return el usuario guardado
	  * **/
	 public void save(Provider provider) {
		 providerRepository.save(provider);
	 }
	 
	 public void remove(Integer id) {
		 providerRepository.deleteById(id);
	 }
	
}
