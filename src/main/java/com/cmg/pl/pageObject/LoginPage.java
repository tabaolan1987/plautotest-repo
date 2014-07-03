package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.cmg.pl.action.PageLoading;

public class LoginPage {
	
	private static String URL = Constant.URL + "content/pl/_login_ask.html";
	
	private static String ID_TXT_USERNAME = "_request_username";
	
	private static String ID_TXT_PASSWORD = "_request_password";
	
	private static String ID_BTT_GO = "doauth";
	
	public static WebDriver LoadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.checkAlertPresent(driver);
		System.out.println("load page : " + URL);
		return driver;
	}
	
	public static WebElement txtUsername(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TXT_USERNAME));
		return el;
	}
	
	public static WebElement txtPassword(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TXT_PASSWORD));
		return el;
	}
	
	public static WebElement bttGo(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_BTT_GO));
		return el;
	}
}
