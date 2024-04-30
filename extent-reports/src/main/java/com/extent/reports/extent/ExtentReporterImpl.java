package com.extent.reports.extent;

import com.aventstack.extentreports.ExtentTest;

import com.extent.reports.extent.spark.SparkReporter;
import com.extent.reports.service.ReportGenerator;
import com.extent.reports.test.TestOperation;
import com.extent.reports.test.TestOperationImpl;


/**
 * Provides a concrete implementation of the report generation functionalities
 * using the ExtentReports library.
 *
 * <p>
 * This class encapsulates methods for creating, managing, and removing test
 * instances, as well as retrieving test and report instances.
 * </p>
 *
 * @see AbstractExtentReporter
 *
 * @Author Navin Jones
 * @version 1.1
 */
public final class ExtentReporterImpl extends AbstractExtentReporter {

    private final ExtentReportServiceImpl reportService;
    private ExtentTest extentTest;

    public ExtentReporterImpl() {
        this.reportService = new ExtentReportServiceImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbstractExtentReporter getReporter() {
        return new ExtentReporterImpl();
    }

    @Override
    protected AbstractExtentReporter getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestOperation getTest() {
        return new TestOperationImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportGenerator getReport() {
        return reportService.getReport();
    }
}


