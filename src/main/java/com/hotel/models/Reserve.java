package com.hotel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

@Entity
@Table(name="reservas")
@AccessType(Type.FIELD)
public class Reserve {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reserva", unique=true, nullable=false )
	private Integer idReserve;
	
	@Column(name="id_cliente", nullable=false,length=11 )
	private Integer idClient;
	
	@Column(name="fecha_reserva", nullable=false)
	private String dateReserve;
	
	@Column(name="id_estado_reserva", nullable=false,length=1)
	private Integer idStateReserve;
	
	@Column(name="id_factura", nullable=true,length=11 )
	private Integer idBill;

	@Column(name="fecha_inicial", nullable=false)
	private String deteInput;
	
	@Column(name="fecha_final", nullable=false)
	private String dateOutput;
	

	@Column(name="id_tipo_reserva", nullable=false,length=4 )
	private Integer idTypeReserve;
	
	@Column(name="numero_camas_reserva", nullable=false,length=2 )
	private int numBed;
	
	public Reserve() {
	}

	public Reserve(Integer id) {
		this.idReserve = id;
	}

	public Integer getIdReserve() {
		return idReserve;
	}

	public void setIdReserve(Integer idReserve) {
		this.idReserve = idReserve;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getDateReserve() {
		return dateReserve;
	}

	public void setDateReserve(String dateReserve) {
		this.dateReserve = dateReserve;
	}

	public Integer getIdStateReserve() {
		return idStateReserve;
	}

	public void setIdStateReserve(Integer idStateReserve) {
		this.idStateReserve = idStateReserve;
	}

	public Integer getIdBill() {
		return idBill;
	}

	public void setIdBill(Integer idBill) {
		this.idBill = idBill;
	}

	public String getDeteInput() {
		return deteInput;
	}

	public void setDeteInput(String deteInput) {
		this.deteInput = deteInput;
	}

	public String getDateOutput() {
		return dateOutput;
	}

	public void setDateOutput(String dateOutput) {
		this.dateOutput = dateOutput;
	}

	
	public Integer getIdTypeReserve() {
		return idTypeReserve;
	}

	public void setIdTypeReserve(Integer idTypeReserve) {
		this.idTypeReserve = idTypeReserve;
	}

	public int getNumBed() {
		return numBed;
	}

	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}
	
	

	
}
