package com.booking.model;

import java.time.LocalDate;

public class Reservation {
    private int reservationId;
    private int roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestName;
    private String email;
    private String phoneNumber;
    private double totalPrice;

    public Reservation(int reservationId, int roomId, LocalDate checkInDate, LocalDate checkOutDate, String guestName, String email, String phoneNumber, double totalPrice) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestName = guestName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.totalPrice = totalPrice;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
