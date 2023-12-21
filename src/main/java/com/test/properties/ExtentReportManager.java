package com.test.properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.constants.Constants;

/**
 * Generate a detailed execution report at the end of each test execution
 * Create HTML file for the Extent report.
*/
public class ExtentReportManager {
    
    // The method will return the object of the Extent report
    public static ExtentReports setupExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Constants.EXECUTION_REPORT_PATH);
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }
}
