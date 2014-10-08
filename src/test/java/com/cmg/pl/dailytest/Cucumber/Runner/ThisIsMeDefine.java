package com.cmg.pl.dailytest.Cucumber.Runner;

import org.junit.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.CheckThisIsMePage;
import com.cmg.pl.action.PageLoading;

import cucumber.api.java.en.Then;

public class ThisIsMeDefine {

	@Then("^I should see the refno \"(.*?)\" existed in This is Me page$")
	public void i_should_see_the_refno_existed_in_table_detail(String arg1)
			 {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 30);
		Assert.assertFalse(PageLoading.checkDataError(DriverUtil.driverCurrent));
		CheckThisIsMePage.checkPersonalDetailTableExisted(
				DriverUtil.driverCurrent, 20);
		Assert.assertTrue(CheckThisIsMePage.checkMembershipExisted(
				DriverUtil.driverCurrent, arg1));

	}

}
