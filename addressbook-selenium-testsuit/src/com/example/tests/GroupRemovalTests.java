package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup () {
	    //save state
	    SortedListOf<GroupData> oldList = app.getgrouphelper().getGroups();
	        
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getgrouphelper().deleteGroup(index);
		
		//save new state
	    SortedListOf<GroupData> newList = app.getgrouphelper().getGroups();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	}
}
