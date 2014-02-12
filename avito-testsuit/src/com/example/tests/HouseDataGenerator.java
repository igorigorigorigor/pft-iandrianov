package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.example.fw.House;
import com.thoughtworks.xstream.XStream;

public class HouseDataGenerator {

	public static void main(String[] args) throws IOException  {
		if (args.length != 1) {
			System.out.println("Please, specify parameter: <house full file name>");
			return;
		}
		File file = new File(args[0]);
		House house = generateRandomHouse();
		saveHouseToXmlFile(house, file);
	}
	
	
	private static void saveHouseToXmlFile(House house, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("House", House.class);
		String xml = xstream.toXML(house);		
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	
	public static List<House> loadHouseFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("House", House.class);
		List<House> list = new ArrayList<House>();
		House house = (House) xstream.fromXML(file);
		list.add(house);
		return list;
	}
	
	
	public static House generateRandomHouse() {
		House house = new House()
						.withCategoryOfAd(generateRandomString())
						.withTypeOfAd(generateRandomString())
						.withObjectType(generateRandomString())
						.withFloorsQuantity(generateRandomInteger())
						.withWallsMaterial(generateRandomString())
						.withCityDistance(generateRandomInteger())
						.withSubwayStation(generateRandomString())
						.withAreaOfHouse(generateRandomInteger())
						.withAreaOfSite(generateRandomInteger())
						.withDescription(generateRandomString())
						.withPrice(generateRandomInteger());
		return house;
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
