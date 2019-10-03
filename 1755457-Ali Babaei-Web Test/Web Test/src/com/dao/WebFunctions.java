package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Booking;
import com.util.DBUtil;

public class WebFunctions {

	// this function will add a booking into database
	public int addBooking(Booking booking) {
		Connection con = null;
		try {
			con = DBUtil.getDBConnection();

			String query = "insert into tbl_booking (customerName, licenseNo, vehicleMake, proposedDate) values (?,?,?, TO_DATE(? , 'dd-mm-yyyy'))";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, booking.getCustomername());
			pstmt.setString(2, booking.getLicenseNo());
			pstmt.setString(3, booking.getVehicleMake());
			pstmt.setString(4, booking.getDate());

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
			return -1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}

	// given the date this function will retrieve all the bookings
	// and return it as a list of bookings
	public List<Booking> searchBooking(String date) {
		List<Booking> bookingList = new ArrayList<Booking>();

		Connection con = null;
		try {

			con = DBUtil.getDBConnection();
			String query = "select * from tbl_booking where proposedDate = TO_DATE( ? , 'dd-mm-yyyy')";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, date);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int booking_id = rs.getInt("bookingID");
				String customerName = rs.getString("customerName");
				String licenseNo = rs.getString("licenseNo");
				String vehicleMake = rs.getString("vehicleMake");
				String proposedDate = rs.getString("proposedDate");

				Booking booking = new Booking(customerName, licenseNo, vehicleMake, proposedDate);

				bookingList.add(booking);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		return bookingList;
	}

	// this function will cancel a booking
	public int deleteBooking(int bookingID) {
		Connection con = null;
		try {

			con = DBUtil.getDBConnection();

			String query = "delete from tbl_booking where bookingid = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, bookingID);

			pstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
			return -1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			try {
				DBUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		}
		return 1;
	}

}
