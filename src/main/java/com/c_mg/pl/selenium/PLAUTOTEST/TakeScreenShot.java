package com.c_mg.pl.selenium.PLAUTOTEST;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TakeScreenShot {
	private static WebDriver driver;
	public static final String PROP_PROJECT_BUILD_DIR = "project.build.directory";
	public static final String TEST_PACKAGE = "test.package";
	
	public static void init(WebDriver d) {
		driver = d;
	}
	
	
	public static void takeScreenshoot(String name) {
		CmgiumMethod currentTestMethod = getCurrentTestMethod();
		// skip take screenshot if could not found current test method execute
		if (currentTestMethod == null) 
			return;
		
		String screenshootDir = PropertiesHelper.getKey(PROP_PROJECT_BUILD_DIR)
				+ File.separator + "screenshots" + File.separator
				+ currentTestMethod.getClassName();
		File f = new File(screenshootDir);
		if (!f.exists() || !f.isDirectory()) {
			f.mkdirs();
		}
		File output = null;
		File file;
		try {
			if (name == null || name.length() == 0) {
				File[] files = f.listFiles();
				int count = 0;
				if (files != null && files.length > 0) {
					for (File fl : files) {
						if (fl.getName()
								.startsWith(currentTestMethod.getName())) {
							count++;
						}
					}
				}
				name = currentTestMethod.getName()
						+ (count == 0 ? "" : (" (" + count + ")"));
			}
			output = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			if(driver instanceof FirefoxDriver){
				name = name +"-firefox";
			}else if(driver instanceof InternetExplorerDriver){
				name = name + "-ie";
			}else if(driver instanceof ChromeDriver){
				name = name + "-chrome";
			}
			file = new File(screenshootDir, name + ".png");
			FileUtils.copyFile(output, file);
		} catch (IOException e) {

		}
	}

	public static void takeScreenshoot() {
		takeScreenshoot("");
	}

	public static CmgiumMethod getCurrentTestMethod() {
		String testPackge = PropertiesHelper.getKey(TEST_PACKAGE);
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		for (int i = 0; i < ste.length; i++) {
			String className = ste[i].getClassName();
			String methodName = ste[i].getMethodName();
			if (className.startsWith(testPackge)) {
				CmgiumMethod method = new CmgiumMethod();
				method.setClassName(className);
				method.setName(methodName);
				return method;
			}
		}
		return null;
	}
}
