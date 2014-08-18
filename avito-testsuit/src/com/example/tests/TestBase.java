  package com.example.tests;



import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.Apartment;
import com.example.fw.ApplicationManager;
import com.example.fw.Commercial;
import com.example.fw.House;
import com.example.fw.Site;


public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "firefox.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	  
	  
	@DataProvider
	public static List<Object[]> wrapApartmentForDataProvider(List<Apartment> flats) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (Apartment flat : flats) {
			list.add(new Object[]{flat});
		}
		return list;
	}
	
	@DataProvider
	public static List<Object[]> wrapCommercialForDataProvider(List<Commercial> comms) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (Commercial comm : comms) {
			list.add(new Object[]{comm});
		}
		return list;
	}
	
	@DataProvider
	public static List<Object[]> wrapHouseForDataProvider(List<House> houses) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (House house : houses) {
			list.add(new Object[]{house});
		}
		return list;
	}
	
	@DataProvider
	public static List<Object[]> wrapSiteForDataProvider(List<Site> sites) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (Site site : sites) {
			list.add(new Object[]{site});
		}
		return list;
	}
	}		

