package com.hotel.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.bean.Reservation;
import com.hotel.dao.ReservationDao;
import com.hotel.dao.ReservationDaoImpl;
import com.hotel.dao.RoomDao;
import com.hotel.dao.RoomDaoImpl;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReservationDao reservationDao;

	public void init() {
		reservationDao = new ReservationDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		String guestName = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone");
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		boolean reservationStatus = Boolean.parseBoolean(request.getParameter("reservationStatus"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new Date(dateFormat.parse(startDateStr).getTime());
			endDate = new Date(dateFormat.parse(endDateStr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Reservation reservation = new Reservation(roomId, startDate, endDate, guestName, email, phoneNumber, totalPrice,
				reservationStatus);
		reservationDao.addReservation(reservation);
		RoomDao roomDao = new RoomDaoImpl();
        roomDao.updateRoomAvailability(roomId, false);
        response.sendRedirect("list-room.jsp");
	}

}
