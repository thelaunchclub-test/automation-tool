package com.extent.reports.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.extent.reports.service.Reporter;
import com.extent.reports.spark.SparkReporter;
import com.extent.reports.test.Test;
import com.extent.reports.test.TestersImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * represents the Extent report functionality.
 * Implements the Reporter interface.
 */
public abstract class ExtentReport implements Reporter {

    protected static ExtentReports reports;
    private final Map<Test, com.aventstack.extentreports.model.Test> testMapping = new HashMap<>();

    protected ExtentReport() {
        reports = new ExtentReports();
    }

    /**
     * Attaches a SparkReporter to the ExtentReports instance.
     *
     * @param reporter The SparkReporter to attach.
     */
    public void attachReporter(final SparkReporter reporter) {
        reports.attachReporter(reporter.getReport());
    }

    /** Flushes the ExtentReports instance to write the report. */
    public void flush() {
        reports.flush();
    }

    /**
     * Abstract method to get a reporter instance with a specified path.
     *
     * @param path The path to set for the reporter.
     * @return An instance of ExtentReport.
     */
    protected abstract ExtentReport getReporter(final String path);

    /**
     * Creates a new test with the given name.
     *
     * @param name The name of the test.
     * @return A custom Test object representing the test.
     */
    public Test createTest(String name) {
        final ExtentTest extentTest = reports.createTest(name);
        final Test test = new TestersImpl(extentTest);
        testMapping.put(test, extentTest.getModel());
        return test;
    }

    /**
     * Creates a new test with the given name and description.
     *
     * @param name        The name of the test.
     * @param description The description of the test.
     * @return A custom Test object representing the test.
     */
    public Test createTestWithDes(String name, String description) {
        final ExtentTest extentTest = reports.createTest(name, description);
        final Test test = new TestersImpl(extentTest);
        testMapping.put(test, extentTest.getModel());
        return test;
    }

    /**
     * Removes a test from the reports.
     *
     * @param test The custom Test object to remove.
     */
    public void removeTest(final Test test) {
        com.aventstack.extentreports.model.Test extentTest = testMapping.get(test);
        if (extentTest != null) {
            reports.removeTest(String.valueOf(extentTest));
            testMapping.remove(test);
        }
    }

    /**
     * Abstract method to get a default reporter instance.
     *
     * @return An instance of ExtentReport.
     */
    protected abstract ExtentReport getReporter();

    /**
     * Abstract method to get a reporter instance with a SparkReporter.
     *
     * @param reporter The SparkReporter to attach.
     * @return An instance of ExtentReport.
     */
    protected abstract ExtentReport getReporter(final SparkReporter reporter);

