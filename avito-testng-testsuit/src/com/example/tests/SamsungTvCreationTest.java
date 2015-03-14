package com.example.tests;

import static com.example.tests.ApartmentDataGenerator.loadApartmentFromXmlFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.Apartment;

import java.io.*;
import java.util.Iterator;


public class SamsungTvCreationTest extends TestBase {

	@DataProvider
	public Iterator<Object[]> apartmentFromFile() throws IOException {
		return wrapApartmentForDataProvider(loadApartmentFromXmlFile(new File("SamsungTv.xml"))).iterator();
	}
	
	@Test(dataProvider = "apartmentFromFile")
	public void testApartmentCreationWithValidData(Apartment tv) throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.getapartmenthelper().editTv(tv);
		
	}
}
