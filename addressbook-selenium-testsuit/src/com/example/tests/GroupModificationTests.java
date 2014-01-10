package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) { 
	    //save state
	    SortedListOf<GroupData> oldList = app.getgrouphelper().getGroups();
	        
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getgrouphelper().modifyGroup(index, group);
				
		
		//save new state
	    SortedListOf<GroupData> newList = app.getgrouphelper().getGroups();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
