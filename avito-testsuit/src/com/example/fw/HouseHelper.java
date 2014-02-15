package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.By;

public class HouseHelper extends HelperBase  {
	
	@SuppressWarnings("unused")
	private Properties properties;

	public HouseHelper(ApplicationManager manager, Properties properties) {
		super(manager);
		this.properties = properties;
	}

	public HouseHelper createHouse(House house) {
		fillApartmentData(house);
  		return this;
	}

	private void fillApartmentData(House house) {
		click(By.linkText("Подать объявление"));
		
		selectByText(By.id("fld_category_id"), house.getCategoryOfAd());
		selectByText(By.id("flt_param_202"), house.getTypeOfAd());
		selectByText(By.id("flt_param_556"), house.getObjectType());
		selectByText(By.id("flt_param_759"), house.getFloorsQuantity());
		selectByText(By.id("flt_param_527"), house.getWallsMaterial());
		selectByText(By.id("flt_param_525"), house.getCityDistance());
		selectByText(By.id("fld_metro_id"), house.getSubwayStation());
		type(By.id("flt_param_521"), house.getAreaOfHouse());
		type(By.id("flt_param_523"), house.getAreaOfSite());
		type(By.id("fld_description"), house.getDescription());
		type(By.id("fld_price"), house.getPrice());
		
		uploadImage("fld_images", "\\Mirniy\\622477121.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477187.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477256.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477305.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477349.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477408.jpg"); 
		                                                
		uploadImage("fld_images", "\\Mirniy\\622477474.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477546.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477621.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477725.jpg"); 
		
		uploadImage("fld_images", "\\Mirniy\\622477790.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477854.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622477938.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622478004.jpg"); 
		uploadImage("fld_images", "\\Mirniy\\622478057.jpg"); 
		
		click(By.id("package-free"));
	}
}
