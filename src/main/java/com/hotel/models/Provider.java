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
@Table(name="PROVEEDORES")
@AccessType(Type.FIELD)
public class Provider {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_proveedor", unique=true, nullable=false )
	private Integer id;

	@Column(name="nombre_proveedor",  nullable=false,length=30 )
	private String nameProvider;

	@Column(name="nit_proveedor", nullable=false,length=8 )
	private int nitProvider;
	
	@Column(name="ciudad_proveedor",  nullable=false,length=30 )
	private String cityProvider;

	@Column(name="telefono_proveedor",  nullable=false,length=30 )
	private String phoneProvider;
	
	public Provider() {
	}

	public Provider(Integer id, String nameProvider, int nitProvider, String cityProvider, String phoneProvider) {
		this.id = id;
		this.nameProvider = nameProvider;
		this.nitProvider = nitProvider;
		this.cityProvider = cityProvider;
		this.phoneProvider = phoneProvider;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameProvider() {
		return nameProvider;
	}

	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}

	public int getNitProvider() {
		return nitProvider;
	}

	public void setNitProvider(int nitProvider) {
		this.nitProvider = nitProvider;
	}

	public String getCityProvider() {
		return cityProvider;
	}

	public void setCityProvider(String cityProvider) {
		this.cityProvider = cityProvider;
	}

	public String getPhoneProvider() {
		return phoneProvider;
	}

	public void setPhoneProvider(String phoneProvider) {
		this.phoneProvider = phoneProvider;
	}
	
	
	
	
	

	
}
