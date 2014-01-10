package com.example.tests;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;;

public class ContactCreationTests extends TestBase {
  
	
	
  @Test(dataProvider = "randomValidContactGenerator")
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
