package com.twozo.extent.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.twozo.extent.reports.spark.SparkReporter;
import com.twozo.extent.reports.service.ExtentReporterService;
import com.twozo.extent.reports.test.ReportTest;
import com.twozo.extent.reports.test.ReportTestImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Serves as a base class for custom report generation using ExtentReports library.
 *
 * <p>
 * This class encapsulates the core functionality for report generation,
 * including test creation, test removal, attaching reporters, and flushing reports.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ExtentReporterService
 * @see ExtentReports
 */
public abstract class AbstractExtentReporter implements ExtentReporterService {

    protected final ExtentReports reports;
    protected final Map<ReportTest, ExtentTest> test;

    protected AbstractExtentReporter() {
        this.reports = new ExtentReports();
        this.test = new HashMap<>();
    }

    /**
     * Attaches a SparkReporter instance to the reports object.
     *
     * @param reporters The SparkReporter instance to attach.
     */
    public void attachReporter(final SparkReporter... reporters) {

        for (final SparkReporter reporter : reporters) {
            reports.attachReporter(reporter.getExtentSparkReporter());
        }
    }

    /**
     * Flushes the ExtentReports instance to write all logs and close the report.
     */
    public void flush() {
        reports.flush();
    }

    /**
     * Sets system information in the test reports.
     *
     * @param key   The key representing the type of system information (e.g., "Browser Version").
     * @param value The corresponding value of the system information (e.g., "Chrome 98").
     */
    public void SystemInfo(final String key, final String value) {
        reports.setSystemInfo(key, value);
    }

    /**
     * Creates a new test with the provided name and associates it with a custom Test object.
     *
     * @param name The name of the test.
     * @return A custom Test object representing the newly created test.
     */
    public ReportTest createTest(final String name) {
        final ExtentTest extentTest = reports.createTest(name);
        final ReportTest test = new ReportTestImpl(extentTest);

        this.test.put(test, extentTest);

        return test;
    }

    /**
     * Creates a new test with the provided name and description, associating it with a custom Test object.
     *
     * @param name        The name of the test.
     * @param description The description of the test.
     * @return A custom Test object representing the newly created test.
     */
    public ReportTest createTest(final String name, final String description) {
        final ExtentTest extentTest = reports.createTest(name, description);
        final ReportTest test = new ReportTestImpl(extentTest);

        this.test.put(test, extentTest);

        return test;
    }

    /**
     * Removes a custom Test object from the report.
     *
     * @param test The custom Test object to remove.
     */
    public void removeTest(final ReportTest test) {
        final Map<ReportTest, ExtentTest> reporter = this.test;

        if (reporter.containsKey(test)) {
            final ExtentTest extentTest = reporter.get(test);

            reports.removeTest(extentTest);
            reporter.remove(test);
        }
    }

    /**
     * Abstract method to obtain a default reporter instance.
     *
     * @return An instance of ExtentReport.
     */
    protected AbstractExtentReporter getReporter() {
        return null;
    }

    /**
     * Subclasses must implement this method to create and return the appropriate ExtentReporter.
     *
     * @param path The path where the report will be generated.
     * @return An instance of ExtentReporter configured to generate reports at the specified path.
     */
    protected abstract AbstractExtentReporter getReporter(final String path);
}