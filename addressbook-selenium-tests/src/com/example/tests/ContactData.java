package com.example.tests;

public class ContactData {
	public String first_name;
	public String last_name;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String address2;
	public String phone2;
	public String group_name;

	public ContactData() {
	}
	
	public ContactData(String first_name, String last_name, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String address2, String phone2, String group_name) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address2 = address2;
		this.phone2 = phone2;
		this.group_name = group_name;
	}
}