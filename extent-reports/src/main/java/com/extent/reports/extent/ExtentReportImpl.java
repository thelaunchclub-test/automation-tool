package com.extent.reports.extent;

import com.aventstack.extentreports.ExtentTest;

import com.extent.reports.spark.SparkReporter;
import com.extent.reports.test.Test;
import com.extent.reports.test.TestersImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * extending the ExtentReport abstract class.
 * @see ExtentReport
 */
public class ExtentReportImpl extends ExtentReport {

    private final Map<Test, ExtentTest> testMapping = new HashMap<>();

    private ExtentTest test;

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReport getReporter() {
        return new ExtentReportImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReport getReporter(final String path) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createTest(final String name) {
        final ExtentTest extentTest = reports.createTest(name);
        final Test test = new TestersImpl(extentTest);

        testMapping.put(test, extentTest);

        return test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createTestWithDes(final String name, final String description) {
        final ExtentTest extentTest = reports.createTest(name, description);
        final Test test = new TestersImpl(extentTest);

        testMapping.put(test, extentTest);

        return test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeTest(final Test test) {
        final ExtentTest extentTest = testMapping.get(test);

        if (extentTest != null) {
            reports.removeTest(extentTest);
            testMapping.remove(test);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReport getReporter(final SparkReporter reporter) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test getTest() {
        return new TestersImpl(test);
    }
}


