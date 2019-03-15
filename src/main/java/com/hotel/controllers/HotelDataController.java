package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.HotelData;
import com.hotel.service.HotelDataService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/hotelData")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2})
public class HotelDataController {
	
	@Autowired
	private HotelDataService service;
	
	public HotelDataController() {
	}
	
	@GetMapping(value="")
	public HotelData getList(){
		return service.getData();
	}
	
	@PostMapping(value="")
	public RestResponse createData(@RequestBody HotelData data) {
		service.save(data);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
}
