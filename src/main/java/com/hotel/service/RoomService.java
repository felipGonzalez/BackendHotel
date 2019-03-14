package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.Room;
import com.hotel.models.StateRoom;
import com.hotel.models.User;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.StateRoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repository;
	
	
	
	public List<Room> getRooms() {
		return repository.findAll();
	}
	
	
	 public void save(Room room) {
		 repository.save(room);
	 }
	 
	 public void remove(Integer id) {
		 repository.deleteById(id);
	 }
	 
	 
	 public List<Room> getRooms(List<Integer> list) {
		 return repository.findAllById(list);
	 }



}
