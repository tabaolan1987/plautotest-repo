package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyDetailPage {
	
	private static String URL = "https://pensionline.bp.com/content/pl/mydetails/";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		return driver;
	}
	
	public static WebElement subMenu(WebDriver driver, By by){
		WebElement el = driver.findElement(by);
		return el;
	}
	
}
