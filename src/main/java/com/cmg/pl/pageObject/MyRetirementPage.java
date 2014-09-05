package com.cmg.pl.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.cmg.pl.action.PageLoading;

public class MyRetirementPage {
	
	private static String URL = Constant.URL + "content/pl/mydetails/retirement_planner_ac/";
	
	
	public static String LINK_TEXT_RETIREMENT_AGE = "Retirement age";
	
	public static String XPATH_BTT_GO_RETIREMENT = "//div[@id='age_panel']/form/div[@class='slider_panel']/span[@class='goButton']";
	
	public static String ID_SLIDER_RETIREMENT = "sl0slider";
	
	
	public static String LINK_TEXT_CONTRIBUTORY_OPTION = "Contributory options";
	
	public static String ID_SELECT_CONTRIBUTORY_OPTION = "input_co_option";
	
	public static String XPATH_BTT_GO_CONTRIBUTORY_OPTION = "//div[@id='contrib_option_panel']/div[@class='slider_panel']/input[@class='goButton'] ";
	
	
	
	public static String LINK_TEXT_CASHLUMSUM = "Cash lump sum";
	
	public static String ID_SLIDER_CASHLUMSUM = "sl1slider";
	
	public static String XPATH_BTT_GO_CASHLUMSUM ="//div[@id='cash_panel']/div[@class='slider_panel']/input[2][@class='goButton'] ";
	
	
	public static WebDriver loadPage(WebDriver driver){
		driver.get(URL);
		PageLoading.waitForImageVisible(driver, 10);
		PageLoading.waitForImageInvisible(driver, 20);
		Assert.assertFalse(PageLoading.checkDataError(driver));
		System.out.println("Load page : " + URL);
		return driver;
	}
	
	
	public static WebElement linkRetirementAge(WebDriver driver){
		WebElement el = driver.findElement(By.linkText(LINK_TEXT_RETIREMENT_AGE));
		return el;
	}
	
	public static WebElement modelBttRetirementAge(WebDriver driver){
		WebElement el = driver.findElement(By.xpath(XPATH_BTT_GO_RETIREMENT));
		return el;
	}
	
	public static WebElement modelSliderRetirementAge(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_SLIDER_RETIREMENT));
		return el;
	}
	
	
	
	public static WebElement linkContributoryOption(WebDriver driver){
		WebElement el = driver.findElement(By.linkText(LINK_TEXT_CONTRIBUTORY_OPTION));
		return el;
	}
	
	public static WebElement SelectContributoryOption(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_SELECT_CONTRIBUTORY_OPTION));
		return el;
	}
	
	public static WebElement modelBttContributoryOption(WebDriver driver){
		WebElement el = driver.findElement(By.xpath(XPATH_BTT_GO_CONTRIBUTORY_OPTION));
		return el;
	}
	
	
	public static WebElement linkCashLumpSum(WebDriver driver){
		WebElement el = driver.findElement(By.linkText(LINK_TEXT_CASHLUMSUM));
		return el;
	}
	
	public static WebElement modelSliderCashLumSum(WebDriver driver){
		WebElement el = driver.findElement(By.id(ID_SLIDER_CASHLUMSUM));
		return el;
	}
	
	public static WebElement modelBttGoCashLum(WebDriver driver){
		WebElement el = driver.findElement(By.xpath(XPATH_BTT_GO_CASHLUMSUM));
		return el;
	}
}
