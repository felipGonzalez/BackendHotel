package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.models.HotelData;

@Repository
public interface HotelDataRepository extends JpaRepository<HotelData, Integer> {

	/*@Query(value = "SELECT nombre_hotel from info_hotel")
	String getDataName();*/
}
