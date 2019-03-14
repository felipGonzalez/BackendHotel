package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.StateReserve;
import com.hotel.repository.StateReserveRepository;

@Service
public class StateRerserveService {

	@Autowired
	private StateReserveRepository repositoryState;
	
	public List<StateReserve> getStateReserve() {
		return repositoryState.findAll();
	}
	
	
	 public void save(StateReserve stateReserve) {
		 repositoryState.save(stateReserve);
	 }

	 public void remove(Integer id) {
		 repositoryState.deleteById(id);
	 }
	
}
