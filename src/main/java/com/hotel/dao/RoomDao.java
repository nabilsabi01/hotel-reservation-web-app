package com.hotel.dao;

import java.util.List;

import com.hotel.bean.Room;

public interface RoomDao {
	List<Room> getAllRooms();
    List<Room> searchRooms(String roomType, int minCapacity, double maxPrice);
}
