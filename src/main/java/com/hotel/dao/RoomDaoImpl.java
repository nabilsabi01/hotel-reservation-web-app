package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.bean.Room;
import com.hotel.util.DBUtil;

public class RoomDaoImpl implements RoomDao {

	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<>();
		String sql = "SELECT * FROM rooms";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				int roomId = resultSet.getInt("room_id");
				String roomType = resultSet.getString("room_type");
				int capacity = resultSet.getInt("capacity");
				double pricePerNight = resultSet.getDouble("price_per_night");
				String equipment = resultSet.getString("equipment");
				boolean isAvailable = resultSet.getBoolean("is_available");
				Room room = new Room(roomId, roomType, capacity, pricePerNight, equipment, isAvailable);
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	@Override
	public List<Room> searchRooms(String roomType, int minCapacity, double maxPrice) {
		List<Room> rooms = new ArrayList<>();
		String sql = "SELECT * FROM rooms WHERE room_type = ? AND capacity >= ? AND price_per_night <= ?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, roomType);
			statement.setInt(2, minCapacity);
			statement.setDouble(3, maxPrice);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					int roomId = resultSet.getInt("room_id");
					int capacity = resultSet.getInt("capacity");
					String equipment = resultSet.getString("equipment");
					boolean isAvailable = resultSet.getBoolean("is_available");
					Room room = new Room(roomId, roomType, capacity, maxPrice, equipment, isAvailable);
					rooms.add(room);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	 @Override
	    public boolean updateRoomAvailability(int roomId, boolean isAvailable) {
	        String sql = "UPDATE rooms SET is_available = ? WHERE room_id = ?";
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setBoolean(1, isAvailable);
	            statement.setInt(2, roomId);
	            int rowsUpdated = statement.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
