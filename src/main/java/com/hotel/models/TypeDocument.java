package com.hotel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

@Entity
@Table(name="tipos_documento")
@AccessType(Type.FIELD)
public class TypeDocument {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipo_documento", unique=true, nullable=false )
	private Integer id;
	
	@Column(name="nombre_tipo_documento",  unique=true, nullable=false,length=30 )
	private String nombre_tipo_documento;

	public TypeDocument() {
	}

	public TypeDocument(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_tipo() {
		return nombre_tipo_documento;
	}

	public void setNombre_tipo(String nombre_tipo) {
		this.nombre_tipo_documento = nombre_tipo;
	}
}
