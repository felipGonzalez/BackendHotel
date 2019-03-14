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
@Table(name="estados_reserva")
@AccessType(Type.FIELD)
public class StateReserve {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_estado_reserva", unique=true, nullable=false )
	private Integer idState;
	
	@Column(name="nombre_estado_reserva",  nullable=false,length=30)
	private String nameState;
	
	@Column(name="descripcion_estado_reserva",  nullable=false,length=100)
	private String descState;

	public StateReserve() {
	}	
	
	public StateReserve(Integer idState, String nameState, String descState) {
		this.idState = idState;
		this.nameState = nameState;
		this.descState = descState;
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

	public String getDescState() {
		return descState;
	}

	public void setDescState(String descState) {
		this.descState = descState;
	}
	
	
	
	

}
