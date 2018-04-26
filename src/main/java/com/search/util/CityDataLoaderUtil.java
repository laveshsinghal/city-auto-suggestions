package com.search.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.search.data.structure.PrefixTree;
import com.search.data.structure.PrefixTrieNode;

/**
 * Utility class which loads the data from cities.txt resource as reference data
 * and transfer the records to Prefix Tree to create Trie data structure.
 * 
 * 
 * @author Lavesh Singhal
 *
 */
public class CityDataLoaderUtil {

	private static PrefixTree tree = null;
	private static final String CITY_DATA_FILE = "citydatafile";

	/**
	 * Loads the records in Prefix Tree.
	 */
	public static void loadCityData() {

		List<String> cityRecords = readCityRecordsFromFileStream();
		List<String> citiesNotAdded = new ArrayList<>();
		boolean cityAdded = false;
		tree = new PrefixTree();
		for (String record : cityRecords) {
			cityAdded = tree.addData(record);
			if (!cityAdded) {
				citiesNotAdded.add(record);
			}
		}
		if (citiesNotAdded.size() > 0) {
			System.out.println("Below Incorrect city names not added..");
			for (String city : citiesNotAdded) {
				System.out.println(city);
			}
		}

	}

	/**
	 * Reads record from FIle system.
	 * 
	 * @return
	 */
	private static List<String> readCityRecordsFromFileStream() {

		String city = null;
		InputStream inputStream = null;
		List<String> cityRecords = new ArrayList<>();

		try {
			inputStream = CityDataLoaderUtil.class.getClassLoader()
					.getResourceAsStream(ApplicationProperties.getProperty(CITY_DATA_FILE));
			InputStreamReader isr = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
			while ((city = br.readLine()) != null) {
				cityRecords.add(city);
			}
		} catch (IOException e) {
			System.out.println("Error loading the city data...skipping the record..");
		}

		return cityRecords;
	}

	public static PrefixTrieNode getRootNode() {

		return tree.getRoot();
	}

}
