package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void addNewContact() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactData(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address1);
		type(By.name("home"), contact.home1);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);
		selectByText(By.name("new_group"), contact.group);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.home2);
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("//input[@name='update' and @value='Delete']"));
	}

	private void selectContactByIndex(int index) {
		index = index + 1;
		click(By.xpath("//table[@id='maintable']//tr["+ index + "]//img[@title='Edit']"));
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
	}

	public void submitContactModification() {
		click(By.xpath("//input[@name='update' and @value='Update']"));
	}
}
