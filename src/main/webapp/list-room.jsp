<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room List</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .search-bar {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Room List</h2>
        <div class="search-bar">
            <input type="text" class="form-control" placeholder="Search...">
        </div>
        <div class="row">
            <c:forEach var="room" items="${rooms}">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${room.roomType}</h5>
                            <p class="card-text">
                                <strong>Capacity:</strong> ${room.capacity}<br>
                                <strong>Price Per Night:</strong> ${room.pricePerNight}<br>
                                <strong>Equipment:</strong> ${room.equipment}<br>
                                <strong>Available:</strong> ${room.available ? 'Yes' : 'No'}
                            </p>
                            <button class="btn btn-primary" onclick="reserveRoom(${room.roomId})">Reserve</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function reserveRoom(roomId) {
            // Redirect to the reservation form page with roomId as a parameter
            window.location.href = "reservation-form.jsp?roomId=" + roomId;
        }
    </script>
</body>
</html>
