package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.models.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
