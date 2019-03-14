package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.User;
import com.hotel.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	/**
	  * Guarda un usuario
	  * @param user
	  * @return el usuario guardado
	  * **/
	 public void save(User user) {
		 userRepository.save(user);
	 }
	 
	 public void removePerson(Integer id) {
		 userRepository.deleteById(id);
	 }
	 
	 public int verifyUser(String email, String password) throws Exception{
		 return userRepository.findUser(email, password);
	 }
	 
	 public Optional<User> getUser(Integer id) {
		 return userRepository.findById(id);
	 }
}
