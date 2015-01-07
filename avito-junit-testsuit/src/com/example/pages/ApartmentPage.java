package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.fw.Apartment;

public class ApartmentPage extends BasePage {
	
	@FindBy(id="flt_param_549")
	protected WebElement numberOfRoomsSelect;
	
	@FindBy(id="flt_param_499")
	protected WebElement objectTypeSelect;

	@FindBy(id="flt_param_496")
	protected WebElement floorNumberSelect;

	@FindBy(id="flt_param_497")
	protected WebElement floorQuantitySelect;
	
	@FindBy(id="flt_param_498")
	protected WebElement buildingTypeSelect;
	
	@FindBy(id="flt_param_578")
	protected WebElement areaField;
	
	@FindBy(id="flt_param_494")
	protected WebElement addressField;
	
	@FindBy(id="fld_description")
	protected WebElement descriptionField;
	
	@FindBy(id="fld_price")
	protected WebElement priceField;
	
	
	@FindBy(css="#package-free > div.package-label > h3")
	protected WebElement packageFreeLabel;

	@FindBy(id = "fld_category_id")
	protected WebElement categorySelect;

	@FindBy(xpath = "//*[@data-name='params[201]']")
	protected WebElement typeOfAdSelect;
	
	@FindBy(id = "region")
	protected WebElement locationSelect;
	
	@FindBy(name = "loc_1")
	protected WebElement regionSelect;

	@FindBy(name = "loc_2")
	protected WebElement localitySelect;
	
	@FindBy(id = "apply_region")
	protected WebElement applyRegionButton;
	
	public ApartmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void fillApartmentData(Apartment flat) {
		selectByText(categorySelect, flat.getCategoryOfAd());
		selectByText(typeOfAdSelect, flat.getTypeOfAd());
		selectByText(numberOfRoomsSelect, flat.getNumberOfRooms());
		selectByText(objectTypeSelect, flat.getObjectType());
		selectByText(floorNumberSelect, flat.getFloorNumber());
		selectByText(floorQuantitySelect, flat.getFloorsQuantity());
		selectByText(buildingTypeSelect, flat.getBuildingType());
		type(areaField, flat.getArea());
		type(addressField, flat.getAddress());
		type(descriptionField, flat.getDescription());
		type(priceField, flat.getPrice());
		packageFreeLabel.click();		
	}
	
	public void selectVasilievoLocation(Apartment flat) {
		selectByText(locationSelect, "Выбрать другой...");
		selectByText(regionSelect, "Татарстан"); 
		selectByText(localitySelect, "Васильево");
		applyRegionButton.click();
	}
}
