package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.StateRoom;
import com.hotel.repository.StateRoomRepository;

@Service
public class StateRoomService {
	
	@Autowired
	private StateRoomRepository repositoryState;
	
	
	public List<StateRoom> getRooms() {
		return repositoryState.findAll();
	}
	
	
	 public void save(StateRoom room) {
		 repositoryState.save(room);
	 }

	public List<StateRoom> getTypeRooms() {
		return repositoryState.findAll();
	}
	
	 public void remove(Integer id) {
		 repositoryState.deleteById(id);
	 }

}
