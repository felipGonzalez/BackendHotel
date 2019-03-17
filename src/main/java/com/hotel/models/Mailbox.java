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
@Table(name="buzon")
@AccessType(Type.FIELD)
public class Mailbox {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_mensaje", unique=true, nullable=false )
	private Integer idMessage;
	
	@Column(name="nombre_remitente", unique=true, nullable=false )
	private String nameClient;

	@Column(name="apellido_remitente", unique=true, nullable=false )
	private String lastClient;
	
	@Column(name="email", unique=true, nullable=false )
	private String emailClient;
	
	@Column(name="asunto", unique=true, nullable=false )
	private String affair;
	
	@Column(name="mensaje", unique=true, nullable=false )
	private String message;
	
	public Mailbox() {
	}


	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getLastClient() {
		return lastClient;
	}

	public void setLastClient(String lastClient) {
		this.lastClient = lastClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getAffair() {
		return affair;
	}

	public void setAffair(String affair) {
		this.affair = affair;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

