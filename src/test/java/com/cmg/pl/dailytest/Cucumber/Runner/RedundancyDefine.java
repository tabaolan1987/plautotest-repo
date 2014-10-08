package com.cmg.pl.dailytest.Cucumber.Runner;

import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.PageLoading;
import com.cmg.pl.action.RedundancyCheck;

import cucumber.api.java.en.Then;

public class RedundancyDefine {
	
	@Then("^I model model Redundancy$")
	public void i_model_model_Redundancy() throws InterruptedException {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 20);
		RedundancyCheck.modelRedundancy(DriverUtil.driverCurrent);
		Assert.assertFalse(PageLoading.checkDataError(DriverUtil.driverCurrent));
	}
	
}
