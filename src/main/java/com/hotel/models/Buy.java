package com.hotel.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

@Entity
@Table(name="compras")
@AccessType(Type.FIELD)

public class Buy {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_compra", unique=true, nullable=false )
	private Integer id;


	@Column(name="id_proveedor", unique=true, nullable=false )
	private Integer idProvider;

	@Column(name="fecha_compra",  nullable=false,length=30 )
	private Date name;

	@Column(name="total", nullable=false,length=8 )
	private int totalBuy;

	public Buy() {
	}

	public Buy(Integer id, Integer idProvider, Date name, int totalBuy) {
		this.id = id;
		this.idProvider = idProvider;
		this.name = name;
		this.totalBuy = totalBuy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(Integer idProvider) {
		this.idProvider = idProvider;
	}

	public Date getName() {
		return name;
	}

	public void setName(Date name) {
		this.name = name;
	}

	public int getTotalBuy() {
		return totalBuy;
	}

	public void setTotalBuy(int totalBuy) {
		this.totalBuy = totalBuy;
	}
	
	
	
	

}
