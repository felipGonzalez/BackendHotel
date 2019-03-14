package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.Bill;
import com.hotel.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public List<Bill> getAll() {
		return billRepository.findAll();
	}

	public void save(Bill bill) {
		billRepository.save(bill);
	}

	public void remove(Integer id) {
		billRepository.deleteById(id);
	}

	public Integer getIdCount() {
		List<Bill> bills = billRepository.findAll();
		if(bills.isEmpty()) {
			return 1;
		}else {
			return bills.get(bills.size()-1).getId()+1;
		}
		

	}
}
