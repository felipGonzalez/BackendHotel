package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.CategoryProduct;
import com.hotel.models.TypeDocument;
import com.hotel.service.CategoryProductService;
import com.hotel.service.TypeDocumentService;
import com.hotel.util.Const;

@RestController
@RequestMapping("/listCategoryProduct")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2,Const.DOMAIN3})
public class CategoryProductController {
	
	@Autowired
	private CategoryProductService product; 
	
	public CategoryProductController() {
	}

	@GetMapping(value="")
	public List<CategoryProduct> getList(){
		return product.getAll();
	}

}
