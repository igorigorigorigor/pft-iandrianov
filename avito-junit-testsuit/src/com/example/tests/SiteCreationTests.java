package com.example.tests;

import static com.example.tests.SiteDataGenerator.loadSiteFromXmlFile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.fw.Site;

import java.io.*;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SiteCreationTests extends TestBase {
	
	@Parameters
	public static Collection<Object[]> siteFromFile() throws IOException {
		return wrapSiteForDataProvider(loadSiteFromXmlFile(new File("CheboksarskaySite.xml")));
	}
	
	private Site fSite;
	
	public SiteCreationTests(Site site){
		fSite = site;
	}
	
	@Test
	public void testSiteCreationWithValidData() throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.getsitehelper().createSite(fSite);
		
	}
}
