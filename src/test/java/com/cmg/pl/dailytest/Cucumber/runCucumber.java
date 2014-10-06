package com.cmg.pl.dailytest.Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(
	format = {"pretty","html:target/cucumber.html"},
	features = {"C:\\Users\\lantb\\git\\plautotest-repo\\src\\test\\java\\com\\cmg\\pl\\dailytest\\Cucumber\\feature"}		
)
public class runCucumber {

}
