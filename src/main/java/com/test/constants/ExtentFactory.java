package com.test.constants;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.test.driver.DriverFactory;

/**
 * This class will contain a lot of reusable methods such as to create an Extent test, add different steps to the test case, and add application screenshot
*/
public class ExtentFactory {
    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    // Singleton design pattern
    private ExtentFactory() {
        // private constructor so that you cannot create the object of this class anywhere else
    }

    private static ExtentFactory extentFactoryInstance = new ExtentFactory();

    public static ExtentFactory getInstance() {
        return extentFactoryInstance;
    }

    public void setExtent(ExtentTest extentTestObject) {
        extent.set(extentTestObject);
    }

    public ExtentTest getExtentTest() {
        return extent.get();
    }

    public void removeTest() {
        extent.remove();
    }

    public static String captureApplicationScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriverFactoryInstance().getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        byte[] fileContent = null;
        try {
            fileContent = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static void clickPass(String btn) {
        getInstance().getExtentTest().pass(btn + " button is clicked.");
    }

    public static void clickFail(String btn) {
        getInstance().getExtentTest().fail("error occurred while clicking on '" + btn + "'' button.");
    }

    public static void sendKeysPass(String value, String elementName) {
        getInstance().getExtentTest().pass(value + " is entered in " + elementName);
    }

    public static void sendKeysFail(String value, String elementName) {
        getInstance().getExtentTest()
                .pass("error occurred while entering '" + value + "'' in text box '" + elementName + "'");
    }
    
    public static void passTest(String message) {
        getInstance().getExtentTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }
    
    public static void failTest(String message) {
        getInstance().getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(captureApplicationScreenshot()).build());
    }
}
