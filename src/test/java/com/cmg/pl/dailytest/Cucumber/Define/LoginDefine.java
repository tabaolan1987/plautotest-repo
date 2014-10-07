package com.cmg.pl.dailytest.Cucumber.Define;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.SuperUser;

import cucumber.api.java.en.Then;

public class LoginDefine {
	
	@Then("^I login as superuser$")
	public void i_login_as_superuser() throws Throwable {
		Authenticate.Login(DriverUtil.driverCurrent, "Autosuperuser", "P3nsions");
	}
	
	@Then("^I load member \"(.*?)\"$")
	public void i_load_member(String arg1) throws Throwable {
		String group = arg1.split("-")[0];
		String refno = arg1.split("-")[1];
		SuperUser.loadMember(DriverUtil.driverCurrent, 30, group, refno);
	}

}
