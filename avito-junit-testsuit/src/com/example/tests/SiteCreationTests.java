package com.example.tests;

import static com.example.tests.SiteDataGenerator.loadSiteFromXmlFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.example.fw.Site;

import java.io.*;
import java.util.Iterator;

public class SiteCreationTests extends TestBase {
	
	
	@DataProvider
	public Iterator<Object[]> siteFromFile() throws IOException {
		return wrapSiteForDataProvider(loadSiteFromXmlFile(new File("CheboksarskaySite.xml"))).iterator();
	}
	
	@Test(dataProvider = "siteFromFile")
	public void testSiteCreationWithValidData(Site site) throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.getsitehelper().createSite(site);
		
	}
}
