package com.test.driver;

import org.openqa.selenium.WebDriver;

/**
 * Parallel execution of browsers
 * Using Singleton pattern to instantiate a single instance of the driver
*/
public class DriverFactory {
    
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverFactory() {

    }
    
    private static DriverFactory driverFactoryInstance = new DriverFactory();

    public static DriverFactory getDriverFactoryInstance() {
        return driverFactoryInstance;
    }

    public void setDriver(WebDriver driverObject) {
        driver.set(driverObject);
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}