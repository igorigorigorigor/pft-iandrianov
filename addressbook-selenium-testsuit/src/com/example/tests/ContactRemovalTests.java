package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact () {
		app.getnavigationhelper().openMainPage();
		//save state
		List<ContactData> oldList = app.getcontacthelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		
		//actions
		app.getcontacthelper().deleteContact(index);
		app.getnavigationhelper().gotoHomePage();
		
		//save new state
		List<ContactData> newList = app.getcontacthelper().getContacts();
		  
		//compare states
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
