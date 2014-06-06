package com.example.tests;

import static com.example.tests.HouseDataGenerator.loadHouseFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.House;

public class HouseCreationTests extends TestBase {
	
	
	@DataProvider
	public Iterator<Object[]> houseFromFile() throws IOException {
		return wrapHouseForDataProvider(loadHouseFromXmlFile(new File("CheboksarskayHouse.xml"))).iterator();
	}
	
	@Test(dataProvider = "houseFromFile")
	public void testApartmentCreationWithValidData(House house) throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.gethousehelper().createVasilievo(house);
		
	}
}
