package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  
	
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	  app.getnavigationhelper().openMainPage();
	  app.getnavigationhelper().gotoHomePage();
	  
	  //save state
	  List<ContactData> oldList = app.getcontacthelper().getContacts();
	  
	  //actions
	  app.getcontacthelper().addNewContact();
	  app.getcontacthelper().fillContactData(contact);
	  app.getcontacthelper().submitContactCreation();
	  app.getnavigationhelper().gotoHomePage();
	  
	  //save new state
	  List<ContactData> newList = app.getcontacthelper().getContacts();
	  
	  //compare states
	  assertEquals(newList.size(), oldList.size() + 1);
	  
	  oldList.add(contact);
	  Collections.sort(oldList);
	  assertEquals(newList, oldList);
	  
  }
}
