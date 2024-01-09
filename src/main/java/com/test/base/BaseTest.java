package com.test.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.test.driver.BrowserFactory;
import com.test.driver.DriverFactory;
import com.test.properties.ConfigLoader;
import com.test.properties.TestDataLoader;

public class BaseTest {

	@BeforeSuite
	public void setUP() {
		WebDriver driver = BrowserFactory.createBrowserInstance(ConfigLoader.getInstnace().getPropertyValue("browser"));
		DriverFactory.getDriverFactoryInstance().setDriver(driver);
		DriverFactory.getDriverFactoryInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());
	}

	@AfterSuite
	public void tearDown() {
		DriverFactory.getDriverFactoryInstance().getDriver().quit();
	}

}
