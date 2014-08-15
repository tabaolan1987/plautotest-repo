package com.c_mg.pl.selenium.PLAUTOTEST;

import java.io.File;

public class DriverUtil {
	public static final String PROP_PROJECT_BASE_DIR = "project.basedir";
	public static final String FOLDER_DRIVER = "driver";
	
	public static String getIeDriver(){
		
		String path = "H:\\Driver Automation\\IEDriverServer.exe";
		return path;
		/*String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER 
				+ File.separator + "IEDriverServer.exe";
		try {
			File driverIe = new File(path);
			if(driverIe.exists()){
				//System.out.println("ie chrome exist : " + driverIe.getAbsolutePath());
				return driverIe.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;	*/
	}
	
	public static String getChromeDriver(){
		String path = "H:\\Driver Automation\\chromedriver.exe";
		return path;
		/*String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER 
				+ File.separator + "chromedriver.exe";
		try {
			File driverChrome = new File(path);
			if(driverChrome.exists()){
				//System.out.println("driver chrome exist : " + driverChrome.getAbsolutePath());
				return driverChrome.getAbsolutePath();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;	*/
	}
}
