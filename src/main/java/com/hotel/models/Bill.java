package com.hotel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

@Entity
@Table(name="facturas")
@AccessType(Type.FIELD)
public class Bill {
	
	
	@Id
	@Column(name="ID_FACTURA", unique=true, nullable=false )
	private Integer id;

	@Column(name="FECHA_FACTURA",  nullable=false,length=30 )
	private String dateBill;

	public Bill() {
	}
	
	public Bill(Integer id, String dateBill) {
		this.id = id;
		this.dateBill = dateBill;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateBill() {
		return dateBill;
	}

	public void setDateBill(String dateBill) {
		this.dateBill = dateBill;
	}

	
	
	
}
