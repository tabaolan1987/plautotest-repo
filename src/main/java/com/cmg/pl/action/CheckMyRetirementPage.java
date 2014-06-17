package com.cmg.pl.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cmg.pl.pageObject.MyRetirementPage;

public class CheckMyRetirementPage {

	public static void modelRetirementAge(WebDriver driver, int movePixel) {
		System.out.println("coming model retirement");
		// click link retirementAge
		MyRetirementPage.linkRetirementAge(driver).click();
		System.out.println("click link in table");
		// wait for button and slider show-up
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(MyRetirementPage.XPATH_BTT_GO_RETIREMENT)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id(MyRetirementPage.ID_SLIDER_RETIREMENT)));
		System.out.println("wait okay");
		// slide the slider
		Actions dragger = new Actions(driver);
		dragger.dragAndDropBy(
				MyRetirementPage.modelSliderRetirementAge(driver), movePixel, 0);
		dragger.build().perform();
		System.out.println("slide okay");
		// click button to model
		MyRetirementPage.modelBttRetirementAge(driver).click();
		System.out.println("click button model okay");
		// wait for spinning visible then invisible
		PageLoading.waitForImageVisible(driver, 10);
		System.out.println("all image visible");
		PageLoading.waitForImageInvisible(driver, 20);
		System.out.println("all image invisible");
	}

	public static void modelCashLumpSum(WebDriver driver, int movePixel) {
		
		System.out.println("coming model cash");
		MyRetirementPage.linkCashLumpSum(driver).click();
		System.out.println("click link cash");
		// wait for button and slider show-up
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(MyRetirementPage.XPATH_BTT_GO_CASHLUMSUM)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id(MyRetirementPage.ID_SLIDER_CASHLUMSUM)));
		System.out.println("wait okay");
		
		// slide the slider
		Actions dragger = new Actions(driver);
		dragger.dragAndDropBy(MyRetirementPage.modelSliderCashLumSum(driver),
				movePixel, 0);
		dragger.build().perform();
		
		// click button to model
		MyRetirementPage.modelBttGoCashLum(driver).click();
		System.out.println("click button model okay");
		// wait for spinning visible then invisible
		PageLoading.waitForImageVisible(driver, 10);
		System.out.println("all image visible");
		PageLoading.waitForImageInvisible(driver, 20);
		System.out.println("all image invisible");
		
		
	}

	public static void modelContributoryOptions(WebDriver driver,int timeout, int index) {
		//click on link contribution
		MyRetirementPage.linkContribu(driver).click();
		
		//wait for element model present
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(MyRetirementPage.ID_SELECT_CONTRIBU)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MyRetirementPage.XPATH_BTT_GO_CONTRIBU)));
		
		
		//select option by index and model
		Select selectContri = new Select(MyRetirementPage.SelectContriBu(driver));
		selectContri.selectByIndex(index);
		MyRetirementPage.modelBttContribu(driver).click();
		
		PageLoading.waitForImageVisible(driver, 10);
		System.out.println("all image visible");
		PageLoading.waitForImageInvisible(driver, 20);
		System.out.println("all image invisible");
		
	}

}
