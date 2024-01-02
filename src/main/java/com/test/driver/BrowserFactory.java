package com.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

/**
 * Logic to select and create the browser object
*/
public class BrowserFactory {
    public WebDriver createBrowserInstance(String browserName) {
        WebDriver driver = null;

        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "Edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
            case "Safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;
            default:
                System.out.println("Error No driver selected!");
                break;
        }
        
        return driver;
    }
}
