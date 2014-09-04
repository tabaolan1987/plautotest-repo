package com.cmg.pl.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cmg.pl.pageObject.MyRetirementPage;

public class CheckMyRetirementPage {

	public static void modelRetirementAge(WebDriver driver, int movePixel) throws InterruptedException {
		System.out.println("model retirement age");
		// click link 'Retirement age'
		MyRetirementPage.linkRetirementAge(driver).click();
		
		// wait for model button and slider show-up
	 		
		PageLoading.waitForElementExistedInDomVisible(MyRetirementPage.modelBttRetirementAge(driver), 20);
		PageLoading.waitForElementExistedInDomVisible(MyRetirementPage.modelSliderRetirementAge(driver), 20);
		
		//slide the slider
		Actions dragger = new Actions(driver);
		dragger.dragAndDropBy(MyRetirementPage.modelSliderRetirementAge(driver), movePixel, 0);
		dragger.build().perform();
		// click button to model
		MyRetirementPage.modelBttRetirementAge(driver).click();
		Thread.sleep(1000);
		// wait for spinning visible then invisible
		//PageLoading.waitForImageVisible(driver, 10);
		PageLoading.waitForImageInvisible(driver, 20);
		//Assert.assertFalse(PageLoading.checkDataError(driver));
	}

	public static void modelCashLumpSum(WebDriver driver, int movePixel) throws InterruptedException {
		System.out.println("model cashlumpsum");
		//click link 'Cash lump sum'
		MyRetirementPage.linkCashLumpSum(driver).click();
		
		// wait for button and slider show-up
			
		PageLoading.waitForElementExistedInDomVisible(MyRetirementPage.modelBttGoCashLum(driver), 20);
		PageLoading.waitForElementExistedInDomVisible(MyRetirementPage.modelSliderCashLumSum(driver), 20);
		
		// slide the slider
		Actions dragger = new Actions(driver);
		dragger.dragAndDropBy(MyRetirementPage.modelSliderCashLumSum(driver),movePixel, 0);
		dragger.build().perform();
		
		// click button to model
		MyRetirementPage.modelBttGoCashLum(driver).click();
		Thread.sleep(1000);
		// wait for spinning visible then invisible
		//PageLoading.waitForImageVisible(driver, 10);
		PageLoading.waitForImageInvisible(driver, 20);
		//Assert.assertFalse(PageLoading.checkDataError(driver));
		
		
	}

	public static void modelContributoryOptions(WebDriver driver,int timeout, int index) throws InterruptedException {
		//click on link 'Contributory option'
		System.out.println("model Contributory option");
		MyRetirementPage.linkContributoryOption(driver).click();
		
		//wait for element model present
				
		PageLoading.waitForElementExistedInDomVisible(MyRetirementPage.modelBttContributoryOption(driver), 20);
		PageLoading.waitForElementExistedInDomVisible(MyRetirementPage.SelectContributoryOption(driver), 20);
		
		//select option by index and model
		Select selectContri = new Select(MyRetirementPage.SelectContributoryOption(driver));
		selectContri.selectByIndex(index);
		MyRetirementPage.modelBttContributoryOption(driver).click();
		Thread.sleep(1000);
		//PageLoading.waitForImageVisible(driver, 10);
		PageLoading.waitForImageInvisible(driver, 20);
		//Assert.assertFalse(PageLoading.checkDataError(driver));
		
	}

}
