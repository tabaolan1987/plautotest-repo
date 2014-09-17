package com.cmg.pl.listenner;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;


public class ItestListen implements ITestListener {


	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		TakeScreenShot.takeSnapShot(result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		TakeScreenShot.takeSnapShot(result.getName());
	}

	public void onFinish(ITestContext context) {

	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}



}
