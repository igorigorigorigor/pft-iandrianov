package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.By;

public class CommercialHelper extends HelperBase{

	private Properties properties;
		
	public CommercialHelper(ApplicationManager manager, Properties properties) {
		super(manager);
		this.properties = properties;
	}
	
	public CommercialHelper createCommercial(Commercial comm){
  		fillCommercialData(comm);
  		return this;

	}
	
	public void signin(){
		fillCredentials();
	}
	
	private void fillCredentials() {
		type(By.name("login"), properties.getProperty("login"));
		type(By.name("password"), properties.getProperty("pass"));
		click(By.xpath("//button[@type='submit']"));
	}
			
	private void fillCommercialData(Commercial comm) {
		click(By.linkText("Подать объявление"));
		selectByText(By.id("fld_metro_id"), comm.getSubwayStation());
		selectByText(By.id("fld_category_id"), comm.getCategoryOfAd());
		selectByText(By.id("flt_param_536"), comm.getTypeOfAd());
		selectByText(By.id("flt_param_579"), comm.getObjectType());
		//selectByText(By.id("flt_param_537"), comm.getIsBusinessReady());
		type(By.id("flt_param_787"), comm.getArea());
		type(By.id("flt_param_587"), comm.getAddress());
		type(By.id("fld_title"), comm.getAdName());
		type(By.id("fld_description"), comm.getDescription());
		type(By.id("fld_price"), comm.getPrice());
		click(By.id("package-free"));
		
		
		uploadImage("fld_images", "\\Bondarenko\\580615964.jpg");
		uploadImage("fld_images", "\\Bondarenko\\580616165.jpg");
		uploadImage("fld_images", "\\Bondarenko\\580616128.jpg");
		uploadImage("fld_images", "\\Bondarenko\\588964115.jpg");
		
		uploadImage("fld_images", "\\Bondarenko\\580616271.jpg");
		uploadImage("fld_images", "\\Bondarenko\\580616293.jpg");
		uploadImage("fld_images", "\\Bondarenko\\580616186.jpg");
		uploadImage("fld_images", "\\Bondarenko\\580616301.jpg");
		uploadImage("fld_images", "\\Bondarenko\\580616312.jpg");
		uploadImage("fld_images", "\\Bondarenko\\580616321.jpg");
		
		
		
		click(By.cssSelector("#package-free > div.package-label > h3"));
		/*
	    click(By.id("form_submit"));
	    click(By.id("service_0"));
	    */
	    
	}

}
