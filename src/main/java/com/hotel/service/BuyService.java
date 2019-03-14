package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.Buy;
import com.hotel.repository.BuyRepository;

@Service
public class BuyService {

	@Autowired
	private BuyRepository buyRepository;

	public List<Buy> getAll() {
		return buyRepository.findAll();
	}
	
	public void save(Buy buy) {
			 buyRepository.save(buy);
	 }
	 
	 public void remove(Integer id) {
		 buyRepository.deleteById(id);
	 }
	
}
