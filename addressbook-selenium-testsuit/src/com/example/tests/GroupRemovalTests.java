package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup () {
		app.getnavigationhelper().openMainPage();
	    app.getnavigationhelper().gotoGroupsPage();
		app.getgrouphelper().deleteGroup(1);
		app.getnavigationhelper().gotoGroupsPage();
	}
}
