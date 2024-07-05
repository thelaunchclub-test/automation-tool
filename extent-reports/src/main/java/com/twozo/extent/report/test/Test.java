package com.twozo.extent.report.test;

import com.twozo.extent.report.reporter.model.Styles;
import com.twozo.extent.report.reporter.service.ReporterFactory;
import com.twozo.extent.report.reporter.internal.spark.SparkReporter;
import com.twozo.extent.report.reporter.model.ExtentReportType;
import com.twozo.extent.report.reporter.service.Reporter;
import com.twozo.extent.report.test.service.ReportTest;

public class Test {
    public static void main(String[] args) {
        final Reporter reporter = ReporterFactory.selectReporter();
        final SparkReporter sparkReporter = new SparkReporter("./new Report.html");

        reporter.attachReporter(sparkReporter);

        sparkReporter.setTheme(Styles.DARK);
        final ReportTest reportTest = reporter.createTest("SignIn");
        reportTest.getNode().createNode("Node created successfully");
        reporter.flush();
    }
}
