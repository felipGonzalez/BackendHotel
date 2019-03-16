package com.hotel.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.models.Reserve;
import com.hotel.models.Room;

@Repository
public interface ReservaRepository extends JpaRepository<Reserve, Integer> {
	
	@Query(value = "SELECT * FROM reservas where id_estado_reserva = ?1 and current_date() = ?2 ", nativeQuery = true)
	 List<Reserve> selectAll(Integer stateRoom, String date); 
	
	@Query(value = "SELECT * FROM reservas where id_estado_reserva != 4 and id_estado_reserva != 1 and id_estado_reserva != 5", nativeQuery = true)
	List<Reserve> findReserveActually();
	
	@Query(value = "SELECT * FROM reservas where id_estado_reserva = 1", nativeQuery = true)
	List<Reserve> findReserveNotAssign();
	
	/* numero de clientes que entran hoy */
	@Query(value = "select count(*)  from reservas  where id_estado_reserva = 2 "
			+ "and current_date() = fecha_inicial", nativeQuery = true)
	 Integer findNumClientInput(); 
	
	/* Numero de clientes que salen hoy*/
	@Query(value = "select count(*)  from reservas  where id_estado_reserva = 3 "
			+ "and current_date() = fecha_final", nativeQuery = true)
	 Integer findNumClientOutput(); 
	
	/*   Numero de huespedes hoy*/
	@Query(value = "select sum(case when id_tipo_reserva = 1 then 1	else numero_camas_reserva end) AS huespedes "
			+ " from reservas "
			+ "where current_date()"
			+ " between fecha_inicial and fecha_final "
			+ "and id_estado_reserva = 3", nativeQuery = true)
	 Integer findNumberClientsHosted(); 
	
	/*   Habitaciones ocupadas   */
	@Query(value = "select count(distinct id_habitacion)\r\n" + 
			"from detalle_reserva d, reservas r\r\n" + 
			"where  r.id_reserva = d.id_reserva\r\n",
			 nativeQuery = true)
	Integer findOccupiedRoom();
	
	/* Entradas hoy*/
	@Query(value = "select CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) AS nombres, fecha_inicial, fecha_final\r\n" + 
			"	FROM clientes c, reservas r\r\n" + 
			"	WHERE r.id_cliente = c.id_cliente\r\n" + 
			"	AND current_date() = fecha_inicial\r\n" + 
			"	AND r.id_estado_reserva =2;", nativeQuery = true)
	List<Map<String,Object>> findUserInput();
	
	/* Sin asignar*/
	@Query(value = "select CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) AS nombres, fecha_inicial, fecha_final\r\n" + 
			"	FROM clientes c, reservas r\r\n" + 
			"	WHERE r.id_cliente = c.id_cliente\r\n" + 
			"	AND r.id_estado_reserva =1;", nativeQuery = true)
	List<Map<String,Object>> findUserAsing();
	
	
	/* salidas hoy */
	@Query(value = "select concat(c.nombre_cliente, ' ', c.apellido_cliente) as nombres, x.importe as importe, fecha_inicial, fecha_final\r\n" + 
			"from clientes c, reservas r, (select r.id_reserva, case when r.id_tipo_reserva = 1 then\r\n" + 
			"								precio_tipo_reserva\r\n" + 
			"                                else precio_tipo_reserva * r.numero_camas_reserva\r\n" + 
			"                                end importe\r\n" + 
			"								from reservas r, tipos_reserva t\r\n" + 
			"								where r.id_tipo_reserva = t.id_tipo_reserva) x\r\n" + 
			"where r.id_cliente = c.id_cliente\r\n" + 
			"and current_date() = fecha_final\r\n" + 
			"and r.id_estado_reserva =3\r\n" + 
			"and r.id_reserva = x.id_reserva;", nativeQuery = true)
	List<Map<String,Object>>  findUserOutput(); 
	
	
	/* En estancia hoy*/
	@Query(value = "select concat(c.nombre_cliente, ' ', c.apellido_cliente) as nombres, x.importe as importe, fecha_inicial, fecha_final\r\n" + 
			"from clientes c, reservas r, (select r.id_reserva, case when r.id_tipo_reserva = 1 then\r\n" + 
			"								precio_tipo_reserva\r\n" + 
			"                                else precio_tipo_reserva * r.numero_camas_reserva\r\n" + 
			"                                end importe\r\n" + 
			"								from reservas r, tipos_reserva t\r\n" + 
			"								where r.id_tipo_reserva = t.id_tipo_reserva) x\r\n" + 
			"where r.id_cliente = c.id_cliente\r\n" + 
			"and r.id_estado_reserva =3\r\n" + 
			"and r.id_reserva = x.id_reserva", nativeQuery = true)
	List<Map<String,Object>> findUserEstancia();
	
	
	/*  Historial realizadas en un rango de fecha */
	@Query(value = "select concat(c.nombre_cliente, ' ', c.apellido_cliente) as nombres, x.importe as importe, fecha_inicial, fecha_final\r\n" + 
			"	from clientes c, reservas r, (select r.id_reserva, case when r.id_tipo_reserva = 1 then\r\n" + 
			"									precio_tipo_reserva\r\n" + 
			"	                                else precio_tipo_reserva * r.numero_camas_reserva\r\n" + 
			"	                                end importe\r\n" + 
			"									from reservas r, tipos_reserva t\r\n" + 
			"									where r.id_tipo_reserva = t.id_tipo_reserva) x\r\n" + 
			"	where c.id_cliente = r.id_cliente\r\n" + 
			"	and (fecha_final between ?1 and ?2\r\n" + 
			"	or fecha_inicial between ?1 and ?2)\r\n" + 
			"	and r.id_estado_reserva =5\r\n" + 
			"	and r.id_reserva = x.id_reserva", nativeQuery = true)
	List<Map<String,Object>> findHistoryReserveOk(String dateInit, String dateEnd); 

