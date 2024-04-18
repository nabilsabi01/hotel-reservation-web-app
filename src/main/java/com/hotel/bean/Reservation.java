package com.hotel.bean;

import java.sql.Date;

public class Reservation {
    private int roomId;
    private Date startDate;
    private Date endDate;
    private String guestName;
    private String email;
    private String phoneNumber;
    private double totalPrice;
    private boolean reservationStatus;
    
	public Reservation() {
		super();
	}

	public Reservation(int roomId, Date startDate, Date endDate, String guestName, String email,
			String phoneNumber, double totalPrice, boolean reservationStatus) {
		super();
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.guestName = guestName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.totalPrice = totalPrice;
		this.reservationStatus = reservationStatus;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}  
}
