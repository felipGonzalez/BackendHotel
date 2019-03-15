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
import com.hotel.models.Product;
import com.hotel.models.User;
import com.hotel.service.ProductService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/listProduct")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2})
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController() {}

	@GetMapping(value="")
	public List<Product> getList(){
		return productService.getAll();
	}

	//agregar producto
	@PostMapping(value="")
	public RestResponse createProduct(@RequestBody Product producto) {
		productService.save(producto);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	@DeleteMapping(value = "{id}")
	public RestResponse removeProduct(@PathVariable int id){
		try {
			productService.remove(id);
			return new RestResponse(HttpStatus.OK.value(), "Producto borrado");
		} catch (Exception e) {
			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "usuario no encontrado");
		}
	}
}
