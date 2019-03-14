package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.CategoryProduct;
import com.hotel.models.TypeDocument;
import com.hotel.repository.CategotyProductRepository;

@Service
public class CategoryProductService {
	
	@Autowired
	private CategotyProductRepository  repository;
	
	public List<CategoryProduct> getAll() {
		return repository.findAll();
	}

}
