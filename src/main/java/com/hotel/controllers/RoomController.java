package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.Room;
import com.hotel.models.StateRoom;
import com.hotel.models.User;
import com.hotel.service.RoomService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/listRoom")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2,Const.DOMAIN3})
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	public RoomController() {
	}
	
	@GetMapping(value="")
	public List<Room> getList(){
		return service.getRooms();
	}
	
	
	//agregar usuario
	@PostMapping(value="")
	public RestResponse createRoom(@RequestBody Room room) {
		if(!this.validate(room)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios no estan diligenciados ");
		}
		service.save(room);

		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	private boolean validate(Room room) {
		return (!validateName(room.getCodeRoom()));
	}

	private boolean validateName(String name) {
		return name.isEmpty();
	}


	@DeleteMapping(value = "{id}")
	public RestResponse removeRoom(@PathVariable int id){
		try {
			service.remove(id);
			return new RestResponse(HttpStatus.OK.value(), "Cuarto borrado borrado");
		} catch (Exception e) {

			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "usuario no encontrado");
		}
	}
	
	

}
