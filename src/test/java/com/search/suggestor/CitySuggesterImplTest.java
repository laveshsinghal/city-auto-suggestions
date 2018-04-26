package com.search.suggestor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.search.data.structure.PrefixTree;
import com.search.data.structure.PrefixTrieNode;
import com.search.util.CityDataLoaderUtil;

/**
 * Test class for CitySuggestImpl
 * 
 * @author Lavesh Singhal
 *
 */
public class CitySuggesterImplTest {

	private static PrefixTrieNode tree;
	private static CitySuggesterImpl citySuggesterImpl;
	
	@BeforeClass
	public static void setUp(){
		
		CityDataLoaderUtil.loadCityData();
		tree=CityDataLoaderUtil.getRootNode();
		citySuggesterImpl=new CitySuggesterImpl();
		
		
	}
	
	@Test
	public void testRetrieveCitySuggestionsWhenRootIsNull(){
		
		citySuggesterImpl.setRoot(null);
		assertEquals(null,citySuggesterImpl.retrieveCitySuggestions("aa",5));
		assertNull(citySuggesterImpl.retrieveCitySuggestions("aa",5));
	}
	
	@Test
	public void testRetrieveCitySuggestionsWhenRootIsNotNull(){
		
		citySuggesterImpl.setRoot(tree);
		assertNotNull(citySuggesterImpl.retrieveCitySuggestions("a",5));
		assertEquals(5,citySuggesterImpl.retrieveCitySuggestions("a",5).size());
	}
	
	@Test
	public void testRetrieveCitySuggestionsWhenRootIsNotNullAndSuggestionCountIsVeryLarge(){
		
		citySuggesterImpl.setRoot(tree);
		assertEquals(11,citySuggesterImpl.retrieveCitySuggestions("a",10000).size());
	}
	
	@Test
	public void testRetrieveCitySuggestionsWhenRootNodeOnlyTree(){
		
		citySuggesterImpl.setRoot(this.getRootNodeOnlyTree());
		assertEquals(null,citySuggesterImpl.retrieveCitySuggestions("ak",1));
		assertNull(citySuggesterImpl.retrieveCitySuggestions("ak",1));
	}
	
	private PrefixTrieNode getRootNodeOnlyTree(){
		
		PrefixTree pTree=new PrefixTree();
		return pTree.getRoot();
	}
}
