package com.search.filter;

/**
 * A filter to verify if there is no user input. return false if no parameters
 * passed.
 * 
 * @author Lavesh Singhal
 *
 */
public class InputParameterFilter implements InputFilter {

	@Override
	public boolean filter(String[] inputString) {

		boolean validInputParameterCount = false;

		if (inputString.length >= 1) {
			validInputParameterCount = true;
		} else {
			System.out.println("Input parameters required : 2 while entered : " + inputString.length);
		}

		return validInputParameterCount;
	}

}
