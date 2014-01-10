package com.example.tests;


import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import com.example.utils.SortedListOf;



public class GroupCreationTests extends TestBase {

	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    //save state
	SortedListOf<GroupData> oldList = app.getgrouphelper().getGroups();
        
    //actions
	app.getgrouphelper().createGroup(group);
	    
    
    //save new state
    SortedListOf<GroupData> newList = app.getgrouphelper().getGroups();
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }
}
