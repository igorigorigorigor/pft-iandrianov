package com.example.tests;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.fw.Commercial;

import com.thoughtworks.xstream.XStream;

public class CommercialDataGenerator {

	
	public static void main(String[] args) throws IOException  {
		if (args.length != 1) {
			System.out.println("Please, specify parameter: <commercial full file name>");
			return;
		}
		File file = new File(args[0]);
		Commercial comm = generateRandomCommercial();
		saveCommercialToXmlFile(comm, file);
		
	}
	
	private static void saveCommercialToXmlFile(Commercial comm, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("commercial", Commercial.class);
		String xml = xstream.toXML(comm);		
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		
	}
	
	public static List<Commercial> loadCommercialFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("ñommercial", Commercial.class);
		List<Commercial> list = new ArrayList<Commercial>();
		Commercial comm = (Commercial) xstream.fromXML(file);
		list.add(comm);
		return list;
	}
	
	public static Commercial generateRandomCommercial() {
		Commercial comm = new Commercial()
						.withCategoryOfAd(generateRandomString())
						.withTypeOfAd(generateRandomString())
						.withObjectType(generateRandomString())
						.withIsBusinessReady(generateRandomString())
						.withArea(generateRandomInteger())
						.withSubwayStation(generateRandomString())
						.withAddress(generateRandomString())
						.withAdName(generateRandomString())
						.withDescription(generateRandomString())
						.withPrice(generateRandomInteger());		
		return comm;
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
