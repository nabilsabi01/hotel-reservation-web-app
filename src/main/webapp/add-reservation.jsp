<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room Reservation</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .reservation-form {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="reservation-form">
                    <h2 class="text-center mb-4">Room Reservation</h2>
                    <form action="add-reservation" method="post">
                        <input type="hidden" name="roomId" value="${param.roomId}">
                        <div class="form-group">
                            <label for="guestName">Guest Name</label>
                            <input type="text" class="form-control" id="guestName" name="guestName" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber">Phone Number</label>
                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
                        </div>
                        <div class="form-group">
                            <label for="startDate">Start Date</label>
                            <input type="date" class="form-control" id="startDate" name="startDate" required>
                        </div>
                        <div class="form-group">
                            <label for="endDate">End Date</label>
                            <input type="date" class="form-control" id="endDate" name="endDate" required>
                        </div>
                        <div class="form-group">
                            <label for="totalPrice">Total Price</label>
                            <input type="text" class="form-control" id="totalPrice" name="totalPrice" readonly>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Submit Reservation</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        // Function to calculate total price
        function calculateTotalPrice() {
            var startDate = new Date(document.getElementById("startDate").value);
            var endDate = new Date(document.getElementById("endDate").value);
            var pricePerNight = ${param.pricePerNight}; // Replace with actual price per night value
            var difference = endDate.getTime() - startDate.getTime();
            var numOfNights = Math.ceil(difference / (1000 * 60 * 60 * 24)); // Convert milliseconds to days
            var totalPrice = numOfNights * pricePerNight;
            document.getElementById("totalPrice").value = totalPrice.toFixed(2);
        }

        // Calculate total price on page load
        calculateTotalPrice();

        // Calculate total price whenever start date or end date changes
        document.getElementById("startDate").addEventListener("change", calculateTotalPrice);
        document.getElementById("endDate").addEventListener("change", calculateTotalPrice);
    </script>
</body>
</html>
