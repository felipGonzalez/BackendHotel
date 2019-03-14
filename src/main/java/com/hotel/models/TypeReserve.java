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
	@Table(name="tipos_reserva")
	@AccessType(Type.FIELD)
	public class TypeReserve {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id_tipo_reserva", unique=true, nullable=false )
		private Integer id;
		
		@Column(name="nombre_tipo_reserva",  unique=true, nullable=false,length=30 )
		private String nameType;
		
		@Column(name="precio_tipo_reserva",  unique=true, nullable=false,length=10 )
		private double 	reservationTypePrice;
		
		public TypeReserve() {
		}

		public TypeReserve(Integer id, String nameType, double reservationTypePrice) {
			this.id = id;
			this.nameType = nameType;
			this.reservationTypePrice = reservationTypePrice;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNameType() {
			return nameType;
		}

		public void setNameType(String nameType) {
			this.nameType = nameType;
		}

		public double getReservationTypePrice() {
			return reservationTypePrice;
		}

		public void setReservationTypePrice(double reservationTypePrice) {
			this.reservationTypePrice = reservationTypePrice;
		}

		
		
	
}
