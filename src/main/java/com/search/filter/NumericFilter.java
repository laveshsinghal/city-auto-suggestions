package com.search.filter;

/**
 * A filter, filters the user input which is valid for suggestion count.
 * 
 * @author Lavesh Singhal
 *
 */
public class NumericFilter implements InputFilter {

	public NumericFilter() {

	}

	private static final String VALID_SUGGESTION_COUNT_FORMAT = "[0-9]+";

	@Override
	public boolean filter(String[] cityInput) {

		boolean validCount = false;
		if (1 == cityInput.length) {
			System.out.println("No suggestion count passed, will return all available suggestions...");
			return true;
		} else {
			validCount = (null != cityInput[1] && cityInput[1].matches(VALID_SUGGESTION_COUNT_FORMAT));
			if (!validCount) {
				System.out.println("Suggestion count is not valid or numeric...");
			} else if (validCount && Integer.valueOf(cityInput[1]) == 0) {
				System.out.println("No Suggestions asked...");
				validCount = false;
			}
		}
		return validCount;
	}

}
