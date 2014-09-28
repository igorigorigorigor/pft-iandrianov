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
  		uploadAllImages("image", flat.getImagesFolder());
  		return this;
	}
	
	public ApartmentHelper createRoom(Apartment flat){
  		fillRoomData(flat);
  		uploadAllImages("image", flat.getImagesFolder());
  		return this;
	}
	
	public ApartmentHelper createVasilievo(Apartment flat) {
		fillVasilievoData(flat);
  		uploadAllImages("image", flat.getImagesFolder());
  		return this;
	}
	
	private void fillVasilievoData(Apartment flat) {
		click(By.linkText("Подать объявление"));
		selectByText(By.id("region"), "Выбрать другой...");
		selectByText(By.name("loc_1"), "Татарстан"); 
		selectByText(By.name("loc_2"), "Васильево");
		click(By.id("apply_region"));
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

	public void signin() throws InterruptedException{
		fillCredentials();
	}

	private void fillCredentials() throws InterruptedException {
		type(By.name("login"), properties.getProperty("login"));
		type(By.name("password"), properties.getProperty("pass"));
		click(By.xpath("//button[@type='submit']"));
	}
	
	private void fillApartmentData(Apartment flat) {
		click(By.linkText("Подать объявление"));
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

	private void fillRoomData(Apartment flat) {
		click(By.linkText("Подать объявление"));
		selectByText(By.id("fld_metro_id"), flat.getSubwayStation());
		selectByText(By.id("fld_category_id"), flat.getCategoryOfAd());
		selectByText(By.id("flt_param_200"), flat.getTypeOfAd());
		selectByText(By.id("flt_param_511"), flat.getNumberOfRooms());
		//selectByText(By.id("flt_param_517"), flat.getObjectType());
		selectByText(By.id("flt_param_513"), flat.getFloorNumber());
		selectByText(By.id("flt_param_515"), flat.getFloorsQuantity());
		selectByText(By.id("flt_param_517"), flat.getBuildingType());
		type(By.id("flt_param_509"), flat.getArea());
		type(By.id("flt_param_507"), flat.getAddress());
		type(By.id("fld_description"), flat.getDescription());
		type(By.id("fld_price"), flat.getPrice());
		click(By.id("package-free"));
		click(By.cssSelector("#package-free > div.package-label > h3"));
	}

		
}
