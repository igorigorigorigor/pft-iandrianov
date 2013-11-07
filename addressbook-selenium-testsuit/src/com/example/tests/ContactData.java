package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address1;
	public String home1;
	public String mobile;
	public String work;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String group;
	public String address2;
	public String home2;

	public ContactData(String firstname, String lastname, String address1,
			String home1, String mobile, String work, String email1,
			String email2, String bday, String bmonth, String byear,
			String group, String address2, String home2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.home1 = home1;
		this.mobile = mobile;
		this.work = work;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.group = group;
		this.address2 = address2;
		this.home2 = home2;
	}
	
	public ContactData() {
		
	}
}