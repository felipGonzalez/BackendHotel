package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.TypeDocument;
import com.hotel.service.TypeDocumentService;
import com.hotel.util.Const;

@RestController
@RequestMapping("/listTypeDocument")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2})
public class TypeDocumentController {
	
	@Autowired
	private TypeDocumentService tipo; 
	
	public TypeDocumentController() {
	}

	@GetMapping(value="")
	public List<TypeDocument> getList(){
		return tipo.getAll();
	}
}
