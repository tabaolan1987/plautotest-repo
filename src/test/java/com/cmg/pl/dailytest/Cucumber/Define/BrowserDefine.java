package com.cmg.pl.dailytest.Cucumber.Define;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.cmg.pl.pageObject.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BrowserDefine {
	
	@Given("^I open browser \"(.*?)\"$")
	public void i_open_browser(String arg1) throws Throwable {
		String browser = arg1;
		DriverUtil.driverCurrent = DriverUtil.getInstance(browser);
	}
	
	@Then("^I quit the browser$")
	public void i_quit_the_browser() throws Throwable {
		DriverUtil.driverCurrent.quit();
	}
	
	@And("^I navigate to Login Page$")
	public void i_navigate_to_Login_Page() throws Throwable {
		LoginPage.LoadPage(DriverUtil.driverCurrent);
	}
}
