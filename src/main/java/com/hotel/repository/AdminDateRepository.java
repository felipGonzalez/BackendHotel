package com.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.models.AdminData;

@Repository
public interface AdminDateRepository extends JpaRepository<AdminData, Long> {
	
	public Optional<AdminData> findById(Long id);

}
