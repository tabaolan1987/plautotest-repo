package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;

public class IndexSuperUserPage {
	
	private static String URL = Constant.URL + "content/pl/superuser/index.html";
	
	public static String ID_SELECT_BGROUP = "bgroup";
	
	public static String ID_TXT_REFNO = "crefno";
	
	public static String ID_BTT_GO = "doauth";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		return driver;
	}
	
	public static WebElement SelectBgroup(WebDriver driver){
		
		WebElement el = driver.findElement(By.id(ID_SELECT_BGROUP));
		return el;
	}
	
	public static WebElement TxtRefNo(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TXT_REFNO));
		return el;
	}
	
	public static WebElement BttGo(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_BTT_GO));
		return el;
	}
	
	
	
}
