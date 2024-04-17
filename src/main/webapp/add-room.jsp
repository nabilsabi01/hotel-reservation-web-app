<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room List</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Room List</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Room ID</th>
                    <th>Room Type</th>
                    <th>Capacity</th>
                    <th>Price Per Night</th>
                    <th>Equipment</th>
                    <th>Available</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="room" items="${rooms}">
                    <tr>
                        <td>${room.roomId}</td>
                        <td>${room.roomType}</td>
                        <td>${room.capacity}</td>
                        <td>${room.pricePerNight}</td>
                        <td>${room.equipment}</td>
                        <td>
                            <c:choose>
                                <c:when test="${room.available}">
                                    Yes
                                </c:when>
                                <c:otherwise>
                                    No
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
