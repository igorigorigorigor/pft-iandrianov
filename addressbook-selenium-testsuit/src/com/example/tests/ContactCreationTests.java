package com.example.tests;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.*;

import com.example.utils.SortedListOf;


@SuppressWarnings("unused")
public class ContactCreationTests extends TestBase {
  
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.txt"))).iterator();
	}
	
	 

	@Test(dataProvider = "contactsFromFile")
	  public void testContactCreationWithValidData(ContactData contact) throws Exception {
		  //save state
		  SortedListOf<ContactData> oldList = app.getcontacthelper().getContacts();
		  
		  //actions
		  app.getcontacthelper().createContact(contact);
		  		
		  
		  //save new state
		  SortedListOf<ContactData> newList = app.getcontacthelper().getContacts();
		  
		  //compare states
		  assertThat(newList, equalTo(oldList.withAdded(contact)));	  
	  }
}
