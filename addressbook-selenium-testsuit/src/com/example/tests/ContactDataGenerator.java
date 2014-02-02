package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;


public class ContactDataGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please, specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		}
		else if ("xml".equals(format)){
			saveContactsToXmlFile(contacts, file);
		}
		else {
			System.out.println("Unknown format" + format);
			return;
		}

	}
	
	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);		
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>)xstream.fromXML(file);
	}
	
	
	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts){
			writer.write(contact.getFirstname() +  "," + contact.getLastname() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");  
			ContactData contact = new ContactData()
			.withFirstname(part[0])
			.withLastname(part[1]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
						
		bufferedReader.close();
		return list;
	}
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData("Kung", "Lao", "Bloodspot sq.", "14", "+79098881111", "Fujitsu Finland", "sonyablade@hotmail.com", "cagejohnny@gmail.com", "1", "January", "1980", "[none]", "Crimespot sq.", "15")
			  .withFirstname(generateRandomString())
			  .withLastname(generateRandomString());
			list.add(contact);
		}
		return list;
	}
	
	

}
