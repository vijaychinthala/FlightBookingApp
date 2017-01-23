package com.flights.booking;

import java.util.List;

import com.google.inject.TypeLiteral;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypeLiteral<?> stringListType = new TypeLiteral<List<String>>() {};
		
		System.out.println(stringListType.getType());
		System.out.println(stringListType.getRawType());
		System.out.println(stringListType.toString());
		System.out.println(stringListType.getClass());
		 
		
	}

}
