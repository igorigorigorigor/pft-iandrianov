package com.example.tests;

import org.testng.annotations.Test;



public class ContactCreationTests extends TestBase {
  @Test	
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddNewContact();
    ContactData contact = new ContactData();
    contact.first_name = "Yuriy";
    contact.last_name = "Andrianov";
    contact.address = "Some street";
    contact.home = "242";
    contact.mobile = "2424243535";
    contact.work = "Some work";
    contact.email = "someemail@mail.com";
    contact.email2 = "someemail2@mail.com";
    contact.bday = "12";
    contact.bmonth = "February";
    contact.byear = "1990";
    contact.address2 = "asropskropskarpokf";
    contact.phone2 = "sarkpokrapsr";
    contact.group_name = "Rob";
    
	fillNewContactInfo(contact);
    submitContactCreation();
    returnToHomePage();
  }
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddNewContact();
    fillNewContactInfo(new ContactData("", "", "", "", "", "", "", "", "12", "February", "", "", "", "Rob"));
    submitContactCreation();
    returnToHomePage();
  }
  
}
