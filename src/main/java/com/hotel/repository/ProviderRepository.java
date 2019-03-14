package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.models.Provider;


public interface ProviderRepository extends JpaRepository<Provider, Integer>{

}