	/*    Historial canceladas en un rango de fecha   */

	@Query(value = "select concat(c.nombre_cliente, ' ', c.apellido_cliente) as nombres, x.importe as importe,  fecha_inicial, fecha_final\r\n" + 
			"	from clientes c, reservas r, (select r.id_reserva, case when r.id_tipo_reserva = 1 then\r\n" + 
			"									precio_tipo_reserva\r\n" + 
			"	                                else precio_tipo_reserva * r.numero_camas_reserva\r\n" + 
			"	                                end importe\r\n" + 
			"									from reservas r, tipos_reserva t\r\n" + 
			"									where r.id_tipo_reserva = t.id_tipo_reserva) x\r\n" + 
			"	where c.id_cliente = r.id_cliente\r\n" + 
			"	and r.id_estado_reserva = 4\r\n" + 
			"	and fecha_reserva between ?1 and ?2\r\n" + 
			"	and r.id_reserva = x.id_reserva", nativeQuery = true)
	List<Map<String,Object>> findHistoryReserveCancel(String dateInit, String dateEnd);
	
	/*  NUMERO DE CAMAS DISPONIBLES (HAB INDIVIDUAL) EN LA FECHA pagina */
	@Query(value = "select count(h.id_habitacion) cantidad \r\n" + 
			"from habitaciones h \r\n" + 
			" where h.id_habitacion not in(select dr.id_habitacion\r\n" + 
			"									FROM RESERVAS R, DETALLE_RESERVA DR, habitaciones h\r\n" + 
			"									WHERE R.ID_RESERVA = DR.ID_RESERVA\r\n" + 
			"									and dr.id_habitacion = h.id_habitacion\r\n" + 
			"									AND (?1 BETWEEN FECHA_INICIAL AND FECHA_FINAL \r\n" + 
			"									OR ?2 BETWEEN FECHA_INICIAL AND FECHA_FINAL)\r\n" + 
			"									AND (ID_ESTADO_RESERVA = 2 OR ID_ESTADO_RESERVA = 4)\r\n" + 
			"									group by dr.id_habitacion)\r\n" + 
			"and capacidad_habitacion >=  ?3;", nativeQuery = true)
	Integer findIndividualAvailability(String dateInit, String dateEnd, int bed);
	
	@Query(value = "select fecha_inicial inicial, fecha_final final, nombre_estado_reserva estado, nombre_tipo_reserva tipo, numero_camas_reserva camas, \r\n" + 
			"case when r.id_tipo_reserva = 1 then\r\n" + 
			"precio_tipo_reserva * DATEDIFF(fecha_final, fecha_inicial)\r\n" + 
			"else \r\n" + 
			"(precio_tipo_reserva * r.numero_camas_reserva) * DATEDIFF(fecha_final, fecha_inicial)\r\n" + 
			"end importe\r\n" + 
			"from reservas r, detalle_reserva d, estados_reserva e, tipos_reserva t\r\n" + 
			"where id_cliente = ?1\r\n" + 
			"and r.id_reserva = d.id_reserva\r\n" + 
			"and r.id_estado_reserva = e.id_estado_reserva\r\n" + 
			"and r.id_tipo_reserva = t.id_tipo_reserva", nativeQuery = true)
	List<Map<String,Object>> findReserveUser(int idUser);
	
	
	
