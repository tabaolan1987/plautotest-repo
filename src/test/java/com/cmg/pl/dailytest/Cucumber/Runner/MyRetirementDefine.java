package com.cmg.pl.dailytest.Cucumber.Runner;

import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.CheckMyRetirementPage;
import com.cmg.pl.action.PageLoading;

import cucumber.api.java.en.Then;

public class MyRetirementDefine {

	@Then("^I model Retirement Age$")
	public void i_model_Retirement_Age() throws InterruptedException{
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 20);
		CheckMyRetirementPage.modelRetirementAge(DriverUtil.driverCurrent, -30);
		Thread.sleep(2000);
		Assert.assertFalse(PageLoading.checkDataError(DriverUtil.driverCurrent));
	}

	@Then("^I model Contributory Options$")
	public void i_model_Contributory_Options() throws InterruptedException {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 20);
		CheckMyRetirementPage.modelContributoryOptions(DriverUtil.driverCurrent, 10, 2);
		Thread.sleep(2000);
		Assert.assertFalse(PageLoading.checkDataError(DriverUtil.driverCurrent));
	}

	@Then("^I model Cash Lump Sum$")
	public void i_model_Cash_Lump_Sum() throws InterruptedException{
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 50);
		CheckMyRetirementPage.modelCashLumpSum(DriverUtil.driverCurrent, 30);
		Thread.sleep(2000);
		Assert.assertFalse(PageLoading.checkDataError(DriverUtil.driverCurrent));
	}
}
