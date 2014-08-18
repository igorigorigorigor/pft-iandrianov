package com.example.tests;

import static com.example.tests.ApartmentDataGenerator.loadApartmentFromXmlFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.Apartment;

import java.io.*;
import java.util.Iterator;


public class ShosseiniyRoomCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> apartmentFromFile() throws IOException {
		return wrapApartmentForDataProvider(loadApartmentFromXmlFile(new File("ShosseiniyRoom.xml"))).iterator();
	}
	
	@Test(dataProvider = "apartmentFromFile")
	public void testApartmentCreationWithValidData(Apartment flat) throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.getapartmenthelper().createRoom(flat);
		
	}
}

