package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {

	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	
	
	public NavigationHelper navigationhelper;
	public GroupHelper grouphelper;
	public ContactHelper contacthelper;
	
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost:9000/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    navigationhelper = new NavigationHelper(this);
	    grouphelper = new GroupHelper(this);
	    contacthelper = new ContactHelper(this);
	}
	
	public void stop() {
		driver.quit();
	}
	
	public NavigationHelper getnavigationhelper(){
		if (navigationhelper == null){
			navigationhelper = new NavigationHelper(this);
		}
		return navigationhelper;
	}
	
	public GroupHelper getgrouphelper(){
		if (grouphelper == null){
			grouphelper = new GroupHelper(this);
		}
		return grouphelper;
	}
	public ContactHelper getcontacthelper(){
		if (contacthelper == null){
			contacthelper = new ContactHelper(this);
		}
		return contacthelper;
	}
}
