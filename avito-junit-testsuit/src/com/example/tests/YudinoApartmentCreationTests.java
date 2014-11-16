package com.example.tests;

import static com.example.tests.ApartmentDataGenerator.loadApartmentFromXmlFile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.fw.Apartment;

import java.io.*;
import java.util.Collection;


@RunWith(Parameterized.class)
public class YudinoApartmentCreationTests extends TestBase {

	@Parameters
	public static Collection<Object[]> apartmentFromFile() throws IOException {
		return wrapApartmentForDataProvider(loadApartmentFromXmlFile(new File("YudinoApart.xml")));
	}
	
	private Apartment fFlat;
	
	public YudinoApartmentCreationTests(Apartment flat){
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

