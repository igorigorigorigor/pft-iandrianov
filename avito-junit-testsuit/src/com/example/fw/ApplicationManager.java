package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class ApplicationManager {

	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	private Properties properties;
	
	
	
	public NavigationHelper navigationhelper;

	public ApartmentHelper apartmenthelper;
	
	public CommercialHelper commercialhelper;
	
	public HouseHelper househelper;
	
	public SiteHelper sitehelper;
	
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		
	    navigationhelper = new NavigationHelper(this);

	    apartmenthelper = new ApartmentHelper(this, properties);
	    
	    commercialhelper = new CommercialHelper(this, properties);
	    
	    househelper = new HouseHelper(this, properties);
	    
	    sitehelper = new SiteHelper(this, properties);
	}
	
	public void stop() {
		//driver.quit();
	}
	
	public NavigationHelper navigateTo(){
		if (navigationhelper == null){
			navigationhelper = new NavigationHelper(this);
		}
		return navigationhelper;
	}
	

	public ApartmentHelper getapartmenthelper() {
		if (apartmenthelper == null){
			apartmenthelper  = new ApartmentHelper(this, properties);
		}
		return apartmenthelper;
	}
	
	public CommercialHelper getcommercialhelper() {
		if (commercialhelper == null){
			commercialhelper  = new CommercialHelper(this, properties);
		}
		return commercialhelper;
	}
	
	public HouseHelper gethousehelper() {
		if (househelper == null){
			househelper  = new HouseHelper(this, properties);
		}
		return househelper;
	}
	
	public SiteHelper getsitehelper() {
		if (sitehelper == null){
			sitehelper  = new SiteHelper(this, properties);
		}
		return sitehelper;
	}
}
