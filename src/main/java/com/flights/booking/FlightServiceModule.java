package com.flights.booking;

import com.google.inject.AbstractModule;

public class FlightServiceModule  extends AbstractModule {

	@Override
	protected void configure() {
		bind(FlightService.class).to(FlightServiceImpl.class);		
	}

}
