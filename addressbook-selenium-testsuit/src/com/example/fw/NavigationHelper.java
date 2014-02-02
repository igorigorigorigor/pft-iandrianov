package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
	
	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public NavigationHelper mainPage() {
		if(!onMainPage()){
			click(By.linkText("home"));
		}
		return this;
	}
	
	public NavigationHelper groupsPage() {
		if(!onGroupsPage()){
			click(By.linkText("groups"));
		}
		return this;
	}
	
	private boolean onMainPage() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean temp = driver.findElements(By.id("maintable")).size() > 0;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return temp;
	}

	private boolean onGroupsPage(){
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			if(driver.getCurrentUrl().contains("/group.php") && driver.findElements(By.name("new")).size() > 0){
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				return true;
			}else{
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				return false;	
			}	
			
	}

}
