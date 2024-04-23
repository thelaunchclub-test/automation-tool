package com.extent.reports.Main;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.extent.reports.extent.ExtentReport;
import com.extent.reports.extent.ExtentReportProvider;
import com.extent.reports.service.ReportProvider;
import com.extent.reports.spark.SparkReporter;
import com.extent.reports.test.Test;
import com.extent.reports.test.status.Status;

public class Main {

    public static ExtentReport report;

    public static void main(String[] args) {

        final SparkReporter sparkReporter = new SparkReporter("./reports.html");
        final ReportProvider reportProvider = new ExtentReportProvider();

        final ExtentReport report = reportProvider.getReport();

        sparkReporter.start();
        sparkReporter.setReportName("Twozo test");
        sparkReporter.setDocumentTitle("Twozo wins");
        sparkReporter.setTheme(Theme.STANDARD);
        Test test = report.createTest("SignInTest");
        test.createNodeWithName("passed test");
        test.createNodeWithNameAndDesc("failed test", "these are the failed tests");
        test.assignAuthor("Navin");
        test.assignCategory("testing");
        test.assignDevice("Dell");
        test.getLog().log(Status.INFO, "info");
        report.flush();
    }
}

