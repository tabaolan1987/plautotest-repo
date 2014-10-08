package com.cmg.pl.dailytest.Cucumber.Runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/"},
		format = {"pretty","html:target/ie/"},
		tags ={"@ie"}
)
public class CucumberIERunning {

}
