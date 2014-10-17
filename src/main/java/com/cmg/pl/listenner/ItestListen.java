package com.cmg.pl.listenner;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;


public class ItestListen implements ITestListener {
	
	
	boolean recordRunning = false;
	
	public void onTestSuccess(ITestResult result) {
		/*try {
			if(recordRunning){
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestFailure(ITestResult result) {
		try {
			TakeScreenShot.takeSnapShot(result.getName());
		} catch (Exception e) {
		}
	
		/*try {
			if(recordRunning){
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestSkipped(ITestResult result) {
		try {
			TakeScreenShot.takeSnapShot(result.getName());
		} catch (Exception e) {
		}
	
		/*try {
			if(recordRunning){
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onFinish(ITestContext context) {

	}

	public void onTestStart(ITestResult result) {
	/*	if(DriverUtil.browserRunning.equalsIgnoreCase("test")){
			String name = DriverUtil.browserRunning+"-"+ result.getName();
			try {
				record = new ScreenRecord();
				record.startRecording(name);
				recordRunning = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
	}



}
