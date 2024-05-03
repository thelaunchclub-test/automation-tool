package com.extent.reports.test;

import com.extent.reports.extent.AbstractExtentReporter;
import com.extent.reports.extent.spark.SparkReporter;
import com.extent.reports.service.ReportGenerator;
import com.extent.reports.service.ReportService;

public class Main {
    public static void main(String[] args) {
        final ReportService reportService = ReportGenerator.getInstance();
        final AbstractExtentReporter extentReportBuilder = (AbstractExtentReporter) reportService.getReport();
        final SparkReporter sparkReporter = new SparkReporter("./extent-reports.html");

        extentReportBuilder.attachReporter(sparkReporter);

        final TestFunction test1 = extentReportBuilder.createTest("signIn").getTabs().assignAuthor("Navin");
        test1.LogPass("test is passed");
//        extentReportBuilder.removeTest(test1);
        test1.getNode().createNode("Failed", "This is failed test").LogPass("Passed");
        final TestFunction test2 = extentReportBuilder.createTest("SignUp");
        test2.LogInfo("Contacts list");
        test2.getTabs().assignAuthor("Jones");

        extentReportBuilder.flush();
//        test1.getLog().log(Status.SKIP, "Test is skipped");
//
//        final Test test2 = extentReportBuilder.createTest("SignUp");
//        test2.getTabs().assignAuthor("Navin Jones");

        }
}
