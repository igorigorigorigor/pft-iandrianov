package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.fw.Site;
import com.thoughtworks.xstream.XStream;

public class SiteDataGenerator {

	public static void main(String[] args) throws IOException  {
		if (args.length != 1) {
			System.out.println("Please, specify parameter: <site full file name>");
			return;
		}
		File file = new File(args[0]);
		Site site = generateRandomSite();
		saveSiteToXmlFile(site, file);
	}
	
	
	private static void saveSiteToXmlFile(Site site, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("Site", Site.class);
		String xml = xstream.toXML(site);		
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	
	public static List<Site> loadSiteFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("Site", Site.class);
		List<Site> list = new ArrayList<Site>();
		Site site = (Site) xstream.fromXML(file);
		list.add(site);
		return list;
	}
	
	
	public static Site generateRandomSite() {
		Site site = new Site()
						.withCategoryOfAd(generateRandomString())
						.withTypeOfAd(generateRandomString())
						.withObjectType(generateRandomString())
						.withCityDistance(generateRandomInteger())
						.withSubwayStation(generateRandomString())
						.withAreaOfSite(generateRandomInteger())
						.withDescription(generateRandomString())
						.withPrice(generateRandomInteger())
						.withImagesFolder(generateRandomInteger());
		return site;
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
