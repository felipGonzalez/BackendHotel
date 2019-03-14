package com.hotel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.jpa.repository.Query;

@Entity
@Table(name="info_hotel")
@AccessType(Type.FIELD)
public class HotelData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_info", unique=true, nullable=false )
	private Integer idHotel;	
	
	@Column(name="nombre_hotel", nullable=true,length=30)
	private String nameHotel;	
		
	@Column(name="telefono_hotel", nullable=true,length=15)
	private String phoneHotel;
	
	@Column(name="email_hotel", nullable=true,length=50)
	private String emailHotel;
	
	@Column(name="razon_social", nullable=false,length=30)
	private String razonHotel;
	
	@Column(name="nif", nullable=false,length=30)
	private String nifHotel;
	
	@Column(name="departamento_hotel", nullable=true,length=30)
	private String departmentHotel;
	
	@Column(name="municipio_hotel", nullable=true,length=30)
	private String cityHotel;
	
	@Column(name="direccion_hotel", nullable=true,length=30)
	private String addresHotel;
	
	public HotelData() {

	}
	
	public HotelData(String nameHotel) {
		super();
		this.nameHotel = nameHotel;
	}
	
	


	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getNameHotel() {
		return nameHotel;
	}

	public void setNameHotel(String nameHotel) {
		this.nameHotel = nameHotel;
	}

	public String getPhoneHotel() {
		return phoneHotel;
	}

	public void setPhoneHotel(String phoneHotel) {
		this.phoneHotel = phoneHotel;
	}

	public String getEmailHotel() {
		return emailHotel;
	}

	public void setEmailHotel(String emailHotel) {
		this.emailHotel = emailHotel;
	}

	public String getRazonHotel() {
		return razonHotel;
	}

	public void setRazonHotel(String razonHotel) {
		this.razonHotel = razonHotel;
	}

	public String getNifHotel() {
		return nifHotel;
	}

	public void setNifHotel(String nifHotel) {
		this.nifHotel = nifHotel;
	}

	public String getDepartmentHotel() {
		return departmentHotel;
	}

	public void setDepartmentHotel(String departmentHotel) {
		this.departmentHotel = departmentHotel;
	}

	public String getCityHotel() {
		return cityHotel;
	}

	public void setCityHotel(String cityHotel) {
		this.cityHotel = cityHotel;
	}

	public String getAddresHotel() {
		return addresHotel;
	}

	public void setAddresHotel(String addresHotel) {
		this.addresHotel = addresHotel;
	}
}
