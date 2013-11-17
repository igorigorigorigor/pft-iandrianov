package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeGroup (ContactData contact) {
		app.getnavigationhelper().openMainPage();
		
		//save state
		List<ContactData> oldList = app.getcontacthelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		
		//actions
		app.getcontacthelper().initContactModification(index);
		app.getcontacthelper().fillEditedContactData(contact);
		app.getcontacthelper().submitContactModification();
		app.getnavigationhelper().gotoHomePage();
		
		//save new state
		List<ContactData> newList = app.getcontacthelper().getContacts();
				  
		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
