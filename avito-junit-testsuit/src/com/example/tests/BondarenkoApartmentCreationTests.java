package com.example.tests;

import static com.example.tests.ApartmentDataGenerator.loadApartmentFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.fw.Apartment;

@RunWith(Parameterized.class)
public class BondarenkoApartmentCreationTests extends TestBase {

	@Parameters
	public static Collection<Object[]> apartmentFromFile() throws IOException {
		return wrapApartmentForDataProvider(loadApartmentFromXmlFile(new File("BondarenkoApart.xml")));
	}
	
	private Apartment fFlat;
	
	public BondarenkoApartmentCreationTests(Apartment flat){
		fFlat = flat;
	}
	
	@Test
	public void testApartmentCreationWithValidData() throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		app.getapartmenthelper().createApartment(fFlat);
		
	}
}

