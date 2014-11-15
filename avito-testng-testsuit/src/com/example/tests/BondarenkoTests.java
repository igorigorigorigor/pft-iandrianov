package com.example.tests;

import static com.example.tests.CommercialDataGenerator.loadCommercialFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.Commercial;


public class BondarenkoTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> commercialFromFile() throws IOException {
		return wrapCommercialForDataProvider(loadCommercialFromXmlFile(new File("BondarenkoComm.xml"))).iterator();
	}
	
	@Test(dataProvider = "commercialFromFile")
	public void testApartmentCreationWithValidData(Commercial comm) throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.getcommercialhelper().createCommercial(comm);
		
	}
}
