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
@Table(name="detalle_reserva")
@AccessType(Type.FIELD)
public class DetailReserve {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_det_reserva", unique=true, nullable=false )
	private Integer id;

	@Column(name="id_reserva", nullable=true,length=11 )
	private int idReserve;

	@Column(name="id_habitacion", nullable=true,length=11 )
	private int idRoom;

	public DetailReserve() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdReserve() {
		return idReserve;
	}

	public void setIdReserve(int idReserve) {
		this.idReserve = idReserve;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}



}
