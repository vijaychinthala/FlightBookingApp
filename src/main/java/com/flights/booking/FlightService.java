package com.flights.booking;

import java.util.*;

import com.flights.booking.beans.FlightSearchRequestVO;
import com.flights.booking.domain.Flight;

public interface FlightService {
	
	public List<Flight> getOneWayFlights(FlightSearchRequestVO searchRequest);
	
	public Map<String,List<Flight>> getRoundTripFlights(FlightSearchRequestVO searchRequest);
	
}
