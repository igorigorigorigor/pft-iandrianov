package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		app.getnavigationhelper().openMainPage();
	    app.getnavigationhelper().gotoGroupsPage();
	  
	    //save state
	    List<GroupData> oldList = app.getgrouphelper().getGroups();
	        
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getgrouphelper().initGroupModification(index);
		app.getgrouphelper().fillGroupForm(group);
		app.getgrouphelper().submitGroupModification();
		app.getnavigationhelper().gotoGroupsPage();
		
		//save new state
	    List<GroupData> newList = app.getgrouphelper().getGroups();
	    
	    //compare states
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
