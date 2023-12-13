package com.nopcommerce.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestClass {

    @Test
    public void extentTest() throws IOException {

        // Create the object of ExtentReport
        ExtentReports reports = new ExtentReports();
        // Spark Reporter
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");// html file will be generated
        //Report Theme, Report Title, Report Name
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Nope commerce");
        spark.config().setDocumentTitle("Automation");

        //Attach the spark to Report
        reports.attachReporter(spark);

        // Add System Information
        reports.setSystemInfo("OS",System.getProperty("os.name"));
        reports.setSystemInfo("Java version",System.getProperty("java.version"));
        reports.setSystemInfo("Browser","Chrome");
        reports.setSystemInfo("Browser Version","119.1.2");

        //Create the Test
        ExtentTest test = reports.createTest("Login Test").assignAuthor("Chetan").assignCategory("Smoke");
        test.pass("Login Test start Successfully");
        test.info("Url is Loaded");
        test.info("Values entered ");
        test.pass("Login test completed successfully");
        //How to Highlight the Step
        test.pass(MarkupHelper.createLabel("Login test completed successfully", ExtentColor.GREEN));

        ExtentTest test1 = reports.createTest("HomePage Test").assignAuthor("Prime").assignCategory("Sanity");
        test1.pass("HomePage Test start Successfully");
        test1.info("Url is Loaded");
        test1.info("Values entered ");
        test1.pass("HomePage test completed successfully");
        //How to Highlight the Step
        test1.fail(MarkupHelper.createLabel("HomePage test completed successfully",ExtentColor.RED));

        reports.flush(); // Unless you can call this method report will not be written the logs
        Desktop.getDesktop().browse(new File("extent.html").toURI());// This will open the file in the Desktop Default browser
    }
}
