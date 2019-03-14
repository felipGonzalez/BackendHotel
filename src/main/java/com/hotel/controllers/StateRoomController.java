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

import com.hotel.models.StateRoom;
import com.hotel.service.StateRoomService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;


@RestController
@RequestMapping("/listStateRoom")
@CrossOrigin(origins = Const.DOMAIN)

public class StateRoomController {
	
	@Autowired
	private StateRoomService service;
	
	public StateRoomController() {
	}
	
	@GetMapping(value="")
	public List<StateRoom> getList(){
		return service.getRooms();
	}
	
	
	//agregar usuario
	@PostMapping(value="")
	public RestResponse createRoom(@RequestBody StateRoom stateRoom) {
		if(!this.validate(stateRoom)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios no estan diligenciados ");
		}
		service.save(stateRoom);

		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	private boolean validate(StateRoom stateRoom) {
		return (!validateName(stateRoom.getNameState()));
	}

	private boolean validateName(String name) {
		return name.isEmpty();
	}


	@DeleteMapping(value = "{id}")
	public RestResponse removeRoom(@PathVariable int id){
		try {
			service.remove(id);
			return new RestResponse(HttpStatus.OK.value(), "Estado borrado borrado");
		} catch (Exception e) {

			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "Estado no encontrado");
		}
	}

}
