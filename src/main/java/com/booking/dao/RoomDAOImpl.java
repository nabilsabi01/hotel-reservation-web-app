package com.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.booking.model.Room;
import com.booking.util.DBUtil;

public class RoomDAOImpl implements RoomDAO {
    private static final String GET_ALL_ROOMS = "SELECT * FROM rooms";
    private static final String GET_ROOM_BY_ID = "SELECT * FROM rooms WHERE room_id = ?";
    private static final String ADD_ROOM = "INSERT INTO rooms (room_type, capacity, price_per_night, equipment, available, image_url) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ROOM = "UPDATE rooms SET room_type = ?, capacity = ?, price_per_night = ?, equipment = ?, available = ?, image_url = ? WHERE room_id = ?";
    private static final String DELETE_ROOM = "DELETE FROM rooms WHERE room_id = ?";

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ROOMS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int roomId = resultSet.getInt("room_id");
                String roomType = resultSet.getString("room_type");
                int capacity = resultSet.getInt("capacity");
                double pricePerNight = resultSet.getDouble("price_per_night");
                String equipment = resultSet.getString("equipment");
                boolean available = resultSet.getBoolean("available");
                String imageUrl = resultSet.getString("image_url");
                rooms.add(new Room(roomId, roomType, capacity, pricePerNight, equipment, available, imageUrl));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room getRoomById(int roomId) {
        Room room = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ROOM_BY_ID)) {
            statement.setInt(1, roomId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String roomType = resultSet.getString("room_type");
                    int capacity = resultSet.getInt("capacity");
                    double pricePerNight = resultSet.getDouble("price_per_night");
                    String equipment = resultSet.getString("equipment");
                    boolean available = resultSet.getBoolean("available");
                    String imageUrl = resultSet.getString("image_url");
                    room = new Room(roomId, roomType, capacity, pricePerNight, equipment, available, imageUrl);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public void addRoom(Room room) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_ROOM)) {
            statement.setString(1, room.getRoomType());
            statement.setInt(2, room.getCapacity());
            statement.setDouble(3, room.getPricePerNight());
            statement.setString(4, room.getEquipment());
            statement.setBoolean(5, room.isAvailable());
            statement.setString(6, room.getImageUrl());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM)) {
            statement.setString(1, room.getRoomType());
            statement.setInt(2, room.getCapacity());
            statement.setDouble(3, room.getPricePerNight());
            statement.setString(4, room.getEquipment());
            statement.setBoolean(5, room.isAvailable());
            statement.setString(6, room.getImageUrl());
            statement.setInt(7, room.getRoomId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOM)) {
            statement.setInt(1, roomId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
