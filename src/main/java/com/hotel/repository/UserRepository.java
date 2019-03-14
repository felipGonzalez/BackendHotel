package com.hotel.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT id_cliente FROM CLIENTES where documento_cliente = ?1", nativeQuery = true)
	 int selectByDocument(String document); 
	
	
	@Query(value = "select id_cliente "
			+ "from clientes "
			+ "where upper(email) like upper(?1)"
			+ "and contrasena like ?2", nativeQuery = true)
	int findUser(String email, String password);
	
}
