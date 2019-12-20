/*
 * Classname : com.rxp.realcontrol.serenity.drivers.DriverFactory
 *
 * Created on: 26 Nov 2018
 *
 * Copyright (c) 2000-2018 Realex Payments, Ltd.
 * Realex Payments, The Observatory, 7-11 Sir John Rogerson's Quay, Dublin 2, Ireland
 *
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Realex Payments, Ltd. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Realex Payments.
 *
 */
package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

//import org.openqa.selenium.ie.ElementScrollBehavior;

public class DriverFactory {
	static WebDriver driver = null;
	public static WebDriver getDriver() {

		String browserName = System.getProperty("Browser", DriverType.CHROME.toString()).toUpperCase();
		DriverType driverType = DriverType.valueOf(browserName);
		switch (driverType) {
		case CHROME:
			if(driver == null){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
			break;
		case IE:
			InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
			internetExplorerOptions
					.requireWindowFocus().usePerProcessProxy()
					.introduceFlakinessByIgnoringSecurityDomains().ignoreZoomSettings()
					.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT)
					.enablePersistentHovering().setPageLoadStrategy(PageLoadStrategy.EAGER);
//					.elementScrollTo(ElementScrollBehavior.TOP).setCapability(InternetExplorerDriver.SILENT, true);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(internetExplorerOptions);

			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

//	public static WebDriver getDriver() {
//		return driver;
//	}

	public static void setDriver()
	{
		driver=null;
	}

	//	private static WebDriver driver;
//
//	public synchronized WebDriver createDriver() {
//		if (driver == null)
//			driver = new ChromeDriver();
//		return driver;
//	}
//	public static WebDriver getDriver() {
//		return driver;
//	}
//	@AfterAll
//	public static void closeDriver() {
//		driver.quit();
//		driver = null;
//	}

}
