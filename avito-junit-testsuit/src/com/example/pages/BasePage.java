package com.example.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends PageObject {

	@FindBy(linkText = "Подать объявление")
	protected WebElement newAdButton;

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	protected void selectByText(WebElement webelement, String text) {
		if (text != null) {
			new Select(webelement).selectByVisibleText(text);	
		}
	}
	
	protected void type(WebElement webelement, String text) {
		if (text != null) {
			webelement.clear();
			webelement.sendKeys(text);	
		}
	}

	public void createNewAd() {
		newAdButton.click();
	}
}
