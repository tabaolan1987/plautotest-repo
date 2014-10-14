package com.cmg.pl.dailytest.Cucumber.Runner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.PageLoading;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinkDefine {
	
	public boolean checkLink(WebDriver driver,String name){
		boolean check = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constant.SMALL_WAITING_TIME);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(name)));
			WebElement link = driver.findElement(By.linkText(name));
			if(link.isDisplayed()){
				check = true;
			}
		} catch (Exception e) {
			check = false;
		}
		return check;
	}
	
	

	@When("^I click to \"(.*?)\" link$")
	public void i_click_to_link(String arg1)  {
		DriverUtil.driverCurrent.findElement(By.linkText(arg1)).click();
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, Constant.LONG_WAITING_TIME);
	}

	
	@Then("^I should not see \"(.*?)\" link$")
	public void i_should_not_see_link(String arg1) {
		Assert.assertFalse(checkLink(DriverUtil.driverCurrent, arg1));
	}
	
	@Then("^I should see \"(.*?)\" link$")
	public void i_should__see_link(String arg1) {
		Assert.assertTrue(checkLink(DriverUtil.driverCurrent, arg1));
	}

}
