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

import com.hotel.models.TypeReserve;
import com.hotel.models.User;
import com.hotel.service.TypeReserveService;
import com.hotel.service.UserService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/listTypeReserve")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2,Const.DOMAIN3})
public class TypeReserveController {

	
	@Autowired
	private TypeReserveService typeReserveService;

	public TypeReserveController() {

	}

	//OBTENER USUARIOS

	@GetMapping(value="")
	public List<TypeReserve> getList(){
		return typeReserveService.getAll();
	}


	//agregar usuario
	@PostMapping(value="")
	public RestResponse createUser(@RequestBody TypeReserve reserve) {
		if(!this.validateUser(reserve)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios no estan diligenciados ");
		}
		typeReserveService.save(reserve);

		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	private boolean validateUser(TypeReserve reserve) {
		return (!validateName(reserve.getNameType()) || 
				!validatePrice(reserve.getReservationTypePrice()));
	}

	private boolean validateName(String name) {
		return name.isEmpty();
	}
	
	private boolean validatePrice(double price) {
		return (price>0);
	}


	@DeleteMapping(value = "{id}")
	public RestResponse removePerson(@PathVariable int id){
		try {
			typeReserveService.remove(id);
			return new RestResponse(HttpStatus.OK.value(), "usuario borrado");
		} catch (Exception e) {

			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "tipo reserva no encontrada");
		}
	}
	
}
