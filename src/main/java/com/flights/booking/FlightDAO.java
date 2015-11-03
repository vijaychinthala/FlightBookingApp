package com.flights.booking;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 
import org.hibernate.criterion.Restrictions;

import com.flights.booking.domain.Flight;

public class FlightDAO {
	
	Configuration configuration = new Configuration().configure();
	SessionFactory sessionFactory=  configuration.buildSessionFactory();
	Session session = sessionFactory.openSession();

	@SuppressWarnings("unchecked")
	public List<Flight> findFlights(String from, String to, String travelClass, String date, int noOfPersons)  {
		List<Flight> flights = session.createCriteria(Flight.class)
				.add(Restrictions.eq("from", from))
				.add(Restrictions.eq("to", to))
				.add(Restrictions.eq("date", date))	 			
				.add(Restrictions.eq("travelClass", travelClass))
				.add(Restrictions.ge("noOfPassengers", noOfPersons)) 
                .list();
		return flights;
	}

}
