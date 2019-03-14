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
@Table(name="clientes")
@AccessType(Type.FIELD)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cliente", unique=true, nullable=false )
	private Integer id;
	
	@Column(name="id_tipo_documento", nullable=true,length=11 )
	private int idTypeDocument;
	
	@Column(name="documento_cliente", nullable=true,length=30 )
	private String document;

	@Column(name="nombre_cliente",  nullable=false,length=30 )
	private String firstName;
	
	@Column(name="apellido_cliente",  nullable=false,length=30 )
	private String lastName;
	
	@Column(name="genero",  nullable=true,length=1 )
	private char Gender;

	@Column(name="celular", nullable=false,length=20 )
	private String phone;

	@Column(name="ciudad", nullable=true,length=30 )
	private String city;

	@Column(name="email", nullable=false,length=50 )
	private String email;

	@Column(name="contrasena", nullable=true,length=256 )
	private String password;

	public User() {
	}
	
	public User(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdTypeDocument() {
		return idTypeDocument;
	}

	public void setIdTypeDocument(int idTypeDocument) {
		this.idTypeDocument = idTypeDocument;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	
}
