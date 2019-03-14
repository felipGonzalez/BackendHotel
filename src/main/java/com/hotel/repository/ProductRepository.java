package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}