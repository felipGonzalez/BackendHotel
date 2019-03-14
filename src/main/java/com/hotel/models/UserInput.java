package com.hotel.models;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;


@AccessType(Type.FIELD)
public class UserInput {

	
	@Column(name="nombres", nullable=true,length=11 )
	private String name;
	
	@Column(name="fecha_inicial", nullable=true,length=11 )
	private Date dateInit;
	
	@Column(name="fecha_final", nullable=true,length=11 )
	private Date dateEnd;
	
	
	public UserInput() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateInit() {
		return dateInit;
	}
	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	
	
	
	
	
}
