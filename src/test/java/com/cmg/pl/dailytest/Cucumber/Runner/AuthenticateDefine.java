package com.cmg.pl.dailytest.Cucumber.Runner;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.Authenticate;

import cucumber.api.java.en.Then;

public class AuthenticateDefine {
	
	@Then("^I login as superuser$")
	public void i_login_as_superuser() {
		Authenticate.Login(DriverUtil.driverCurrent, "Autosuperuser", "P3nsions");
	}
	
	@Then("^I login as report runner$")
	public void i_login_as_reportrunner() {
		Authenticate.Login(DriverUtil.driverCurrent, "auto_daily_checker", "P3nsions");
	}
	
	
	@Then("^I logout$")
	public void i_logout() {
	    Authenticate.LogOut(DriverUtil.driverCurrent, Constant.NORMAL_WAITING_TIME);
	}

}
