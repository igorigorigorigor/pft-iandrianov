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
		fillHouseData(house);
		uploadAllImages("fld_images", house.getImagesFolder());
  		return this;
	}
	
	public HouseHelper createVasilievo(House house) {
		fillCheboksarskayaData(house);
		uploadAllImages("fld_images", house.getImagesFolder());
  		return this;
	}
	
	private void fillCheboksarskayaData(House house) {
		click(By.linkText("Подать объявление"));
		selectByText(By.id("region"), "Выбрать другой...");
		selectByText(By.name("loc_1"), "Татарстан"); 
		selectByText(By.name("loc_2"), "Зеленодольск");
		click(By.id("apply_region"));
		selectByText(By.id("fld_category_id"), house.getCategoryOfAd());
		selectByText(By.id("flt_param_202"), house.getTypeOfAd());
		selectByText(By.id("flt_param_556"), house.getObjectType());
		selectByText(By.id("flt_param_759"), house.getFloorsQuantity());
		selectByText(By.id("flt_param_527"), house.getWallsMaterial());
		selectByText(By.id("flt_param_525"), house.getCityDistance());
		type(By.id("flt_param_521"), house.getAreaOfHouse());
		type(By.id("flt_param_523"), house.getAreaOfSite());
		type(By.id("fld_description"), house.getDescription());
		type(By.id("fld_price"), house.getPrice());
		
				
		click(By.id("package-free"));
		
	}

	
	private void fillHouseData(House house) {
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
		
				
		click(By.id("package-free"));
	}

	
}
