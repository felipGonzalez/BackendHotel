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

import com.hotel.models.Buy;
import com.hotel.models.Provider;
import com.hotel.service.BuyService;
import com.hotel.service.ProviderService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/listProvider")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2,Const.DOMAIN3})
public class ProviderController {

	
	@Autowired
	private ProviderService providerService;

	public ProviderController() {}

	@GetMapping(value="")
	public List<Provider> getList(){
		return providerService.getAll();
	}

	//agregar provedor
	@PostMapping(value="")
	public RestResponse createProduct(@RequestBody Provider provider) {
		providerService.save(provider);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	@DeleteMapping(value = "{id}")
	public RestResponse removeProduct(@PathVariable int id){
		try {
			providerService.remove(id);
			return new RestResponse(HttpStatus.OK.value(), "Provedor borrado");
		} catch (Exception e) {
			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "Provedor encontrado no encontrado");
		}
	}
	
}
