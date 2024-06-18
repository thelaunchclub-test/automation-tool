package com.twozo.extent.report.reporter.impl;

import com.aventstack.extentreports.ExtentTest;

import com.twozo.extent.report.reporter.AbstractExtentReporter;
import com.twozo.extent.report.reporter.Reporter;
import com.twozo.extent.report.reporter.SparkReporter;
import com.twozo.extent.report.service.ReportGenerator;
import com.twozo.extent.report.service.ReportService;
import com.twozo.extent.report.test.ReportTest;
import com.twozo.extent.report.test.ReportTestImpl;

/**
 * Provides various services for generating and managing reports.
 * Offers the service to retrieve and manipulate {@link ReportTest} and {@link ReportGenerator}.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see AbstractExtentReporter
 * @see ReportService
 */
public final class ExtentReporterImpl extends AbstractExtentReporter {

    private final ReportService reportService;

    public ExtentReporterImpl() {
        this.reportService = new ExtentReportServiceImpl();
    }

//
//    /**
//     * {@inheritDoc}
//     *
//     * @return A new {@link ExtentReporterImpl}.
//     */
//    @Override
//    public AbstractExtentReporter getReporter() {
//        return new ExtentReporterImpl();
//    }

    /**
     * {@inheritDoc}
     *
     * @param path The path where the report will be generated.
     * @return A new {@link AbstractExtentReporter} initialized with the provided path.
     */
    @Override
    protected AbstractExtentReporter getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@link ReportGenerator}
     */
    @Override
    public ReportGenerator getReport() {
        return reportService.getReport();
    }

//    @Override
//    public ReportTest getReportTest() {
//        return new ReportTestImpl(extentTest);
//    }
}