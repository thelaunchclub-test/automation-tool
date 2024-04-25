package com.extent.reports.extent;

import com.aventstack.extentreports.ExtentTest;

import com.extent.reports.extent.spark.SparkReporter;
import com.extent.reports.service.ReportGenerator;
import com.extent.reports.test.Test;
import com.extent.reports.test.TestService;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code ExtentReportBuilderImpl} class extends the {@code ReportBuilder} class
 * to provide a concrete implementation of the report generation functionalities
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

    private final Map<Test, ExtentTest> test = new HashMap<>();

    private ExtentTest extentTest ;
    private final ExtentReportServiceImpl reportService = new ExtentReportServiceImpl();

    public ExtentReportBuilderImpl() {
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
    public Test createTest(final String name) {
        final ExtentTest extentTest = reports.createTest(name);
        final Test test = new TestService(extentTest);

        this.test.put(test, extentTest);

        return test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createTestWithDes(final String name, final String description) {
        final ExtentTest extentTest = reports.createTest(name, description);
        final Test test = new TestService(extentTest);

        this.test.put(test, extentTest);

        return test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeTest(final Test test) {
        final ExtentTest extentTest = this.test.get(test);

        if (extentTest != null) {
            reports.removeTest(extentTest);
            this.test.remove(test);
        }
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


