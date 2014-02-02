package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address1;
	private String home1;
	private String mobile;
	private String work;
	private String email1;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String group;
	private String address2;
	private String home2;

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

	

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + " lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		//result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int f = this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		int t = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		return t+f;
	}
	
	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public ContactData withAddress1(String address1){
		this.address1 = address1;
		return this;
	}
	public ContactData withHome1(String home1){
		this.home1 = home1;
		return this;
	}
	public ContactData withMobile1(String mobile){
		this.mobile = mobile;
		return this;
	}
	public ContactData withWork(String work){
		this.work = work;
		return this;
	}
	public ContactData withEmail1(String email1){
		this.email1 = email1;
		return this;
	}
	public ContactData withEmail2(String email2){
		this.email2 = email2;
		return this;
	}
	public ContactData withBday(String bday){
		this.bday = bday;
		return this;
	}
	public ContactData withBmonth(String bmonth){
		this.bmonth = bmonth;
		return this;
	}
	public ContactData withByear(String byear){
		this.byear = byear;
		return this;
	}
	public ContactData withGroup(String group){
		this.group = group;
		return this;
	}
	public ContactData withAddress2(String address2){
		this.address2 = address2;
		return this;
	}
	public ContactData withHome2(String home2){
		this.home2 = home2;
		return this;
	}
	
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	public String getAddress1(){
		return address1;
	}
	public String getHome1(){
		return home1;
	}
	public String getMobile(){
		return mobile;
	}
	public String getWork(){
		return work;
	}
	public String getEmail1(){
		return email1;
	}
	public String getEmail2(){
		return email2;
	}
	public String getBday(){
		return bday;
	}
	public String getBmonth(){
		return bmonth;
	}
	public String getByear(){
		return byear;
	}
	public String getGroup(){
		return group;
	}
	public String getAddress2(){
		return address2;
	}
	public String getHome2(){
		return home2;
	}
}