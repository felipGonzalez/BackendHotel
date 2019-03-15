package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.DetailReserve;
import com.hotel.repository.DetailReserveRepository;
@Service
public class DetailReserveService {
	
	@Autowired
	private DetailReserveRepository detailReserveRepository;
	
	public List<DetailReserve> getAll() {
		return detailReserveRepository.findAll();
	}

	/**
	 * Guarda un usuario
	 * @param user
	 * @return el usuario guardado
	 * **/
	public void save(DetailReserve detailReserve) {
		detailReserveRepository.save(detailReserve);
	}

	public void remove(Integer id) {
		detailReserveRepository.deleteById(id);
	}

}
