package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;

public class LogoutPage {
	
	private static String URL =Constant.URL + "content/pl/_logout_ask.html";
	
	public static String XPAHT_BTT_LOGOUT = "//div[@id='pagebody']/form/input[@class='goButton']";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		return driver;
	}
	
	
	public static WebElement BttLogout(WebDriver driver){
		WebElement el = driver.findElement(By.xpath(XPAHT_BTT_LOGOUT));
		return el;
	}
}
