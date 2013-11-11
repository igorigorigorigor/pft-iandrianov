package com.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;



public class GroupCreationTests extends TestBase {
  
  
	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    app.getnavigationhelper().openMainPage();
    app.getnavigationhelper().gotoGroupsPage();
    
    //save state
    List<GroupData> oldList = app.getgrouphelper().getGroups();
        
    //actions
    app.getgrouphelper().initNewGroupCreation();
	app.getgrouphelper().fillGroupForm(group);   
    app.getgrouphelper().submitGroupCreation();
    app.getnavigationhelper().gotoGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getgrouphelper().getGroups();
    
    //compare states
    AssertJUnit.assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(group);
    Collections.sort(oldList);
    AssertJUnit.assertEquals(newList, oldList);
  }
}
