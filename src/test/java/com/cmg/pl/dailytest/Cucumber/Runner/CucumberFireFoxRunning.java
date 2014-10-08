package com.cmg.pl.dailytest.Cucumber.Runner;

import org.junit.runner.RunWith;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/"},
		format = {"pretty","html:target/firefox/"},
		tags ={"@firefox"}
)
public class CucumberFireFoxRunning {
	
}
