package com.search.handlers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.BeforeClass;
import org.junit.Test;

import com.search.filter.InputFilterChain;


/**
 * Test class for CitySearchHandler
 * 
 * @author Lavesh Singhal
 *
 */
public class CitySearchHandlerTest {

	private static CitySearchHandler citySearchHandler;
	private static InputFilterChain filterChain;

	
	
	@BeforeClass
	public static void setUp(){
		
		citySearchHandler = new CitySearchHandler();	
		
	}
	
	@Test
	public void testHandleRequestWhereFiltersApplied(){
		
		String[] params = {"a" , "5"};	
		filterChain = mock(InputFilterChain.class);
		citySearchHandler.setFilterChain(filterChain);
		citySearchHandler.handleRequest(params);
		verify(filterChain, times(1)).filter(params);
	}
	
	@Test
	public void testHandleRequestWhenInputParametersAreNotValid(){
		
		String[] params = {"aa" , "aa"};	
		filterChain = mock(InputFilterChain.class);
		citySearchHandler.setFilterChain(filterChain);
		assertEquals(false, citySearchHandler.applyFilters(params));
		
	}
	
	@Test
	public void testHandleRequestWhenInputParametersAreValid(){
		
		String[] params = {"aa" , "5"};	
		citySearchHandler.configureInputFilters();
		assertEquals(true, citySearchHandler.applyFilters(params));
		
	}
	
}
