package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.TypeReserve;
import com.hotel.repository.TypeReserveRepository;
import com.hotel.repository.UserRepository;

@Service
public class TypeReserveService {

	@Autowired
	private TypeReserveRepository typeReserveRepository;

	public List<TypeReserve> getAll() {
		return typeReserveRepository.findAll();
	}
	
	/**
	  * Guarda un usuario
	  * @param user
	  * @return el usuario guardado
	  * **/
	 public void save(TypeReserve typeReserve) {
		 typeReserveRepository.save(typeReserve);
	 }
	 
	 public void remove(Integer id) {
		 typeReserveRepository.deleteById(id);
	 }
	
}