	/*  NUMERO DE CAMAS DISPONIBLES (compartida) EN LA FECHA pagina */
	@Query(value = "", nativeQuery = true)
	Integer findSharedAvailability(String dateInit, String dateEnd); 
	
	 /*   consulta adimn id habitaciones tipo INDIVIDUAL sin reserva en las fechas*/
	
	@Query(value = "select h.id_habitacion\r\n" + 
			"from habitaciones h left outer join (select id_habitacion\r\n" + 
			"									from reservas r, detalle_reserva dr\r\n" + 
			"									where r.id_reserva = dr.id_reserva\r\n" + 
			"									and (id_tipo_reserva = 1 or id_tipo_reserva = 2)\r\n" + 
			"									and (?1 between fecha_inicial and fecha_final\r\n" + 
			"									or ?2 between fecha_inicial and fecha_final)\r\n" + 
			"									and (id_estado_reserva = 1 or id_estado_reserva = 2)) x\r\n" + 
			"on (h.id_habitacion = x.id_habitacion)\r\n" + 
			"where id_estado_habitacion = 1", nativeQuery = true)
	 List<Integer> findIndividualAvailableRoom(String dateInit, String dateEnd); 
	
	
		
	
	/* lista de habitacion (COMPARTIDO) con cantidad de camas disponibles */
	
	@Query(value = "select h.id_habitacion, codigo, ifnull(y.camas_disponibles, concat(capacidad_habitacion, '')) cantidad_disponible\r\n" + 
			"	from habitaciones h left outer join (select h.id_habitacion, sum(capacidad_habitacion-numero_camas_reserva) camas_disponibles\r\n" + 
			"	from habitaciones h, detalle_reserva dr, reservas r\r\n" + 
			"	where h.id_habitacion in (select ha.id_habitacion \r\n" + 
			"								from habitaciones ha left outer join(select id_habitacion\r\n" + 
			"																	from reservas r, detalle_reserva dr\r\n" + 
			"																	where r.id_reserva=dr.id_reserva\r\n" + 
			"																	and id_tipo_reserva = 1\r\n" + 
			"																	and (?1 between fecha_inicial and fecha_final\r\n" + 
			"																	or ?2 between fecha_inicial and fecha_final)\r\n" + 
			"																	and (id_estado_reserva = 1 or id_estado_reserva = 2))x\r\n" + 
			"								on (ha.id_habitacion = x.id_habitacion)\r\n" + 
			"								where id_estado_habitacion = 1)\r\n" + 
			"	and dr.id_habitacion=h.id_habitacion\r\n" + 
			"	and r.id_reserva=dr.id_reserva\r\n" + 
			"	and (?1 between fecha_inicial and fecha_final\r\n" + 
			"	or ?2 between fecha_inicial and fecha_final)\r\n" + 
			"	group by h.id_habitacion) y\r\n" + 
			"	on (h.id_habitacion = y.id_habitacion)\r\n" + 
			"", nativeQuery = true)
	List<Map<String,Object>> findSharedRoomAvailable(String dateInit, String dateEnd); 

	
	
	
	
	@Query(value = "select documento_cliente as documento, concat(c.nombre_cliente, ' ', c.apellido_cliente) as nombres, fecha_reserva, fecha_inicial, fecha_final,\r\n" + 
			"	nombre_tipo_reserva tipo,\r\n" + 
			"	case when r.id_tipo_reserva = 1\r\n" + 
			"	then precio_tipo_reserva * capacidad_habitacion\r\n" + 
			"	else precio_tipo_reserva  * numero_camas_reserva\r\n" + 
			"	end valor\r\n" + 
			"	from clientes c, reservas r, tipos_reserva t, detalle_reserva d, habitaciones h\r\n" + 
			"	where c.id_cliente = r.id_cliente\r\n" + 
			"	and r.id_reserva = d.id_reserva\r\n" + 
			"	and r.id_tipo_reserva = t.id_tipo_reserva\r\n" + 
			"	and d.id_habitacion = h.id_habitacion\r\n" + 
			"	and id_estado_reserva = 5\r\n" + 
			"	order by fecha_reserva desc;", nativeQuery = true)
	List<Map<String,Object>> findHistoryBill(); 
	
	

}

