package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void modifySomeGroup () {
		app.getnavigationhelper().openMainPage();
	    app.getnavigationhelper().gotoGroupsPage();
		app.getgrouphelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.groupname = "new name";
		app.getgrouphelper().fillGroupForm(group);
		app.getgrouphelper().submitGroupModification();
		app.getnavigationhelper().gotoGroupsPage();
	}
}
