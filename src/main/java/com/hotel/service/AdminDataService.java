package com.hotel.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.AdminData;
import com.hotel.repository.AdminDateRepository;

@Service
public class AdminDataService {
	
	@Autowired
	private AdminDateRepository repository;
	
	public Optional<AdminData> get() {
		Long id = (long) 1;
		return repository.findById(id);
	}

}
