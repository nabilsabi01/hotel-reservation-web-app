package com.booking.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.booking.model.Reservation;
import com.booking.util.DBUtil;

public class ReservationDAOImpl implements ReservationDAO {
    private static final String GET_ALL_RESERVATIONS = "SELECT * FROM reservations";
    private static final String GET_RESERVATIONS_BY_ROOM_ID = "SELECT * FROM reservations WHERE room_id = ?";
    private static final String GET_RESERVATION_BY_ID = "SELECT * FROM reservations WHERE reservation_id = ?";
    private static final String ADD_RESERVATION = "INSERT INTO reservations (room_id, start_date, end_date, guest_name, email, phone_number, total_price) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_RESERVATION = "UPDATE reservations SET room_id = ?, start_date = ?, end_date = ?, guest_name = ?, email = ?, phone_number = ?, total_price = ? WHERE reservation_id = ?";
    private static final String CANCEL_RESERVATION = "DELETE FROM reservations WHERE reservation_id = ?";

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_RESERVATIONS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int reservationId = resultSet.getInt("reservation_id");
                int roomId = resultSet.getInt("room_id");
                LocalDate checkInDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate checkOutDate = resultSet.getDate("end_date").toLocalDate();
                String guestName = resultSet.getString("guest_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                double totalPrice = resultSet.getDouble("total_price");
                Reservation reservation = new Reservation(reservationId, roomId, checkInDate, checkOutDate, guestName, email, phoneNumber, totalPrice);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public List<Reservation> getReservationsByRoomId(int roomId) {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_RESERVATIONS_BY_ROOM_ID)) {
            statement.setInt(1, roomId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int reservationId = resultSet.getInt("reservation_id");
                    LocalDate checkInDate = resultSet.getDate("start_date").toLocalDate();
                    LocalDate checkOutDate = resultSet.getDate("end_date").toLocalDate();
                    String guestName = resultSet.getString("guest_name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    double totalPrice = resultSet.getDouble("total_price");
                    Reservation reservation = new Reservation(reservationId, roomId, checkInDate, checkOutDate, guestName, email, phoneNumber, totalPrice);
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        Reservation reservation = null;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_RESERVATION_BY_ID)) {
            statement.setInt(1, reservationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int roomId = resultSet.getInt("room_id");
                    LocalDate checkInDate = resultSet.getDate("start_date").toLocalDate();
                    LocalDate checkOutDate = resultSet.getDate("end_date").toLocalDate();
                    String guestName = resultSet.getString("guest_name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    double totalPrice = resultSet.getDouble("total_price");
                    reservation = new Reservation(reservationId, roomId, checkInDate, checkOutDate, guestName, email, phoneNumber, totalPrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void addReservation(Reservation reservation) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_RESERVATION)) {
            statement.setInt(1, reservation.getRoomId());
            statement.setDate(2, java.sql.Date.valueOf(reservation.getCheckInDate()));
            statement.setDate(3, java.sql.Date.valueOf(reservation.getCheckOutDate()));
            statement.setString(4, reservation.getGuestName());
            statement.setString(5, reservation.getEmail());
            statement.setString(6, reservation.getPhoneNumber());
            statement.setDouble(7, reservation.getTotalPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReservation(Reservation reservation) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RESERVATION)) {
            statement.setInt(1, reservation.getRoomId());
            statement.setDate(2, java.sql.Date.valueOf(reservation.getCheckInDate()));
            statement.setDate(3, java.sql.Date.valueOf(reservation.getCheckOutDate()));
            statement.setString(4, reservation.getGuestName());
            statement.setString(5, reservation.getEmail());
            statement.setString(6, reservation.getPhoneNumber());
            statement.setDouble(7, reservation.getTotalPrice());
            statement.setInt(8, reservation.getReservationId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelReservation(int reservationId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CANCEL_RESERVATION)) {
            statement.setInt(1, reservationId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
