package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.By;

public class SiteHelper extends HelperBase  {
	
	@SuppressWarnings("unused")
	private Properties properties;

	public SiteHelper(ApplicationManager manager, Properties properties) {
		super(manager);
		this.properties = properties;
	}

	public SiteHelper createSite(Site site) {
		fillSiteData(site);
		uploadAllImages("fld_images", site.getImagesFolder());
  		return this;
	}

	
	private void fillSiteData(Site site) {
		click(By.linkText("Подать объявление"));
		
		selectByText(By.id("fld_category_id"), site.getCategoryOfAd());
		selectByText(By.id("flt_param_203"), site.getTypeOfAd());
		selectByText(By.id("flt_param_531"), site.getObjectType());
		selectByText(By.id("flt_param_530"), site.getCityDistance());
		selectByText(By.id("fld_metro_id"), site.getSubwayStation());
		type(By.id("flt_param_529"), site.getAreaOfSite());
		type(By.id("fld_description"), site.getDescription());
		type(By.id("fld_price"), site.getPrice());
		
		click(By.id("package-free"));
	}

	
}
