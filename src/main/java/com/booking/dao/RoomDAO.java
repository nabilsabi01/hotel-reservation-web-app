package com.booking.dao;

import java.util.List;
import com.booking.model.Room;

public interface RoomDAO {
    List<Room> getAllRooms();
    Room getRoomById(int roomId);
    void addRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(int roomId);
}
