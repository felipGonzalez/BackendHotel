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
	
	@Query(value = "SELECT * FROM RESERVAS where id_estado_reserva = ?1 and current_date() = ?2 ", nativeQuery = true)
	 List<Reserve> selectAll(Integer stateRoom, String date); 
	
	@Query(value = "SELECT * FROM RESERVAS where id_estado_reserva != 4 and id_estado_reserva != 5", nativeQuery = true)
	List<Reserve> findReserveActually();
	
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
	@Query(value = "select CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) AS nombres, x.importe AS importe, fecha_inicial, fecha_final\r\n" + 
			"FROM clientes c, reservas r, (select r.id_reserva, case when r.id_tipo_reserva = 1 then\r\n" + 
			"								precio_tipo_reserva\r\n" + 
			"                                else precio_tipo_reserva * r.numero_camas_reserva\r\n" + 
			"                                end importe\r\n" + 
			"								from reservas r, tipos_reserva t\r\n" + 
			"								where r.id_tipo_reserva = t.id_tipo_reserva) x\r\n" + 
			"WHERE r.id_cliente = c.id_cliente\r\n" + 
			"AND current_date() = fecha_final\r\n" + 
			"AND r.id_estado_reserva =3\r\n" + 
			"AND r.id_reserva = x.id_reserva;", nativeQuery = true)
	List<Map<String,Object>>  findUserOutput(); 
	
	
	/* En estancia hoy*/
	@Query(value = "select CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) AS nombres, x.importe AS importe, fecha_inicial, fecha_final\r\n" + 
			"FROM clientes c, reservas r, (select r.id_reserva, case when r.id_tipo_reserva = 1 then\r\n" + 
			"								precio_tipo_reserva\r\n" + 
			"                                else precio_tipo_reserva * r.numero_camas_reserva\r\n" + 
			"                                end importe\r\n" + 
			"								from reservas r, tipos_reserva t\r\n" + 
			"								where r.id_tipo_reserva = t.id_tipo_reserva) x\r\n" + 
			"WHERE r.id_cliente = c.id_cliente\r\n" + 
			"AND r.id_estado_reserva =3\r\n" + 
			"AND r.id_reserva = x.id_reserva", nativeQuery = true)
	List<Map<String,Object>> findUserEstancia();
	
	
	/*  Historial realizadas en un rango de fecha */
	@Query(value = "select CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) AS nombres, x.importe AS importe, fecha_inicial, fecha_final\r\n" + 
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

	@Query(value = "select CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) AS nombres, x.importe AS importe,  fecha_inicial, fecha_final\r\n" + 
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
	@Query(value = "SELECT count(h.id_habitacion)\r\n" + 
			"FROM HABITACIONES h left outer join (SELECT id_habitacion\r\n" + 
			"									FROM RESERVAS R, DETALLE_RESERVA DR\r\n" + 
			"									WHERE R.ID_RESERVA = DR.ID_RESERVA\r\n" + 
			"									AND ID_TIPO_RESERVA= 1 OR ID_TIPO_RESERVA = 2\r\n" + 
			"									AND (?1 BETWEEN FECHA_INICIAL AND FECHA_FINAL \r\n" + 
			"									OR ?2 BETWEEN FECHA_INICIAL AND FECHA_FINAL)\r\n" + 
			"									AND ID_ESTADO_RESERVA = 1 OR ID_ESTADO_RESERVA = 2)x\r\n" + 
			"ON (h.id_habitacion = x.id_habitacion)\r\n" + 
			"WHERE h.id_estado_HABITACION = 1;", nativeQuery = true)
	Integer findIndividualAvailability(String dateInit, String dateEnd);
	
	@Query(value = "select fecha_inicial inicial, fecha_final final, nombre_estado_reserva estado, numero_camas_reserva camas, \r\n" + 
			"case when r.id_tipo_reserva = 1 then\r\n" + 
			"precio_tipo_reserva\r\n" + 
			"else precio_tipo_reserva * r.numero_camas_reserva\r\n" + 
			"end importe\r\n" + 
			"from reservas r, estados_reserva e, tipos_reserva t\r\n" + 
			"where id_cliente = ?1\r\n" + 
			"and r.id_estado_reserva = e.id_estado_reserva\r\n" + 
			"and r.id_tipo_reserva = t.id_tipo_reserva", nativeQuery = true)
	List<Map<String,Object>> findReserveUser(int idUser);
	
	
	
	/*  NUMERO DE CAMAS DISPONIBLES (compartida) EN LA FECHA pagina */
	@Query(value = "SELECT (CAMAS_DISPONIBLES - CAMAS_OCUPADAS) camas\r\n" + 
			"FROM (\r\n" + 
			"	(SELECT SUM(?3) CAMAS_OCUPADAS\r\n" + 
			"	 FROM RESERVAS R\r\n" + 
			"	 WHERE ( ?1 BETWEEN FECHA_INICIAL AND FECHA_FINAL\r\n" + 
			"	 OR ?2 BETWEEN FECHA_INICIAL AND FECHA_FINAL)\r\n" + 
			"	 AND ID_ESTADO_RESERVA = 1 OR ID_ESTADO_RESERVA = 2) y,\r\n" + 
			"	(SELECT SUM(capacidad_habitacion) CAMAS_DISPONIBLES\r\n" + 
			"	FROM HABITACIONES H left outer join (SELECT id_habitacion\r\n" + 
			"										 FROM RESERVAS R, DETALLE_RESERVA DR\r\n" + 
			"										 WHERE R.ID_RESERVA = DR.ID_RESERVA\r\n" + 
			"										 AND ID_TIPO_RESERVA= 1\r\n" + 
			"										 AND ( ?1  BETWEEN FECHA_INICIAL AND FECHA_FINAL\r\n" + 
			"										 OR ?2 BETWEEN FECHA_INICIAL AND FECHA_FINAL)\r\n" + 
			"										 AND ID_ESTADO_RESERVA = 1 OR ID_ESTADO_RESERVA = 2)SH\r\n" + 
			"	ON (h.id_habitacion = sh.id_habitacion)                                      \r\n" + 
			"	WHERE ID_ESTADO_HABITACION = 1) a\r\n" + 
			"	)", nativeQuery = true)
	Integer findSharedAvailability(String dateInit, String dateEnd, int bed); 
	
	 /*   consulta adimn id habitaciones tipo INDIVIDUAL sin reserva en las fechas*/
	
	@Query(value = "SELECT h.id_habitacion\r\n" + 
			"FROM HABITACIONES h left outer join (SELECT id_habitacion\r\n" + 
			"									FROM RESERVAS R, DETALLE_RESERVA DR\r\n" + 
			"									WHERE R.ID_RESERVA = DR.ID_RESERVA\r\n" + 
			"									AND (ID_TIPO_RESERVA = 1 OR ID_TIPO_RESERVA = 2)\r\n" + 
			"									AND ( ?1 BETWEEN FECHA_INICIAL AND FECHA_FINAL\r\n" + 
			"									OR ?2 BETWEEN FECHA_INICIAL AND FECHA_FINAL)\r\n" + 
			"									AND (ID_ESTADO_RESERVA = 1 OR ID_ESTADO_RESERVA = 2)) x\r\n" + 
			"ON (h.id_habitacion = x.id_habitacion)\r\n" + 
			"WHERE ID_ESTADO_HABITACION = 1;", nativeQuery = true)
	 List<Integer> findIndividualAvailableRoom(String dateInit, String dateEnd); 
	
	
		
	
	/* lista de habitacion (COMPARTIDO) con cantidad de camas disponibles */
	
	@Query(value = "SELECT H.ID_HABITACION, SUM(cantidad_camas-numero_camas_reserva) CAMAS_DISPONIBLES\r\n" + 
			"FROM HABITACIONES H, DETALLE_RESERVA DR, RESERVAS R\r\n" + 
			"WHERE H.ID_HABITACION IN (SELECT h.id_habitacion\r\n" + 
			"		                  FROM HABITACIONES h left outer join (SELECT id_habitacion\r\n" + 
			"											                      FROM RESERVAS R, DETALLE_RESERVA DR\r\n" + 
			"											                      WHERE R.ID_RESERVA = DR.ID_RESERVA\r\n" + 
			"																  AND ID_TIPO_RESERVA = 1\r\n" + 
			"																  AND ( ?1 BETWEEN FECHA_INICIAL AND FECHA_FINAL\r\n" + 
			"																  OR ?2 BETWEEN FECHA_INICIAL AND FECHA_FINAL)\r\n" + 
			"											                      AND (ID_ESTADO_RESERVA = 1 OR ESTADO_RESERVA = 2)) X\r\n" + 
			"		                  ON (h.id_habitacion = x.id_habitacion)\r\n" + 
			"						  WHERE ID_ESTADO_HABITACION=1)                      \r\n" + 
			"AND DR.ID_HABITACION=H.ID_HABITACION\r\n" + 
			"AND R.ID_RESERVA=DR.ID_RESERVA\r\n" + 
			"GROUP BY H.ID_HABITACION;", nativeQuery = true)
	List<Map<String,Object>> findSharedRoomAvailable(String dateInit, String dateEnd); 

	
	

}
