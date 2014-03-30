package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.By;



public class ApartmentHelper extends HelperBase {

	private Properties properties;
		
	public ApartmentHelper(ApplicationManager manager, Properties properties) {
		super(manager);
		this.properties = properties;
	}
		
	public ApartmentHelper createApartment(Apartment flat){
  		fillApartmentData(flat);
  		uploadAllImages("fld_images", flat.getImagesFolder());
  		return this;

	}
	
	public void signin(){
		fillCredentials();
	}

	private void fillCredentials() {
		type(By.name("login"), properties.getProperty("login"));
		type(By.name("password"), properties.getProperty("pass"));
		click(By.xpath("//button[@type='submit']"));
	}
	
	private void fillApartmentData(Apartment flat) {
		click(By.linkText("������ ����������"));
		selectByText(By.id("fld_metro_id"), flat.getSubwayStation());
		selectByText(By.id("fld_category_id"), flat.getCategoryOfAd());
		selectByText(By.id("flt_param_201"), flat.getTypeOfAd());
		selectByText(By.id("flt_param_549"), flat.getNumberOfRooms());
		selectByText(By.id("flt_param_499"), flat.getObjectType());
		selectByText(By.id("flt_param_496"), flat.getFloorNumber());
		selectByText(By.id("flt_param_497"), flat.getFloorsQuantity());
		selectByText(By.id("flt_param_498"), flat.getBuildingType());
		type(By.id("flt_param_578"), flat.getArea());
		type(By.id("flt_param_494"), flat.getAddress());
		type(By.id("fld_description"), flat.getDescription());
		type(By.id("fld_price"), flat.getPrice());
		click(By.id("package-free"));
		click(By.cssSelector("#package-free > div.package-label > h3"));
	}
}
