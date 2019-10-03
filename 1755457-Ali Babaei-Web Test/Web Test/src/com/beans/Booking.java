package com.beans;

public class Booking {
	private int bookingID;
	private String customername;
	private String licenseNo;
	private String vehicleMake;
	private String date;
	
	public Booking( String customername, String licenseNo, String vehicleMake, String date) {
		super();
		
		this.customername = customername;
		this.licenseNo = licenseNo;
		this.vehicleMake = vehicleMake;
		this.date = date;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
