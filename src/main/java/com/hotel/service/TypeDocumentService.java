package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.TypeDocument;
import com.hotel.repository.Tipo_documentoRepository;

@Service
public class TypeDocumentService {
	
	@Autowired
	private Tipo_documentoRepository repository;
	
	public List<TypeDocument> getAll() {
		return repository.findAll();
	}
}
