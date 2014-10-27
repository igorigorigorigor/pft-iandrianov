package com.example.tests;

import static com.example.tests.CommercialDataGenerator.loadCommercialFromXmlFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.example.fw.Commercial;

import java.io.*;
import java.util.Iterator;


public class BondarenkoCommercialCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> commercialFromFile() throws IOException {
		return wrapCommercialForDataProvider(loadCommercialFromXmlFile(new File("BondarenkoComm.xml"))).iterator();
	}
	
	@Test(dataProvider = "commercialFromFile")
	public void testCommercialCreationWithValidData(Commercial comm) throws Exception {
		
		//sign in
		app.getcommercialhelper().signin();
		
		//actions
		app.getcommercialhelper().createCommercial(comm);
		
	}

}
