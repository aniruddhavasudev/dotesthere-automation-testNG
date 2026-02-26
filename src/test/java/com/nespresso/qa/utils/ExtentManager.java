package com.nespresso.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportDir = System.getProperty("user.dir") + File.separator + "reports";
            String reportPath = reportDir + File.separator + "ExtentReport.html";

            // Create reports folder if not exists
            new File(reportDir).mkdirs();

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            System.out.println("Extent report location: " + reportPath);
        }

        return extent;
    }
}