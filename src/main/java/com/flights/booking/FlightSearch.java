package com.flights.booking;

import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flights.booking.beans.FlightSearchRequestVO;
import com.flights.booking.domain.Flight;
import com.google.inject.Guice;
import com.google.inject.Injector;

@Path("/flights")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FlightSearch 
{
	
	Injector injector = Guice.createInjector(new FlightServiceModule());
	FlightService flightService = injector.getInstance(FlightService.class);
	
	
	@GET
	public List<Flight> getOneWayFlights(@BeanParam FlightSearchRequestVO filterBean) {

			return flightService.getOneWayFlights(filterBean);
	}
	
	@GET
	public Map<String,List<Flight>> getReturnFlights(@BeanParam FlightSearchRequestVO filterBean) {
		return flightService.getRoundTripFlights(filterBean);
	}

	
}