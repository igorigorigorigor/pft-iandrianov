  package com.example.tests;



import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.example.fw.Apartment;
import com.example.fw.ApplicationManager;
import com.example.fw.Commercial;
import com.example.fw.House;
import com.example.fw.Site;


public class TestBase {
	public String baseUrl;
	public boolean acceptNextAlert = true;
	public Apartment fFlat;
	protected ApplicationManager app;
	
	@Managed
    public WebDriver driver;
	
	@ManagedPages(defaultUrl = "https://avito.ru/")
	public Pages pages;
	
	
	@Before
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "chrome.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		baseUrl = properties.getProperty("baseUrl");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	  }
	
	@After
	public void tearDown() throws Exception {
		app.stop();
	}

	public static Collection<Object[]> wrapApartmentForDataProvider(List<Apartment> flats) {
		Collection<Object[]> list = new ArrayList<Object[]>();
		for (Apartment flat : flats) {
			list.add(new Object[]{flat});
		}
		return list;
	}
	
	public static Collection<Object[]> wrapCommercialForDataProvider(List<Commercial> comms) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (Commercial comm : comms) {
			list.add(new Object[]{comm});
		}
		return list;
	}
	
	public static Collection<Object[]> wrapHouseForDataProvider(List<House> houses) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (House house : houses) {
			list.add(new Object[]{house});
		}
		return list;
	}

	public static Collection<Object[]> wrapSiteForDataProvider(List<Site> sites) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (Site site : sites) {
			list.add(new Object[]{site});
		}
		return list;
	}
}		

