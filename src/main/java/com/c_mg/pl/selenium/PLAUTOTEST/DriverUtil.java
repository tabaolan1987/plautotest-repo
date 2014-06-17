package com.c_mg.pl.selenium.PLAUTOTEST;

import java.awt.List;
import java.io.File;

public class DriverUtil {
	public static final String PROP_PROJECT_BASE_DIR = "project.basedir";
	public static final String FOLDER_DRIVER = "driver";
	
	public static String getIeDriver(){
		String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER 
				+ File.separator + "IEDriverServer.exe";
		try {
			File driverIe = new File(path);
			if(driverIe.exists()){
				return driverIe.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;	
	}
	
	public static String getChromeDriver(){
		String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER 
				+ File.separator + "chromedriver.exe";
		try {
			File driverChrome = new File(path);
			if(driverChrome.exists()){
				return driverChrome.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;	
	}
}
