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
import com.hotel.service.BuyService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/listBuy")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2})
public class BuyController {
	
	@Autowired
	private BuyService buyService;

	public BuyController() {}

	@GetMapping(value="")
	public List<Buy> getList(){
		return buyService.getAll();
	}

	//agregar producto
	@PostMapping(value="")
	public RestResponse createProduct(@RequestBody Buy buy) {
		buyService.save(buy);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	@DeleteMapping(value = "{id}")
	public RestResponse removeProduct(@PathVariable int id){
		try {
			buyService.remove(id);
			return new RestResponse(HttpStatus.OK.value(), "Buy borrado");
		} catch (Exception e) {
			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "Compra no encontrado");
		}
	}

}
