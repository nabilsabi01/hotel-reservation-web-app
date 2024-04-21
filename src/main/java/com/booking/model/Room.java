package com.booking.model;

public class Room {
    private int roomId;
    private String roomType;
    private int capacity;
    private double pricePerNight;
    private String equipment;
    private boolean available;
    private String imageUrl;

    public Room(int roomId, String roomType, int capacity, double pricePerNight, String equipment, boolean available, String imageUrl) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.equipment = equipment;
        this.available = available;
        this.imageUrl = imageUrl;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getEquipment() {
        return equipment;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}