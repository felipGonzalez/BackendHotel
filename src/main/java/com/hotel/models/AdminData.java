package com.hotel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

@Entity
@Table(name="administradores")
@AccessType(Type.FIELD)
public class AdminData {
	
	@Id
	@Column(name="id_administrador", unique=true, nullable=false )
	private Long id;
	
	@Column(name="nombre_administrador", nullable=false,length=30 )
	private String name;
	
	@Column(name="contrasena", nullable=false,length=256)
	private String password;
	
	public AdminData() {
	}
	
	public AdminData(Long id2) {
		super();
		this.id = id2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasword() {
		return password;
	}

	public void setPasword(String password) {
		this.password = password;
	}
}
