package com.c_mg.pl.selenium.PLAUTOTEST;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lantb\\git\\plautotest-repo\\driver\\chromedriver.exe");
         WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.12:4444/wd/hub"), capability);
         driver.get("http://docs.seleniumhq.org/download/");
    }
}
