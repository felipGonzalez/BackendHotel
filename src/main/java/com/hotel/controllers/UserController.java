package com.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.User;
import com.hotel.service.UserService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;


@RestController
@RequestMapping("/listUser")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2,Const.DOMAIN3})
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController() {

	}

	//OBTENER USUARIOS

	@GetMapping(value="")
	public List<User> getList(){
		return userService.getAll();
	}
	
	@GetMapping(value="getUser/{id}")
	public Optional<User> getUsers(@PathVariable int id){
		Optional<User> user =  userService.getUser(id);
		return user;
	}

	
	@GetMapping(value="verifyUser")
	@ResponseBody
	public Optional<User> getDataUser(@RequestParam List<String> data){
		System.out.println(data);
		try {
			if(data.get(0) != null && data.get(1) != null) {
				int id = userService.verifyUser(data.get(0),data.get(1));
				return userService.getUser(id);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return null;
	}

	//agregar usuario
	@PostMapping(value="")
	public RestResponse createUser(@RequestBody User user) {
		if(!this.validateUser(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios no estan diligenciados ");
		}
		userService.save(user);

		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	
	private void trimString(User user) {
		if(user.getPassword() != null || !user.getPassword().isEmpty()) {
			user.setPassword(user.getPassword().trim());
			user.setPassword(user.getPassword().replace(" ", ""));
		}
		
		if(user.getEmail() != null || !user.getEmail().isEmpty()) {
			user.setEmail(user.getEmail().trim());
			user.setEmail(user.getEmail().replace(" ", ""));
		}
	}

	private boolean validateUser(User user) {
		System.out.println("Entro al validar");
		trimString(user);
		return (!validateName(user.getFirstName()) || 
				!validateName(user.getLastName()));
	}

	private boolean validateName(String name) {
		return name.isEmpty();
	}

	
	@DeleteMapping(value = "{id}")
	public RestResponse removePerson(@PathVariable int id){
		try {
			userService.removePerson(id);
			return new RestResponse(HttpStatus.OK.value(), "usuario borrado");
		} catch (Exception e) {

			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "usuario no encontrado");
		}
	}
}
