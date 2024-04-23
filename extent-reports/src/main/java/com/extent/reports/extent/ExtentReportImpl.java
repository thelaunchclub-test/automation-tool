package com.extent.reports.extent;

import com.aventstack.extentreports.ExtentTest;
import com.extent.reports.spark.SparkReporter;
import com.extent.reports.test.Test;
import com.extent.reports.test.TestersImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * extending the ExtentReport abstract class.
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
    protected ExtentReport getReporter(String path) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createTest(String name) {
        ExtentTest extentTest = reports.createTest(name);
        Test test = new TestersImpl(extentTest);
        testMapping.put(test, extentTest);
        return test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createTestWithDes(String name, String description) {
        ExtentTest extentTest = reports.createTest(name, description);
        Test test = new TestersImpl(extentTest);
        testMapping.put(test, extentTest);
        return test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeTest(Test test) {
        ExtentTest extentTest = testMapping.get(test);
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


