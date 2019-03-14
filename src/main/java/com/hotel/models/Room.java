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
@Table(name="habitaciones")
@AccessType(Type.FIELD)
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_habitacion", unique=true, nullable=false )
	private Integer idRoom;
	
	@Column(name="id_estado_habitacion", nullable=true,length=11 )
	private int stateRoom;
	
	@Column(name="codigo", nullable=true,length=30 )
	private String codeRoom;
	
	@Column(name="capacidad_habitacion", nullable=true,length=4 )
	private int capacityRoom;
	
	public Room() {
	}
	
	public Room(Integer idRoom) {
		super();
		this.idRoom = idRoom;
	}

	public Integer getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(Integer idRoom) {
		this.idRoom = idRoom;
	}

	public int getStateRoom() {
		return stateRoom;
	}

	public void setStateRoom(int stateRoom) {
		this.stateRoom = stateRoom;
	}

	public String getCodeRoom() {
		return codeRoom;
	}

	public void setCodeRoom(String codeRoom) {
		this.codeRoom = codeRoom;
	}

	public int getCapacityRoom() {
		return capacityRoom;
	}

	public void setCapacityRoom(int capacityRoom) {
		this.capacityRoom = capacityRoom;
	}
	
	
}
