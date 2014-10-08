package com.cmg.pl.dailytest.Cucumber.Runner;


import org.junit.Assert;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.CheckStateBenefitsPage;
import com.cmg.pl.action.PageLoading;

import cucumber.api.java.en.Then;

public class StateBenefitsDefine {
	
	
	@Then("^I should see the date of birth and the nino number should existed in State benefits page$")
	public void i_should_see_the_date_of_birth_and_the_nino_number_should_existed_in_State_benefits_page() throws InterruptedException  {
		  Assert.assertTrue(CheckStateBenefitsPage.checkTablePersonalDetailExisted(DriverUtil.driverCurrent, 20));
		  PageLoading.waitForImageInvisible(DriverUtil.driverCurrent, 50);
		  Assert.assertTrue(CheckStateBenefitsPage.checkDateOfBirth(DriverUtil.driverCurrent));
		  Assert.assertTrue(CheckStateBenefitsPage.checkNinoNumber(DriverUtil.driverCurrent));
	}
}
