package com.booking.dao;

import java.util.List;
import com.booking.model.Reservation;

public interface ReservationDAO {
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByRoomId(int roomId);
    Reservation getReservationById(int reservationId);
    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void cancelReservation(int reservationId);
}
