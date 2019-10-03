package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Booking;
import com.dao.WebFunctions;


/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String page = request.getParameter("page");
		//this page will add a booking
		if("booking_page".equals(page)) {
			
			String customerName  = request.getParameter("customer_name");
			String license_no  = request.getParameter("license_no");
			String vehicle_make = request.getParameter("vehicle_make");
			String drive_date = request.getParameter("drive_date");
			
			Booking booking = new Booking(customerName, license_no, vehicle_make, drive_date);
			WebFunctions webFunctions = new WebFunctions();
			
			int success = webFunctions.addBooking(booking);
			
			
			request.setAttribute("booking_success", success);
		
			//response.sendRedirect("successPage.html");
			
			RequestDispatcher reqDispatch;
			if(success == 1) {
				 reqDispatch = request.getRequestDispatcher("pages/Confirmation.jsp");
			}
			else
			{
				reqDispatch = request.getRequestDispatcher("pages/Error.jsp");
			}
			
			reqDispatch.forward(request, response);
			
		}
		//this page will search for the booking given the date
		else if("view_page".equals(page)) {
			
			String date = request.getParameter("booking_date");
		
			WebFunctions webFunctions = new WebFunctions();
			
			
			List<Booking> bookingList = webFunctions.searchBooking(date);
			
			request.setAttribute("booking_search", bookingList);
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/ViewBooking.jsp");
			reqDispatch.forward(request, response);	
			
		}
		else if("cancel_page".equals(page)) {
			int bookingID  = Integer.parseInt(request.getParameter("bookingID"));
			
			WebFunctions webFunctions = new WebFunctions();
			int success = webFunctions.deleteBooking(bookingID);
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/Homepage.jsp");
			reqDispatch.forward(request, response);	
		}
		
	}
}
