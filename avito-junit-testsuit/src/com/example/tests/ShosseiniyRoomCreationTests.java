package com.example.tests;

import static com.example.tests.ApartmentDataGenerator.loadApartmentFromXmlFile;







import com.example.fw.Apartment;

import java.io.*;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ShosseiniyRoomCreationTests extends TestBase {

	@Parameters
	public static Collection<Object[]> apartmentFromFile() throws IOException {
		return wrapApartmentForDataProvider(loadApartmentFromXmlFile(new File("ShosseiniyRoom.xml")));
	}
	
	private Apartment fFlat;
	
	public ShosseiniyRoomCreationTests(Apartment flat){
		fFlat = flat;
	}
	
	@Test
	public void testApartmentCreationWithValidData() throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.getapartmenthelper().createRoom(fFlat);
		
	}
}

