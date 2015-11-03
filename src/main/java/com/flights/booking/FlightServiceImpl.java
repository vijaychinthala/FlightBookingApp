package com.flights.booking;

import java.util.*;

import com.flights.booking.beans.FlightSearchRequestVO;
import com.flights.booking.domain.Flight;

public class FlightServiceImpl implements FlightService {
	
	FlightDAO flightDAO; 

	public void setFlightDAO(FlightDAO flightDAO) {
		this.flightDAO = flightDAO;
	}

	/*
	 * This method pull the one way flights
	 * (non-Javadoc)
	 * @see com.flights.search.service.FlightService
	 * #getOneWayFlights(com.flights.search.beans.FlightSearchRequestVO) 
	 * @param com.flights.search.beans.FlightSearchRequestVO
	 * @return Map<String,List<Flight>>
	 */
	public List<Flight> getOneWayFlights(FlightSearchRequestVO searchRequest) {
		return flightDAO.findFlights(searchRequest.getFrom(),searchRequest.getTo(),searchRequest.getStartDate(),
				searchRequest.getTravelClass(),searchRequest.getNoOfPersons());
	}
	
	/* 
	 * This method pull the round trip flights
	 * (non-Javadoc)
	 * @see com.flights.search.service.FlightService
	 * #getRoundTripFlights(com.flights.search.beans.FlightSearchRequestVO)
	 * @param com.flights.search.beans.FlightSearchRequestVO
	 * @return Map<String,List<Flight>>
	 */
	public Map<String,List<Flight>> getRoundTripFlights(FlightSearchRequestVO searchRequest) {
		Map<String, List<Flight>> flightResults = new HashMap<String, List<Flight>>();
		
		//one way flights
		flightResults.put("onewayflights",flightDAO.findFlights(searchRequest.getFrom(),searchRequest.getTo(),
				searchRequest.getStartDate(),searchRequest.getTravelClass(),searchRequest.getNoOfPersons()));
		
		//returning flights
		flightResults.put("retflights",flightDAO.findFlights(searchRequest.getTo(),searchRequest.getFrom(),
				searchRequest.getReturnDate(),searchRequest.getTravelClass(),searchRequest.getNoOfPersons()));
		
		return flightResults;
	}	

}
