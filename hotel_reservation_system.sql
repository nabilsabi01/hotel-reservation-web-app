CREATE DATABASE hotel_reservation_system;
USE hotel_reservation_system;
CREATE TABLE rooms(
	room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(50) NOT NULL,
    capacity INT NOT NULL,
    price_per_night DECIMAL(10, 2) NOT NULL,
    equipment VARCHAR(255),
    is_available BOOLEAN NOT NULL
);
CREATE TABLE reservations(
	reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    room_id INT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    guest_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    reservation_status BOOLEAN NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);
INSERT INTO rooms (room_type, capacity, price_per_night, equipment, is_available)
VALUES 
    ('Single', 1, 50.00, 'TV, WiFi', TRUE),
    ('Double', 2, 80.00, 'TV, WiFi, Mini Fridge', TRUE),
    ('Suite', 4, 150.00, 'TV, WiFi, Kitchenette', TRUE);
INSERT INTO reservations (room_id, start_date, end_date, guest_name, email, phone_number, total_price, reservation_status)
VALUES
    (1, '2024-05-10', '2024-05-15', 'John Doe', 'john@example.com', '1234567890', 250.00, TRUE),
    (2, '2024-06-20', '2024-06-25', 'Jane Smith', 'jane@example.com', '9876543210', 400.00, TRUE),
    (3, '2024-07-15', '2024-07-20', 'Alice Johnson', 'alice@example.com', '5554443333', 750.00, TRUE);
SELECT * FROM rooms;
SELECT * FROM reservations;