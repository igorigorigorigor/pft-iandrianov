package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cachedGroups;
	
	
	public SortedListOf<GroupData> getGroups() {
		if(cachedGroups == null){
			rebuildCache();
		}
		return cachedGroups;		
	}
	
	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length()); 
			cachedGroups.add(new GroupData().withGroupname(name));
		}
		manager.navigateTo().groupsPage();
	}

	public GroupHelper createGroup(GroupData group) {
    	manager.navigateTo().groupsPage();
		initNewGroupCreation();
    	fillGroupForm(group);
    	submitGroupCreation();
    	manager.navigateTo().groupsPage();
    	rebuildCache();
    	return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
    	manager.navigateTo().groupsPage();
    	rebuildCache();
		return this;
	}

		
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		manager.navigateTo().groupsPage();
		rebuildCache();
		return this;
	}
	
	// -----------------------------------------------------------------------------------------------
	
	private GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
		return this;
	}
	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper initNewGroupCreation() {
		click(By.name("new"));
		return this;
	}
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("groups"));
		return this;
	}

	
	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}

		

}
