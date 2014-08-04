package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;

public class MyDetailPage {
	
	private static String URL = Constant.URL +  "content/pl/mydetails/";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		System.out.println("load page : " + URL);
		return driver;
	}
	
	public static WebElement subMenu(WebDriver driver, By by){
		WebElement el = driver.findElement(by);
		return el;
	}
	
}
