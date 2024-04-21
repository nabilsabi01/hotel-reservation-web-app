package com.booking.controller;

import com.booking.dao.RoomDAO;

import com.booking.dao.RoomDAOImpl;
import com.booking.model.Room;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ListRoomsServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoomDAO roomDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        roomDAO = new RoomDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the list of rooms from the database
        List<Room> rooms = roomDAO.getAllRooms();

        // Set the list of rooms as an attribute in the request
        request.setAttribute("rooms", rooms);

        // Forward the request to the JSP for rendering
        request.getRequestDispatcher("list-rooms.jsp").forward(request, response);
    }
}
