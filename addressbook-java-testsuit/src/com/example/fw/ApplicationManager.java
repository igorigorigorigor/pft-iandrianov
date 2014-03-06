package com.example.fw;


import java.util.Properties;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;




public class ApplicationManager {

	private static ApplicationManager singleton;
	
	public FolderHelper folderhelper;
	
	private Properties properties;

	private JFrameOperator mainFrame;
	
	
	public static ApplicationManager getInstance(){
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}
	
	public void setProperties(Properties properties){
		this.properties = properties;
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}
	
	public String getProperty(String key, String defaultValue){
		return properties.getProperty(key, defaultValue);
	}
	
	public void stop() {
		
	}
	
	public ApplicationManager() {
		// TODO Auto-generated constructor stub
	}

	public FolderHelper getFolderHelper() {
		if (folderhelper == null) {
			folderhelper = new FolderHelper(this);
		}
		return folderhelper;
	}

	public JFrameOperator getApplication() {
		if (mainFrame == null){
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainFrame = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return mainFrame;
	}
}
