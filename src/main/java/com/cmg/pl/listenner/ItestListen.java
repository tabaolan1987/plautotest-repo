package com.cmg.pl.listenner;


import java.sql.Driver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.c_mg.pl.selenium.PLAUTOTEST.DriverUtil;
import com.c_mg.pl.selenium.PLAUTOTEST.ScreenRecord;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;


public class ItestListen implements ITestListener {
	
	private ScreenRecord record;
	
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
		TakeScreenShot.takeSnapShot(result.getName());
		/*try {
			if(recordRunning){
				record.stopRecording();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void onTestSkipped(ITestResult result) {
		TakeScreenShot.takeSnapShot(result.getName());
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
