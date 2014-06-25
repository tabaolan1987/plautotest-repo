package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.cmg.pl.action.PageLoading;

public class RedundancyPage {
	
	private static String URL = Constant.URL + "content/pl/mydetails/redundancy_planner_ac/";
	
	private static String LINK_TEXT_REDUDANCY_DATE = "Redundancy date";
	
	public static String XPATH_BTT_GO = "//div[@id='date_panel']/form/div[@class='slider_panel']/input[2][@class='goButton']";
	
	public static String ID_TEXT_REDUDANCY_DATE = "input_co_nra";
	
	public static String XPATH_CALENDAR = "//div[@class='calendar']/table";
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 10);
		PageLoading.waitForImageInvisible(driver, 20);
		Assert.assertFalse(PageLoading.checkDataError(driver));
		return driver;
	}
	
	
	public static WebElement linkRedudancyDate(WebDriver driver){
		WebElement el = driver.findElement(By.linkText(LINK_TEXT_REDUDANCY_DATE));
		return el;
	}
	
	public static WebElement bttModel(WebDriver driver){
		WebElement el = driver.findElement(By.xpath(XPATH_BTT_GO));
		return el;
	}
	
	public static WebElement txt_Date(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_TEXT_REDUDANCY_DATE));
		return el;
	}
	
	public static WebElement tableCalendar(WebDriver driver){
		WebElement el = driver.findElement(By.xpath(XPATH_CALENDAR));
		return el;
	}
}
