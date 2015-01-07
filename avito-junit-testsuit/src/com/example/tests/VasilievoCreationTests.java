package com.example.tests;

import static com.example.tests.ApartmentDataGenerator.loadApartmentFromXmlFile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.fw.Apartment;
import com.example.pages.ApartmentPage;


@RunWith(ThucydidesParameterizedRunner.class)
public class VasilievoCreationTests extends TestBase {

	@TestData  
	public static Collection<Object[]> apartmentFromFile() throws IOException {
		return wrapApartmentForDataProvider(loadApartmentFromXmlFile(new File("VasilievoApart.xml")));
	}
	
	@Steps
	public ApartmentPage apartmentPage = new ApartmentPage(driver);
	
	public VasilievoCreationTests(Apartment flat){
		fFlat = flat;
	}
		
	@Test
	public void testApartmentCreationWithValidData() throws Exception {
		
		//sign in
		app.getapartmenthelper().signin();
		
		//actions
		apartmentPage.createNewAd();

		apartmentPage.selectVasilievoLocation(fFlat);
		
		apartmentPage.fillApartmentData(fFlat);
		
		app.getapartmenthelper().uploadImages(fFlat);
		
	}
}

