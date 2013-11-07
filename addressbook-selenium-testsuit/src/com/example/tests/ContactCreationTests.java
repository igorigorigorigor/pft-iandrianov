package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	  app.getnavigationhelper().openMainPage();
	  app.getcontacthelper().addNewContact();
	  ContactData contact = new ContactData("Sonya", "Blade", "Bloodspot sq.", "14", "+79098881111", "Fujitsu Finland", "cagejohnny@hotmail.com", "cagejohnny@gmail.com", "1", "January", "1980", "Rob", "Crimespot sq.", "15");
	  app.getcontacthelper().fillContactData(contact);
	  app.getcontacthelper().submitContactCreation();
	  app.getnavigationhelper().gotoHomePage();  
  }
}
