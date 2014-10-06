package com.cmg.pl.dailytest.Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(
	format = {"pretty","html:target/html/"},
	features = {"src/test/java"}		
)
public class runCucumber {

}
