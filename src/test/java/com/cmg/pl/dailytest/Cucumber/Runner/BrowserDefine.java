package com.cmg.pl.dailytest.Cucumber.Runner;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.pageObject.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BrowserDefine {
	
	
	@Given("^I open browser \"(.*?)\"$")
	public void i_open_browser(String arg1) {
		String browser = arg1;
		DriverUtil.driverCurrent = DriverUtil.getInstance(browser);
	}
	
	@Given("^I open browser$")
	public void open() {
		DriverUtil.driverCurrent = DriverUtil.getInstance(DriverUtil.browserRunning);
	}
	
	@Then("^I quit the browser$")
	public void i_quit_the_browser() {
		DriverUtil.driverCurrent.quit();
	}
	
	@And("^I navigate to Login Page$")
	public void i_navigate_to_Login_Page() {
		LoginPage.LoadPage(DriverUtil.driverCurrent);
	}
}
