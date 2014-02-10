package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {

	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	private Properties properties;
	
	
	public NavigationHelper navigationhelper;

	public ApartmentHelper apartmenthelper;
	
	public CommercialHelper commercialhelper;
	
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if("firefox".equals(browser)){
			driver = new FirefoxDriver();
		} else if ("ie".equals(browser)){
			System.setProperty("webdriver.ie.driver", "D:\\Study\\PFT\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new Error("Unsupported browser: " + browser);
		}		
	    baseUrl = properties.getProperty("baseUrl");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	    navigationhelper = new NavigationHelper(this);

	    apartmenthelper = new ApartmentHelper(this, properties);
	    
	    commercialhelper = new CommercialHelper(this, properties);
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
}
