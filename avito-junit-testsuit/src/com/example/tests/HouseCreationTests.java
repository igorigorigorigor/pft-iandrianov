package com.example.tests;

import static com.example.tests.HouseDataGenerator.loadHouseFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.fw.House;

@RunWith(Parameterized.class)
public class HouseCreationTests extends TestBase {
		
	@Parameters
	public static Collection<Object[]> houseFromFile() throws IOException {
		return wrapHouseForDataProvider(loadHouseFromXmlFile(new File("CheboksarskayHouse.xml")));
	}
	
	private House fHouse;
	
	public HouseCreationTests(House house){
		fHouse = house;
	}
	
	@Test
	public void testApartmentCreationWithValidData() throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.gethousehelper().createHouse(fHouse);
		
	}
}
