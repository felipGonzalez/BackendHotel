package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.models.CategoryProduct;

@Repository
public interface CategotyProductRepository extends JpaRepository<CategoryProduct, Integer>{

}
