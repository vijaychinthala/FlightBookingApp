package com.flights.search;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import com.flights.booking.*;
import com.flights.booking.beans.FlightSearchRequestVO;
import com.flights.booking.domain.Flight;
import com.google.inject.*; 

import org.junit.*;

public class FlightServiceTest {
	
	private FlightDAO mockFlightDao;
	private FlightService flightService;		
	
	
	@Before
 	public void setUp() {
		Injector injector = Guice.createInjector(new FlightServiceModule());
		flightService = injector.getInstance(FlightService.class);	
		mockFlightDao = mock(FlightDAO.class);  
    }
	
	@Test
    public void getOneWayFlights() {
    	 
    	FlightSearchRequestVO flightSearchRequest =  new FlightSearchRequestVO("SFO","Los Angles","11/2/2015","11/15/2015","Business",2);
    	
    	List<Flight> dummyFlights = new ArrayList<Flight>();
    	//Flight(flightId, from, to, travelClass, date, hrs, noOfPassengers, price, noOfStops)
    	dummyFlights.add(new Flight(1273L,"SFO","Los Angles","Business",new Date(),1,10,180,0));
    	dummyFlights.add(new Flight(1583L,"SFO","Los Angles","Business",new Date(),2,30,140,1));
    	dummyFlights.add(new Flight(1633L,"SFO","Los Angles","Business",new Date(),1,24,180,0));
    	
    	when(mockFlightDao.findFlights(anyString(),anyString(),anyString(),anyString(),anyInt())).thenReturn(dummyFlights);
    	
    	List<Flight> flightsOneWay = flightService.getOneWayFlights(flightSearchRequest);
  		
  		verify(mockFlightDao,times(1)).findFlights(anyString(),anyString(),anyString(),anyString(),anyInt());  		
        assertEquals(flightsOneWay.size(), 3);
    }
	

	
	@Test
    public void getRoundTripFlights() {
    	 
    	FlightSearchRequestVO flightSearchRequest =  new FlightSearchRequestVO("SFO","Los Angles","11/2/2015","11/15/2015","Business",2);
    	    	
    	List<Flight> dummyFlights = new ArrayList<Flight>();
    	//Flight(flightId, from, to, travelClass, date, hrs, noOfPassengers, price, noOfStops)
    	dummyFlights.add(new Flight(1273L,"SFO","Los Angles","Business",new Date(),1,10,180,0));
    	dummyFlights.add(new Flight(1583L,"SFO","Los Angles","Business",new Date(),2,30,140,1));
    	dummyFlights.add(new Flight(1633L,"SFO","Los Angles","Business",new Date(),1,24,180,0));
    	
    	List<Flight> dummyReturnFlights = new ArrayList<Flight>();
    	//Flight(flightId, from, to, travelClass, date, hrs, noOfPassengers, price, noOfStops)
    	dummyFlights.add(new Flight(1273L,"Los Angles","SFO","Business",new Date(),1,10,180,0));
    	dummyFlights.add(new Flight(1583L,"Los Angles","SFO","Business",new Date(),2,30,140,1)); 
    	dummyFlights.add(new Flight(1273L,"Los Angles","SFO","Business",new Date(),1,15,180,0));
    	
    	when(mockFlightDao.findFlights(anyString(),anyString(),anyString(),anyString(),anyInt())).thenReturn(dummyFlights);
    	when(mockFlightDao.findFlights(anyString(),anyString(),anyString(),anyString(),anyInt())).thenReturn(dummyReturnFlights);
    	
    	Map<String, List<Flight>> results = flightService.getRoundTripFlights(flightSearchRequest);
    	
    	List<Flight> flightsOneWay = results.get("onewayflights");
    	
    	List<Flight> flightsRoundTrip = results.get("retflights");
  		
  		verify(mockFlightDao,times(1)).findFlights(anyString(),anyString(),anyString(),anyString(),anyInt());  		
        assertEquals(flightsOneWay.size(), 3);
        
        verify(mockFlightDao,times(1)).findFlights(anyString(),anyString(),anyString(),anyString(),anyInt());  		
        assertEquals(flightsRoundTrip.size(), 3);
        
    }

}
