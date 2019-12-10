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

import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver newDriver() {
		WebDriver driver = null;
//		String browserName = System.getProperty("Browser", DriverType.CHROME.toString()).toUpperCase();
//		DriverType driverType = DriverType.valueOf(browserName);
		DriverType driverType = DriverType.CHROME;
		switch (driverType) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}
}
