package com.cmg.pl.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cmg.pl.pageObject.RedundancyPage;

public class RedundancyCheck {
	
	private static String TR_CLASS = "headrow";
	
	private static int INDEX_TD_NEXT_MONTH = 3;
	
	private static String TD_CLASS = "day";
	
	public static void modelRedundancy(WebDriver driver){
		//Click on link text date
		RedundancyPage.linkRedudancyDate(driver).click();
		//wait for all element model present
		waitForButtonModel(driver, 10);
		waitForTextBox(driver, 10);
		
		//click to open calendar
		RedundancyPage.txt_Date(driver).click();
		//wait for calendar present
		waitForCalendar(driver, 10);
		//click to set next month in calendar
		setNextMonthCalendar(driver);
		//click to choose the first date of next month in calendar
		chooseDateNextMonth(driver);
		//click model
		RedundancyPage.bttModel(driver).click();
		//check page loading
		PageLoading.waitForImageVisible(driver, 10);
		PageLoading.waitForImageInvisible(driver, 20);
		Assert.assertFalse(PageLoading.checkDataError(driver));
	}
	
	private static void waitForCalendar(WebDriver driver , int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RedundancyPage.XPATH_CALENDAR)));
	}
	
	private static void waitForButtonModel(WebDriver driver , int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RedundancyPage.XPATH_BTT_GO)));
	}
	
	private static void waitForTextBox(WebDriver driver , int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RedundancyPage.ID_TEXT_REDUDANCY_DATE)));
	}
	
	private static void setNextMonthCalendar(WebDriver driver){
		WebElement thead = RedundancyPage.tableCalendar(driver).findElement(By.tagName("thead"));
		List<WebElement> trs = thead.findElements(By.tagName("tr"));
		for(WebElement tr : trs){
			if(tr.getAttribute("class").equalsIgnoreCase(TR_CLASS)){
				List<WebElement> tds = tr.findElements(By.tagName("td"));
				WebElement tdNextMonth = tds.get(INDEX_TD_NEXT_MONTH);
				tdNextMonth.click();
				break;
			}
		}
	}
	
	public static void chooseDateNextMonth(WebDriver driver){
		WebElement tbody = RedundancyPage.tableCalendar(driver).findElement(By.tagName("tbody"));
		WebElement firstTr = tbody.findElements(By.tagName("tr")).get(0);
		List<WebElement> tds = firstTr.findElements(By.tagName("td"));
		for(WebElement td : tds){
			if(td.getAttribute("class").equalsIgnoreCase(TD_CLASS)){
				td.click();
				break;
			}
		}
	}
}
