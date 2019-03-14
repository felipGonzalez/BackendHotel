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
@Table(name="productos")
@AccessType(Type.FIELD)

public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_producto", unique=true, nullable=false )
	private Integer id;

	@Column(name="id_categoria", nullable=false,length=11 )
	private int idCategory;

	@Column(name="nombre_producto",  nullable=false,length=30 )
	private String name;

	@Column(name="descripcion_producto",  nullable=false,length=30 )
	private String descProduct;

	@Column(name="cantidad_actual", nullable=false,length=11 )
	private int actualQuantity;

	@Column(name="cantidad_base", nullable=false,length=11 )
	private int baseQuantity;

	public Product(Integer id) {
		super();
		this.id = id;
	}
	
	public Product() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescProduct() {
		return descProduct;
	}

	public void setDescProduct(String descProduct) {
		this.descProduct = descProduct;
	}

	public int getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(int actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public int getBaseQuantity() {
		return baseQuantity;
	}

	public void setBaseQuantity(int baseQuantity) {
		this.baseQuantity = baseQuantity;
	}
}
