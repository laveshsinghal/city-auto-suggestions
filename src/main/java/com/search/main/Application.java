package com.search.main;

import com.search.handlers.CitySearchHandler;

/**
 * This is the entry point for the application. The application takes input
 * parameters where first parameter is the city initial while the second
 * parameter is the suggestions required. If 2nd parameter is not passed i.e.
 * [suggestion count] then all possible suggestions for the city initials will
 * be returned. The application uses cities.txt to search the city suggestions
 * located in resources folder for the asked input parameters which could be
 * updated whenever required.
 * 
 * @author lavesh Singhal
 *
 */
public class Application {

	public static void main(String[] args) {
		CitySearchHandler citySearchHandler = new CitySearchHandler();
		citySearchHandler.handleRequest(args);

	}

}
