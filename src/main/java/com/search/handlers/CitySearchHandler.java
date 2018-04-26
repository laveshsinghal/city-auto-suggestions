package com.search.handlers;

import java.util.List;

import com.search.exception.NoSuchCustomFilterException;
import com.search.filter.InputFilterChain;
import com.search.suggestor.CitySuggesterImpl;
import com.search.suggestor.CitySuggestor;
import com.search.util.CityDataLoaderUtil;

/**
 * This class configures the initial requirement which includes filter
 * configuration set up and loading city reference data used for look up.
 * 
 * @author lavesh Singhal
 *
 */
public class CitySearchHandler {

	InputFilterChain filterChain = null;

	CitySuggestor citySuggestor = null;

	/**
	 * configure the initial set up for the city search handler.
	 */
	public CitySearchHandler() {

		this.configureHandler();
	}

	private void configureHandler() {

		this.configureCityData();
		this.configureInputFilters();

	}

	void configureCityData() {

		CityDataLoaderUtil.loadCityData();
		System.out.println("City Data Loaded successfully...");
	}

	/**
	 * Configure the input filters in filter chain.
	 * 
	 */
	void configureInputFilters() {

		filterChain = new InputFilterChain();
		try {
			filterChain.loadAvailableFilters();
		} catch (NoSuchCustomFilterException e) {
			System.out.println("Error occured in configuring the filters...");
			e.printStackTrace();
		}
	}

	public boolean applyFilters(String[] searchParams) {
		return filterChain.filter(searchParams);
	}

	/**
	 * Get suggestions count from input parameters or set Integer.MAX value if
	 * not available
	 * 
	 * @param searchParams
	 * @return int suggestion count
	 */
	private int getSuggestionCount(String[] searchParams) {

		int suggestionCount = 0;
		if (searchParams.length >= 2) {
			suggestionCount = Integer.valueOf(searchParams[1]);
		} else {
			suggestionCount = Integer.MAX_VALUE;
		}

		return suggestionCount;
	}

	/**
	 * Handle all the requests coming from the main application.
	 * 
	 * @param String[]
	 *            searchParams input parameters
	 */
	public void handleRequest(String[] searchParams) {

		if (this.applyFilters(searchParams)) {
			handleRequestInternal(searchParams);
		} else {
			System.out.println("Input parameters did not filter...No Suggestion could be displayed");
		}
	}

	private void handleRequestInternal(String[] searchParams) {

		List<String> suggestedCitynames = null;
		suggestedCitynames = this.getCitySuggestor().retrieveCitySuggestions(searchParams[0],
				this.getSuggestionCount(searchParams));
		if (null != suggestedCitynames && suggestedCitynames.size() > 0) {
			System.out.println(suggestedCitynames.size() + " city suggestions found...");
			for (String suggestedCity : suggestedCitynames) {
				System.out.println(suggestedCity);
			}
		} else {
			System.out.println("Sorry..No Suggestions available for the initals passed");
		}

	}

	public void setFilterChain(InputFilterChain inputFilterChain) {
		this.filterChain = inputFilterChain;
	}

	/**
	 * Gets CitySuggester instance.
	 * 
	 * @return CitySuggestor
	 */
	private CitySuggestor getCitySuggestor() {

		if (null == citySuggestor) {
			citySuggestor = new CitySuggesterImpl(CityDataLoaderUtil.getRootNode());
		}
		return this.citySuggestor;
	}

}
