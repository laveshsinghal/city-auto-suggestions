package com.search.filter;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.search.exception.NoSuchCustomFilterException;
import com.search.util.ApplicationProperties;

/**
 * A filter chain to execute all the available filters. returns true if input
 * parameters passed the filtration successfully or false if failed at any
 * filter stage.
 * 
 * @author Lavesh Singhal
 *
 */
public class InputFilterChain {

	List<InputFilter> filters;

	public InputFilterChain() {

		filters = new ArrayList<>();
	}

	/**
	 * Loads all the available filters from the config using
	 * Application.properties, instantiate them and add them in a list.
	 * 
	 * @throws NoSuchCustomFilterException
	 *             if unable to load a filter
	 */
	public void loadAvailableFilters() throws NoSuchCustomFilterException {

		try {
			String filterList = ApplicationProperties.getProperty("filter");
			String[] filternames = filterList.split(",");
			Class<?> c;
			for (String filter : filternames) {
				c = Class.forName("com.search.filter." + filter);
				Constructor<?> cons = c.getConstructor();
				Object inFilter = cons.newInstance();
				filters.add((InputFilter) inFilter);
			}
		} catch (ClassNotFoundException | IllegalArgumentException | InstantiationException | IOException
				| NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			throw new NoSuchCustomFilterException("Exception occured while Loading the input filter", e);
		}

	}

	/*
	 * filter the user/city input from a list of available filters. return true
	 * if passed or false if failed in any filter.
	 */
	public boolean filter(String[] cityInput) {

		boolean isFilterable = false;

		for (InputFilter inputFilter : filters) {

			isFilterable = inputFilter.filter(cityInput);
			if (!isFilterable) {
				return isFilterable;
			} else {
				continue;
			}
		}

		return isFilterable;
	}

}
