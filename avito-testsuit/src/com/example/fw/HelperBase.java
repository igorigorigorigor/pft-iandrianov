package com.example.fw;


import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HelperBase {

	protected ApplicationManager manager;
	protected WebDriver driver;
	protected boolean acceptNextAlert;
	public String CurrentDirectory;
	public WebDriverWait wait;
	

	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
		this.acceptNextAlert = manager.acceptNextAlert;
		this.CurrentDirectory = System.getProperty("user.dir").toString();
		this.wait = new WebDriverWait(driver, 15);
	}
	
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	acceptNextAlert = true;
	    }
	  }

	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);	
		}
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null) {
			new Select(driver.findElement(locator)).selectByVisibleText(text);	
		}
	}
	
	protected void uploadImage(String id, String image) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		driver.findElement(By.id(id)).sendKeys(CurrentDirectory + image);
	}
	
	protected void uploadAllImages(String id, String imagesFolder){
		File folder = new File(CurrentDirectory + imagesFolder);
		File[] listOfImages = folder.listFiles();
		for (int i = 0; i < listOfImages.length; i++) {
			if (listOfImages[i].isFile()) {
		    	uploadImage(id, imagesFolder + "\\" + listOfImages[i].getName());
		    }
		}
	}
}
		    
		    

