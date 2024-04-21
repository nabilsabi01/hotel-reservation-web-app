<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Rooms</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container my-5">
        <h1 class="mb-4">List of Rooms</h1>
        <div class="row">
            <c:forEach var="room" items="${rooms}">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="<c:out value="${room.imageUrl}" />" class="card-img-top" alt="Room Image">
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${room.roomType}" /></h5>
                            <p class="card-text">Capacity: <c:out value="${room.capacity}" /></p>
                            <p class="card-text">Price per Night: $<c:out value="${room.pricePerNight}" /></p>
                            <c:if test="${room.available}">
                                <span class="badge badge-success">Available</span>
                            </c:if>
                            <c:if test="${!room.available}">
                                <span class="badge badge-danger">Not Available</span>
                            </c:if>
                            <a href="add-reservation.jsp?roomId=${room.roomId}&pricePerNight=${room.pricePerNight}" class="btn btn-primary float-right">Reserve</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <script>
        function reserveRoom(roomId, pricePerNight) {
            // Redirect to the add-reservation servlet with roomId and pricePerNight parameters
            window.location.href = "add-reservation?roomId=" + roomId + "&pricePerNight=" + pricePerNight;
        }
    </script>
</body>
</html>
