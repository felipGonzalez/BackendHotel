package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.models.StateReserve;
import com.hotel.models.StateRoom;

public interface StateReserveRepository extends JpaRepository<StateReserve, Integer>{

}
