package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.HotelData;
import com.hotel.repository.HotelDataRepository;

@Service
public class HotelDataService {
	
	@Autowired
	private HotelDataRepository repository;

	public HotelData getData() {
		return repository.findAll().get(0);
	}

	public void save(HotelData data) {
		repository.save(data);
	}

}
