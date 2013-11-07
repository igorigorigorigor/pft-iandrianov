package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getnavigationhelper().openMainPage();
    app.getnavigationhelper().gotoGroupsPage();
    app.getgrouphelper().initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupname = "group1";
    group.header = "header";
    group.footer = "footer";
	app.getgrouphelper().fillGroupForm(group);   
    app.getgrouphelper().submitGroupCreation();
    app.getnavigationhelper().gotoGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getnavigationhelper().openMainPage();
    app.getnavigationhelper().gotoGroupsPage();
    app.getgrouphelper().initNewGroupCreation();
    GroupData group = new GroupData("", "", "");
	app.getgrouphelper().fillGroupForm(group);   
    app.getgrouphelper().submitGroupCreation();
    app.getnavigationhelper().gotoGroupsPage();
  }
}
