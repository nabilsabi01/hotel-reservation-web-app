package com.hotel.dao;

import java.util.List;

import com.hotel.bean.Reservation;

public interface ReservationDao {
	List<Reservation> getAllReservations();
    List<Reservation> searchReservations(String guestName, String email, String phoneNumber);
    boolean addReservation(Reservation reservation);
    boolean deleteReservation(int reservationId);
}
