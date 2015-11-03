package com.flights.booking.domain;

import java.util.*;

public class Flight {
	
	private long flightId;
	private String from;
	private String to;
	private String travelClass;
	private Date date;
	private int hrs; 
	private int noOfPassengers;
	private int price;
	private int noOfStops;
		
	public Flight(long flightId, String from, String to, String travelClass, Date date, int hrs, int noOfPassengers, int price,
			int noOfStops) {
		super();
		this.flightId = flightId;
		this.from = from;
		this.to = to;
		this.travelClass = travelClass;
		this.date = date;
		this.hrs = hrs;
		this.noOfPassengers = noOfPassengers;
		this.price = price;
		this.noOfStops = noOfStops;
	}
	
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}	
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHrs() {
		return hrs;
	}
	public void setHrs(int hrs) {
		this.hrs = hrs;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNoOfStops() {
		return noOfStops;
	}
	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}
	
}
