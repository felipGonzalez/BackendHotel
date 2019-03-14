package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.models.TypeDocument;

@Repository
public interface Tipo_documentoRepository extends JpaRepository<TypeDocument, Integer> {
}

