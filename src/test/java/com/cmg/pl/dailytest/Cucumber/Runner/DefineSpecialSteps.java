package com.cmg.pl.dailytest.Cucumber.Runner;


import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.SuperUser;

import cucumber.api.java.en.Then;

public class DefineSpecialSteps {

	@Then("^I load member \"(.*?)\"$")
	public void i_load_member(String arg1) {
		String group = arg1.split("-")[0];
		String refno = arg1.split("-")[1];
		SuperUser.loadMember(DriverUtil.driverCurrent, Constant.NORMAL_WAITING_TIME, group, refno);
	}

}
