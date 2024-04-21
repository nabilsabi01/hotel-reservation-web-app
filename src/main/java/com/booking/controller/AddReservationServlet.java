package com.booking.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.ReservationDAO;
import com.booking.dao.ReservationDAOImpl;
import com.booking.model.Reservation;

@WebServlet("/add-reservation")
public class AddReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReservationDAO reservationDao;

    public void init() throws ServletException {
        reservationDao = new ReservationDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

        // Create a new Reservation object
        Reservation reservation = new Reservation(0, roomId, startDate, endDate, guestName, email, phoneNumber, totalPrice);

        // Use ReservationDao to add the reservation to the database
        reservationDao.addReservation(reservation);

        // Redirect to a success page
        response.sendRedirect(request.getContextPath() + "/list-rooms");
    }
}
