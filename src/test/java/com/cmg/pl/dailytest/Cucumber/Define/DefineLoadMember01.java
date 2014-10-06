package com.cmg.pl.dailytest.Cucumber.Define;


import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.action.Authenticate;
import com.cmg.pl.action.SuperUser;
import com.cmg.pl.pageObject.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DefineLoadMember01 {
	
	@Given("^I open browser \"(.*?)\"$")
	public void i_open_browser(String arg1) throws Throwable {
		String browser = arg1;
		DriverUtil.driverCurrent = DriverUtil.getInstance(browser);
	}

	@And("^I navigate to \"(.*?)\"$")
	public void i_navigate_to(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("login page")){
			LoginPage.LoadPage(DriverUtil.driverCurrent);
		}
	}

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

	
	@Then("^I quit the browser$")
	public void i_quit_the_browser() throws Throwable {
		DriverUtil.driverCurrent.quit();
	}
	
	
	
}
