package com.hotel.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.AdminData;
import com.hotel.service.AdminDataService;
import com.hotel.util.Const;

@RestController
@RequestMapping("/loginAdmin")
@CrossOrigin(origins = Const.DOMAIN)
public class AdminDataController {

	@Autowired
	private AdminDataService service;
	
	public AdminDataController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(value="")
	public Optional<AdminData> getData(){
		return service.get();
	}
}
