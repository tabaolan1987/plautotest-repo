package com.cmg.pl.dailytest.Cucumber.Runner;

import org.junit.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.CheckPaySlipsPage;
import com.cmg.pl.action.PageLoading;

import cucumber.api.java.en.Then;

public class MybenefitsDefine {

	@Then("^I should see refno \"(.*?)\" existed in My benefits page$")
	public void i_should_see_refno_existed_in_My_benefits_page(String arg1) {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 200);
		Assert.assertTrue(CheckPaySlipsPage.checkRefno(
				DriverUtil.driverCurrent, arg1));
	}

	@Then("^I should see data loaded successful in My benefits page$")
	public void i_should_see_data_loaded_successful_in_My_benefits_page() {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 200);
		Assert.assertTrue(CheckPaySlipsPage.checkTablePaySlipsExisted(
				DriverUtil.driverCurrent, 10));
		Assert.assertTrue(CheckPaySlipsPage.checkTablePersonalDetailExisted(
				DriverUtil.driverCurrent, 10));
		Assert.assertTrue(CheckPaySlipsPage
				.checkCurrentTaxYear(DriverUtil.driverCurrent));
		Assert.assertTrue(CheckPaySlipsPage.checkNiNo(DriverUtil.driverCurrent));
		Assert.assertTrue(CheckPaySlipsPage.checkBttPreviousExisted(
				DriverUtil.driverCurrent, 10));
	}

}
