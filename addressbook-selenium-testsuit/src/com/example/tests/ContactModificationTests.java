package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup () {
		app.getnavigationhelper().openMainPage();
		app.getcontacthelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.firstname = "Sub";
		contact.lastname = "Zero";
		app.getcontacthelper().fillContactData(contact);
		app.getcontacthelper().submitContactModification();
		app.getnavigationhelper().gotoGroupsPage();
	}
}
