package com.cmg.pl.dailytest.Cucumber.Runner;

import org.junit.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.CheckSchemeBenefitsPage;
import com.cmg.pl.action.PageLoading;

import cucumber.api.java.en.Then;

public class SchemeBenefitDefine {

	@Then("^I should see the refno \"(.*?)\" existed in Scheme benefits page$")
	public void i_should_see_the_refno_existed_in_Scheme_benefits_page(
			String arg1) {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 200);
		Assert.assertTrue(CheckSchemeBenefitsPage
				.checkTablePersonalDetailsExisted(DriverUtil.driverCurrent, 10));
		Assert.assertTrue(CheckSchemeBenefitsPage.checkMemberRefNumberExisted(
				DriverUtil.driverCurrent, arg1));

	}

	@Then("^I should see the nino number existed in Scheme benefits page$")
	public void i_should_see_the_nino_number_existed_in_Scheme_benefits_page() {
		PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 200);
		Assert.assertTrue(CheckSchemeBenefitsPage
				.checkNinoNumberExisted(DriverUtil.driverCurrent));
	}
}
