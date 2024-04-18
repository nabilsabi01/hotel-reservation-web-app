package com.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.bean.Reservation;
import com.hotel.util.DBUtil;

public class ReservationDaoImpl implements ReservationDao {

	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = new ArrayList<>();
		String sql = "SELECT * FROM reservations";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				int roomId = resultSet.getInt("room_id");
				Date startDate = resultSet.getDate("start_date");
				Date endDate = resultSet.getDate("end_date");
				String guestName = resultSet.getString("guest_name");
				String email = resultSet.getString("email");
				String phoneNumber = resultSet.getString("phone_number");
				double totalPrice = resultSet.getDouble("total_price");
				boolean reservationStatus = resultSet.getBoolean("reservation_status");
				Reservation reservation = new Reservation(roomId, startDate, endDate, guestName, email,
						phoneNumber, totalPrice, reservationStatus);
				reservations.add(reservation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public List<Reservation> searchReservations(String guestName, String email, String phoneNumber) {
		return null;
	}

	@Override
	public boolean addReservation(Reservation reservation) {
		String sql = "INSERT INTO reservations (room_id, start_date, end_date, guest_name, email, phone_number, total_price, reservation_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, reservation.getRoomId());
			statement.setDate(2, reservation.getStartDate());
			statement.setDate(3, reservation.getEndDate());
			statement.setString(4, reservation.getGuestName());
			statement.setString(5, reservation.getEmail());
			statement.setString(6, reservation.getPhoneNumber());
			statement.setDouble(7, reservation.getTotalPrice());
			statement.setBoolean(8, reservation.isReservationStatus());
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteReservation(int reservationId) {
		String sql = "DELETE FROM reservations WHERE reservation_id=?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, reservationId);
			int rowsDeleted = statement.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
