package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.StateReserve;
import com.hotel.service.StateRerserveService;
import com.hotel.util.Const;

@RestController
@RequestMapping("/listStateReserve")
@CrossOrigin(origins = Const.DOMAIN)
public class StateReserveController {

	@Autowired
	private StateRerserveService service;
	
	public StateReserveController() {
	}
	
	@GetMapping(value="")
	public List<StateReserve> getList(){
		return service.getStateReserve();
	}
	
	
	
	
}
