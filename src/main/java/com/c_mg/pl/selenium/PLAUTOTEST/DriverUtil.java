package com.c_mg.pl.selenium.PLAUTOTEST;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtil {
	public static final String PROP_PROJECT_BASE_DIR = "project.basedir";
	public static final String FOLDER_DRIVER = "driver";
	
	public static String getIeDriver(){
		/*String path = "H:\\Driver Automation\\IEDriverServer.exe";
		return path;*/
		String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER 
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
		return null;
	}
	
	public static String getChromeDriver(){
		/*String path = "H:\\Driver Automation\\chromedriver.exe";
		return path;*/
		String path = PropertiesHelper.getKey(PROP_PROJECT_BASE_DIR) + File.separator + FOLDER_DRIVER 
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
		return null;	
	}
	
	public static WebDriver getInstance(String browser){
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("firefox")) {
			try {
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
			} catch (WebDriverException e) {
				System.out.println(e.getMessage());
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setPreference(FirefoxProfile.PORT_PREFERENCE, 7056);
				driver = new FirefoxDriver(profile);
			}
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					DriverUtil.getChromeDriver());
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", DriverUtil.getIeDriver());
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(
			    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			    true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().deleteAllCookies();
		}
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		return driver;
	}
}
