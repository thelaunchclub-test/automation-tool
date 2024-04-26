package com.extent.reports.extent;

import com.aventstack.extentreports.ExtentTest;

import com.extent.reports.extent.spark.SparkReporter;
import com.extent.reports.service.ReportGenerator;
import com.extent.reports.test.Test;
import com.extent.reports.test.TestService;


/**
 * Provides a concrete implementation of the report generation functionalities
 * using the ExtentReports library.
 *
 * <p>
 * This class encapsulates methods for creating, managing, and removing test
 * instances, as well as retrieving test and report instances.
 * </p>
 *
 * @see ExtentReportBuilder
 *
 * @Author Navin Jones
 * @version 1.1
 */
public final class ExtentReportBuilderImpl extends ExtentReportBuilder {

    private final ExtentReportServiceImpl reportService;
    private ExtentTest extentTest ;

    public ExtentReportBuilderImpl() {
        reportService = new ExtentReportServiceImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReportBuilder getReporter() {
        return new ExtentReportBuilderImpl();
    }

    @Override
    protected ExtentReportBuilder getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test getTest() {
        return new TestService(extentTest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportGenerator getReport() {
        return reportService.getReport();
    }
}


