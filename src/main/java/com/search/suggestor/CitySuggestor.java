package com.search.suggestor;

import java.util.List;

/**
 * This interface deals for the inputs as city initials and suggestion count and
 * returns a list of all possible suggestions matching for the input initials.
 * if the suggestion count is less than available suggestions then only asked no
 * of suggestion would be returned and if the suggestion count is very large
 * number then all available suggestions would be returned.
 * 
 * @author Lavesh Singhal
 *
 */
public interface CitySuggestor {

	/**
	 * All the possible matching city suggestions are returned. The traversing
	 * set is considered from the node where the last character of input
	 * initials ends.
	 * 
	 * @param String
	 *            cityInitials
	 * @param int
	 *            suggestionCount no of suggestions asked
	 * @return List<String> List of suggestions
	 */
	public List<String> retrieveCitySuggestions(String cityInitials, int suggestionCount);

}
