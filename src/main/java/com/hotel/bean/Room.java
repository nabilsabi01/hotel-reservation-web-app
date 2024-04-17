package com.hotel.bean;

public class Room {
	private int roomId;
	private String roomType;
	private int capacity;
	private double pricePerNight;
	private String equipment;
	private boolean isAvailable;

	public Room() {
		super();
	}

	public Room(int roomId, String roomType, int capacity, double pricePerNight, String equipment,
			boolean isAvailable) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.capacity = capacity;
		this.pricePerNight = pricePerNight;
		this.equipment = equipment;
		this.isAvailable = isAvailable;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
