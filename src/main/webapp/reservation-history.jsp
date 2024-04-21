<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation History</title>
    <link rel="stylesheet" href="styles.css">
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Add your custom CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
        }
        .logo {
            width: 150px;
            height: auto;
        }
        nav {
            background-color: #444;
            text-align: center;
            padding: 10px;
        }
        nav a {
            color: #fff;
            text-decoration: none;
            padding: 10px;
            margin: 0 5px;
        }
        nav a:hover {
            background-color: #555;
        }
        main {
            padding: 20px;
        }
        .card {
            margin-bottom: 20px;
        }
        .card-header {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        .card-body {
            font-size: 16px;
        }
    </style>
</head>
<body>
    <header>
        <img src="logo.png" alt="https://www.flaticon.com/free-icon/booking_2460875" class="logo">
    </header>
    <nav>
        <a href="home.jsp">Home</a>
        <a href="search-rooms.jsp">Search Rooms</a>
        <a href="reservation-history.jsp">Reservation History</a>
    </nav>
    <main>
        <div class="container">
            <h2 class="text-center mb-4">Reservation History</h2>
            <div class="row">
                <c:forEach var="reservation" items="${reservations}">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header">
                                Reservation ID: ${reservation.reservationId}
                            </div>
                            <div class="card-body">
                                <p>Room ID: ${reservation.roomId}</p>
                                <p>Check-in Date: ${reservation.checkInDate}</p>
                                <p>Check-out Date: ${reservation.checkOutDate}</p>
                                <p>Guest Name: ${reservation.guestName}</p>
                                <p>Email: ${reservation.email}</p>
                                <p>Phone Number: ${reservation.phoneNumber}</p>
                                <p>Total Price: $${reservation.totalPrice}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
    <footer>
        &copy; 2022 Our Hotel. All rights reserved.
    </footer>
</body>
</html>
