package com.hotel.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.hotel.models.Bill;
import com.hotel.models.Reserve;
import com.hotel.models.Room;


import com.hotel.service.BillService;
import com.hotel.service.ReservaService;
import com.hotel.service.RoomService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/listReserve")
@CrossOrigin(origins = Const.DOMAIN)
public class ReserveController {

	@Autowired
	private ReservaService reservaService;
	@Autowired
	private RoomService roomService;

	@Autowired
	private BillService billService;

	public ReserveController() {
	}

	@GetMapping(value="")
	public List<Reserve> getList(){
		return reservaService.getAll();
	}

	@GetMapping(value="reserveActually")
	public List<Reserve> getListActally(){
		return reservaService.getAllActually();
	}

	@GetMapping(value="userEstancia")
	public  List<Map<String,Object>>  getlistUserEstancia(){
		return reservaService.getUserEstancia();
	}

	@GetMapping(value="reserveInput")
	public  List<Map<String,Object>>  getListRerserveInput(){
		return reservaService.getReserveInput();
	}

	@GetMapping(value="reserveOutput")
	public  List<Map<String,Object>>  getListReserveOutput(){
		return reservaService.getReserveOutput();
	}

	@GetMapping(value="reserveAsing")
	public  List<Map<String,Object>>  getListReserveAsing(){
		return reservaService.getUserAsing();
	}

	@GetMapping(value="numClientInput")
	public  Integer  getNumClientInput(){
		return reservaService.getNumClientInput();
	}

	@GetMapping(value="numClientOutput")
	public  Integer  getNumClientOutput(){
		return reservaService.getNumClientOutput();
	}

	@GetMapping(value="numberClientsHosted")
	public  Integer  getNumberClientsHosted(){
		return reservaService.getNumberClientsHosted();
	}

	@GetMapping(value="occupiedRoom")
	public  Integer  getListOccupiedRoom(){
		return reservaService.getFindOccupiedRoom();
	}
	@GetMapping(value="totalRoom")
	public  Integer  getTotalRoom(){
		return roomService.getRooms().size();
	}

	@GetMapping(value="listHsistoryReserveOk")
	public  List<Map<String,Object>>  getListHsistoryReserveOk(@RequestParam List<String> date){
		return reservaService.getHistoryReserveOk(date.get(0),date.get(1));
	}
	
	@GetMapping(value="listHistoryReserveCancel")
	public  List<Map<String,Object>>  getHistoryReserveCancel(@RequestParam List<String> date){
		return reservaService.getHistoryReserveCancel(date.get(0),date.get(1));
	}
	
	@GetMapping(value="listIndividualAvailableRoom")
	@ResponseBody
	public  List<Room> getListIndividualAvailableRoom(@RequestParam List<String> date){
		List<Room> list = roomService.getRooms(reservaService.getIndividualAvailableRoom(date.get(0),date.get(1)));
		return list;
	}	


	@GetMapping(value="listSharedAvailableRoom")
	@ResponseBody
	public  List<Map<String,Object>> getlistSharedRoomAvailable(@RequestParam List<String> date){
		//List<Room> list = roomService.getRooms(reservaService.getSharedRoomAvailable(date.get(0),date.get(1)));
		return reservaService.getSharedRoomAvailable(date.get(0),date.get(1));
	}	

	@GetMapping(value="actually")
	public List<Reserve> getListActually(){
		return reservaService.getAllActally(new Integer(2),"2019-03-07");
	}
	
	/*-----------Servicios pagina --------------------*/
//	@GetMapping(value="ListSharedAvailableRoom/{id}")
//	@ResponseBody
//	public  List<Map<String,Object>> getReserveUser(@RequestHeader(value= "token") String user, @PathVariable int id){
//		
//		if(user.equals("dsfdsgfdgdfsgsfgdfgdsgsfadsfsd")) {
//			System.out.println("Token sirve");
//			return reservaService.getReserveUser(id);
//		}
//		
//		//List<Room> list = roomService.getRooms(reservaService.getSharedRoomAvailable(date.get(0),date.get(1)));
//		System.out.println("Token no sirve");
//		return  reservaService.getReserveUser(0);
//	}	
	
	@GetMapping(value="listSharedAvailableRoom/{id}")
	@ResponseBody
	public  List<Map<String,Object>> getReserveUser(@PathVariable int id){
		return  reservaService.getReserveUser(id);
	}	
	
	@GetMapping(value="individualAvailabilityRoom")
	@ResponseBody
	public  int getIndividualAvailability(@RequestParam List<String> date){
		return reservaService.getIndividualAvailability(date.get(0),date.get(1));
	}	
	
	@GetMapping(value="sharedAvailability")
	@ResponseBody
	public  int getSharedAvailability(@RequestParam List<String> date){
		return reservaService.getSharedAvailability(date.get(0),date.get(1), Integer.parseInt(date.get(2)));
	}	

	
	
	
	/*----------------------Servicios pagina ------------------------------*/
	


	@PostMapping(value="")
	public RestResponse create(@RequestBody Reserve reserva) {
		System.out.println(reserva.getDateReserve());
		System.out.println(reserva.getDeteInput());
		System.out.println(reserva.getDateOutput());
		if(reserva.getIdStateReserve() == null) {
			Bill bill= new Bill(billService.getIdCount(), reserva.getDateReserve());
			reserva.setIdBill(bill.getId());
			reserva.setIdStateReserve(1);
			billService.save(bill);
		}
		reservaService.save(reserva);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	@DeleteMapping(value = "{id}")
	public RestResponse remove(@PathVariable int id){
		try {
			reservaService.remove(id);
			return new RestResponse(HttpStatus.OK.value(), "Reserva borrado");
		} catch (Exception e) {
			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "reserva no encontrado");
		}
	}
}
