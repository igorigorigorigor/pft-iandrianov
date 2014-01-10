package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if(cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
	}
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData temp = new ContactData();
			String title = checkbox.getAttribute("title");
			title = title.substring("Select (".length(), title.length() - ")".length()); 
			temp.withFirstname(title.substring(0, title.indexOf(" ")));
			temp.withLastname(title.substring(title.indexOf(" ") + 1, title.length()));
			cachedContacts.add(temp);
		}
		manager.navigateTo().mainPage();
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		addNewContact();
  		fillContactData(contact, CREATION);
  		submitContactCreation();
  		manager.navigateTo().mainPage();
  		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		selectContactByIndex(index);
		submitContactDeletion();
		manager.navigateTo().mainPage();
		rebuildCache();
		return this;
	}

	
	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		initContactModification(index);
		fillEditedContactData(contact);
		submitContactModification();
		manager.navigateTo().mainPage();
		rebuildCache();
		return this;
	}
	
	//------------------------------------------------------------------------------------------------------------
	
	private ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@name='update' and @value='Delete']"));
		cachedContacts = null;
		return this;
	}
		
	public ContactHelper addNewContact() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper fillContactData(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress1());
		type(By.name("home"), contact.getHome1());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());
		/*if (formType == CREATION) {
			selectByText(By.name("new_group"),);	
		} else {
			if (driver.findElement(By.name("new_group")) != null){
				throw new Error("Group Selector exists in contact modification form");
			}
		}*/
		selectByText(By.name("new_group"), contact.getGroup());
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getHome2());
		return this;
	}
	
	public ContactHelper fillEditedContactData(ContactData contact) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress1());
		type(By.name("home"), contact.getHome1());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());
		//selectByText(By.name("new_group"), contact.getGroup());
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getHome2());
		return this;
	}


	private ContactHelper selectContactByIndex(int index) {
		index = index + 1;
		click(By.xpath("//table[@id='maintable']//tr["+ (index+1) + "]//img[@title='Edit']"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@name='update' and @value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper returnToHomePage(){
		click(By.linkText("home"));
		return this;
	}

	
		
}
