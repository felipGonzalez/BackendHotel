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
@Table(name="categorias_producto")
@AccessType(Type.FIELD)
public class CategoryProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categoria", unique=true, nullable=false )
	private Integer id;
	
	@Column(name="nombre_categoria",  unique=true, nullable=false,length=30 )
	private String nameCategory;
	
	@Column(name="descripcion_categoria",  unique=true, nullable=false,length=30 )
	private String descriptionCategory;

	public CategoryProduct() {
	}

	public CategoryProduct(Integer id, String nameCategory, String descriptionCategory) {
		this.id = id;
		this.nameCategory = nameCategory;
		this.descriptionCategory = descriptionCategory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDescriptionCategory() {
		return descriptionCategory;
	}

	public void setDescriptionCategory(String descriptionCategory) {
		this.descriptionCategory = descriptionCategory;
	}
	
	
	
	
	
}
