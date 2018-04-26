package com.search.filter;

/**
 * A filter, filtering the user input with valid city initials or well formed
 * city initials.
 * 
 * @author Lavesh Singhal
 *
 */
public class ValidCityNameFilter implements InputFilter {

	private static final String VALID_CITY_FORMAT = "[a-zA-Z]+";

	public ValidCityNameFilter() {

	}

	@Override
	public boolean filter(String[] cityInput) {

		boolean validCityInitials = false;
		validCityInitials = (null != cityInput[0] && cityInput[0].matches(VALID_CITY_FORMAT));
		if (!validCityInitials) {
			System.out.println("City Initials are invalid... ");
		}
		return validCityInitials;
	}

}
