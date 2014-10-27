package com.example.tests;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.fw.Apartment;

import com.thoughtworks.xstream.XStream;

public class ApartmentDataGenerator {

	
	public static void main(String[] args) throws IOException  {
		if (args.length != 1) {
			System.out.println("Please, specify parameter: <apartment full file name>");
			return;
		}
		File file = new File(args[0]);
		Apartment flat = generateRandomApartment();
		saveApartmentToXmlFile(flat, file);
		
	}
	
	private static void saveApartmentToXmlFile(Apartment flat, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("Apartment", Apartment.class);
		String xml = xstream.toXML(flat);		
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		
	}
	
	
	public static List<Apartment> loadApartmentFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("Apartment", Apartment.class);
		List<Apartment> list = new ArrayList<Apartment>();
		Apartment flat = (Apartment) xstream.fromXML(file);
		list.add(flat);
		return list;
	}
	

	public static Apartment generateRandomApartment() {
		Apartment flat = new Apartment()
						.withAddress(generateRandomString())
						.withArea(generateRandomInteger())
						.withBuildingType(generateRandomString())
						.withCategoryOfAd(generateRandomString())
						.withDescription(generateRandomString())
						.withFloorNumber(generateRandomInteger())
						.withFloorsQuantity(generateRandomInteger())
						.withNumberOfRooms(generateRandomInteger())
						.withObjectType(generateRandomString())
						.withPrice(generateRandomInteger())
						.withSubwayStation(generateRandomString())
						.withTypeOfAd(generateRandomString());
		return flat;
	}
	
	public static String generateRandomString() {
		  Random rnd = new Random();
		  return "test" + rnd.nextInt();
		  
	}
	
	public static String generateRandomInteger() {
		  Random rnd = new Random();
		  Integer result;
		  result = rnd.nextInt();
		  return result.toString();
	}
}
