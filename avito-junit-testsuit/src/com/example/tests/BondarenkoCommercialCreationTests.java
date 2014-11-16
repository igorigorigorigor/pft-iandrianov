package com.example.tests;

import static com.example.tests.CommercialDataGenerator.loadCommercialFromXmlFile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.fw.Commercial;

import java.io.*;
import java.util.Collection;


@RunWith(Parameterized.class)
public class BondarenkoCommercialCreationTests extends TestBase {

	@Parameters
	public static Collection<Object[]> commercialFromFile() throws IOException {
		return wrapCommercialForDataProvider(loadCommercialFromXmlFile(new File("BondarenkoComm.xml")));
	}
	
	private Commercial fFlat;
	
	public BondarenkoCommercialCreationTests(Commercial flat){
		fFlat = flat;
	}
	
	@Test
	public void testCommercialCreationWithValidData() throws Exception {
		
		//sign in
		app.getcommercialhelper().signin();
		
		//actions
		app.getcommercialhelper().createCommercial(fFlat);
		
	}

}
