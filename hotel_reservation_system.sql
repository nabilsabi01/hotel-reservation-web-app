-- Create database
CREATE DATABASE hotel_reservation_system;

-- Use the created database
USE hotel_reservation_system;

-- Create rooms table
CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(100) NOT NULL,
    capacity INT NOT NULL,
    price_per_night DECIMAL(10, 2) NOT NULL,
    equipment VARCHAR(255),
    is_available BOOLEAN NOT NULL DEFAULT true,
    image_url VARCHAR(255)
);

-- Sample data for rooms table
INSERT INTO rooms (room_type, capacity, price_per_night, equipment, image_url)
VALUES 
    ('Single', 1, 100.00, 'TV, AC', 'https://images.pexels.com/photos/276724/pexels-photo-276724.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2'),
    ('Double', 2, 150.00, 'TV, AC, Mini Fridge', 'https://images.pexels.com/photos/439227/pexels-photo-439227.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2'),
    ('Suite', 4, 250.00, 'TV, AC, Mini Fridge, Jacuzzi', 'https://images.pexels.com/photos/1571453/pexels-photo-1571453.jpeg');

-- Create reservations table
CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    guest_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);

-- Trigger to set is_available to false when a reservation is added
DELIMITER //
CREATE TRIGGER set_room_unavailable
AFTER INSERT ON reservations
FOR EACH ROW
BEGIN
    UPDATE rooms
    SET is_available = false
    WHERE room_id = NEW.room_id;
END;
//

-- Trigger to set is_available to true when a reservation end date has passed
DELIMITER //
CREATE TRIGGER set_room_available
BEFORE UPDATE ON reservations
FOR EACH ROW
BEGIN
    IF OLD.end_date < CURDATE() THEN
        UPDATE rooms
        SET is_available = true
        WHERE room_id = OLD.room_id;
    END IF;
END;
//
DELIMITER ;
