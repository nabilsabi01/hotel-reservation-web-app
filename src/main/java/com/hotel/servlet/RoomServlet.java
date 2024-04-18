package com.hotel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.bean.Room;
import com.hotel.dao.RoomDao;
import com.hotel.dao.RoomDaoImpl;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomDao roomDao;

	public void init() {
		roomDao = new RoomDaoImpl(); // Initialize RoomDao implementation
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve all rooms from the database
		List<Room> rooms = roomDao.getAllRooms();
//
//		request.setAttribute("rooms", rooms);
//
//		request.getRequestDispatcher("add-room.jsp").forward(request, response);
		request.setAttribute("rooms", rooms);

        // Forward the request to the JSP
        request.getRequestDispatcher("/room-card.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
