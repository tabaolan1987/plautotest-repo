package com.cmg.pl.dailytest.Cucumber.Runner;

import org.testng.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.PageLoading;
import com.cmg.pl.action.RedundancyCheck;

import cucumber.api.java.en.Then;

public class RedundancyDefine {
	
	@Then("^I model model Redundancy$")
	public void i_model_model_Redundancy() throws InterruptedException {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, Constant.SMALL_WAITING_TIME);
		RedundancyCheck.modelRedundancy(DriverUtil.driverCurrent);
		Assert.assertFalse(PageLoading.checkDataError(DriverUtil.driverCurrent));
	}
	
}
