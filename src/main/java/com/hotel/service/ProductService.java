package com.hotel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.models.Product;
import com.hotel.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	/**
	 * Guarda un usuario
	 * @param user
	 * @return el usuario guardado
	 * **/
	public void save(Product producto) {
		productRepository.save(producto);
	}

	public void remove(Integer id) {
		productRepository.deleteById(id);
	}

}
