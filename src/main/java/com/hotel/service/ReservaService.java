package com.hotel.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.hotel.models.Reserve;
import com.hotel.models.Room;
import com.hotel.models.User;
import com.hotel.models.UserInput;
import com.hotel.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	

	public List<Reserve> getAll() {
		return reservaRepository.findAll();
	}

	public List<Reserve> getAllActually() {
		return reservaRepository.findReserveActually();
	}


	public void save(Reserve reserva) {
		reservaRepository.save(reserva);
	}

	public void remove(Integer id) {
		reservaRepository.deleteById(id);
	}

	public List<Reserve> getAllActally(Integer number, String date) {
		return reservaRepository.selectAll(number, date);
	}	
	// Entradas hoy
	public List<Map<String,Object>>   getReserveInput() {
		return reservaRepository.findUserInput();
	}
	
	/* salidas hoy ---- estan en estacia*/
	
	public List<Map<String,Object>>   getReserveOutput() {
		return reservaRepository.findUserOutput();
	}

	//numero de clientes que entran hoy
	public Integer getNumClientInput() {
		return reservaRepository.findNumClientInput();

	}

	//Numero de clientes que salen hoy
	public Integer getNumClientOutput() {
		return reservaRepository.findNumClientOutput();
	}
	/*   Numero de huespedes hoy*/
	public Integer getNumberClientsHosted() {
		return reservaRepository.findNumberClientsHosted();
	}

	// Habitaciones ocupadas 
	
	public Integer  getFindOccupiedRoom() {
		return reservaRepository.findOccupiedRoom();
	}
	
	/* En estancia hoy*/
	public List<Map<String,Object>>  getUserEstancia() {
		return reservaRepository.findUserEstancia();
	}
	
	public List<Map<String,Object>>  getUserAsing() {
		return reservaRepository.findUserAsing();
	}
	
	
	/*  Historial realizadas en un rango de fecha */
	public List<Map<String,Object>>  getHistoryReserveOk(String dateInit, String dateEnd) {
		return reservaRepository.findHistoryReserveOk(dateInit,dateEnd);
	}
	
	/*  Historial canceladas en un rango de fecha */
	public List<Map<String,Object>>  getHistoryReserveCancel(String dateInit, String dateEnd) {
		return reservaRepository.findHistoryReserveCancel(dateInit,dateEnd);
	}
	
	/*-----------------------------------------------------------------------------------------------------*/
	/*NUMERO DE CAMAS DISPONIBLES (HAB Individual) EN LA FECHA*/
	public Integer  getIndividualAvailability(String dateInit, String dateEnd) {
		return reservaRepository.findIndividualAvailability(dateInit,dateEnd);
	}
	
	/*NUMERO DE CAMAS DISPONIBLES (HAB COMPARTIDA) EN LA FECHA pagina*/
	public Integer  getSharedAvailability(String dateInit, String dateEnd, int bed) {
		return reservaRepository.findSharedAvailability(dateInit,dateEnd,bed);
	}
	
	/*Reservas de un cliente*/
	public  List<Map<String,Object>>  getReserveUser(int idUser) {
		return reservaRepository.findReserveUser(idUser);
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	 /*   consulta adimn id habitaciones tipo INDIVIDUAL sin reserva en las fechas*/
	
	public  List<Integer>  getIndividualAvailableRoom(String dateInit, String dateEnd) {
		return reservaRepository.findIndividualAvailableRoom(dateInit,dateEnd	);
	}
	/* lista de habitacion (COMPARTIDO) con cantidad de camas disponibles */
	
	public  List<Map<String,Object>>  getSharedRoomAvailable(String dateInit, String dateEnd) {
		return reservaRepository.findSharedRoomAvailable(dateInit,dateEnd);
	}
	








}
