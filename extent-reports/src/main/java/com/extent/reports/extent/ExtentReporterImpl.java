package com.extent.reports.extent;

import com.aventstack.extentreports.ExtentTest;

import com.extent.reports.extent.spark.SparkReporter;
import com.extent.reports.service.ReportGenerator;
import com.extent.reports.test.ReportTest;
import com.extent.reports.test.ReportTestImpl;


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
     *
     * @return A new ExtentReporterImpl instance.
     */
    @Override
    protected AbstractExtentReporter getReporter() {
        return new ExtentReporterImpl();
    }

    /**
     * {@inheritDoc}
     *
     * @param path The path where the report will be generated.
     * @return A new SparkReporter instance initialized with the provided path.
     */
    @Override
    protected AbstractExtentReporter getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * {@inheritDoc}
     *
     * @return A new ReportTestImpl instance with ExtentTest.
     */
    @Override
    public ReportTest getTest() {
        return new ReportTestImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @return The ReportGenerator method obtained from the reportService.
     */
    @Override
    public ReportGenerator getReport() {
        return reportService.getReport();
    }
}


