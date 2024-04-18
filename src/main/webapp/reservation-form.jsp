<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Form</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Room Reservation</h2>
        <form action="reservation" method="post">
            <input type="hidden" name="roomId" value="${param.roomId}">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" class="form-control" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="datetime-local" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="datetime-local" class="form-control" id="endDate" name="endDate" required>
            </div>
            <div class="form-group">
                <label for="totalPrice">Total Price:</label>
                <input type="number" class="form-control" id="totalPrice" name="totalPrice" required>
            </div>
            <div class="form-group">
                <label for="reservationStatus">Reservation Status:</label>
                <select class="form-control" id="reservationStatus" name="reservationStatus" required>
                    <option value="true">Confirmed</option>
                    <option value="false">Pending</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit Reservation</button>
        </form>
    </div>
</body>
</html>
