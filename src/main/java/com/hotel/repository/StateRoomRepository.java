package com.hotel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.models.StateRoom;

@Repository
public interface StateRoomRepository extends JpaRepository<StateRoom, Integer> {

}
