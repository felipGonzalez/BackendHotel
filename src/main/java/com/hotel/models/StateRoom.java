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
@Table(name="estados_habitacion")
@AccessType(Type.FIELD)
public class StateRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_estado_habitacion", unique=true, nullable=false )
	private Integer idState;
	
	@Column(name="nombre_estado_habitacion",  nullable=false,length=30)
	private String nameState;
	
	@Column(name="color_estado_habitacion",  nullable=false,length=12)
	private String colorState;
	
	@Column(name="descripcion_estado_habitacion",  nullable=false,length=100)
	private String descState;
	
	public StateRoom() {
	}

	
	public StateRoom(Integer idState) {
		this.idState = idState;
	}


	public Integer getIdState() {
		return idState;
	}


	public void setIdState(Integer idState) {
		this.idState = idState;
	}


	public String getNameState() {
		return nameState;
	}


	public void setNameState(String nameState) {
		this.nameState = nameState;
	}


	public String getColorState() {
		return colorState;
	}


	public void setColorState(String colorState) {
		this.colorState = colorState;
	}


	public String getDescState() {
		return descState;
	}


	public void setDescState(String descState) {
		this.descState = descState;
	}
}
