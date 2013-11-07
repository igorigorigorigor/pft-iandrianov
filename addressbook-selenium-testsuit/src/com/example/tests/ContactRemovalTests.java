package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact () {
		app.getnavigationhelper().openMainPage();
		app.getcontacthelper().deleteContact(1);
	}
}
