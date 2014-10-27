package com.example.fw;


import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
	
	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public NavigationHelper mainPage() {
		if(!onMainPage()){
			click(By.linkText("Подать объявление"));
		}
		return this;
	}
	
	private boolean onMainPage() {
		
		return false;
	}

}
