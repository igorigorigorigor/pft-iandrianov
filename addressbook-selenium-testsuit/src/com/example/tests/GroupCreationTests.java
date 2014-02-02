package com.example.tests;


import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import java.io.*;

import com.example.utils.SortedListOf;



@SuppressWarnings("unused")
public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> groupsFromFile() throws IOException {
	  return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.txt"))).iterator();
  }
	 	
	
@Test(dataProvider = "groupsFromFile")
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
