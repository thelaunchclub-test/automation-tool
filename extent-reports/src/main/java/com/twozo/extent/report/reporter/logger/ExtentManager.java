package com.twozo.extent.report.reporter.logger;

import com.aventstack.extentreports.ExtentTest;
import com.twozo.extent.report.test.internal.ReportTestImpl;
import com.twozo.extent.report.test.service.ReportTest;

/**
 * A utility class responsible for providing instances of ReportTest.
 * This class follows the singleton pattern by having a private constructor to prevent instantiation.
 * It provides a static method to wrap an ExtentTest instance with a ReportTest implementation.
 */
public class ExtentManager {

    /**
     * Private constructor to prevent instantiation.
     * This class is not meant to be instantiated since it only provides static utility methods.
     */
    private ExtentManager() {

    }

    /**
     * Returns a new instance of ReportTestImpl that wraps the provided ExtentTest.
     * This method acts as a factory to create a ReportTest object from the given ExtentTest.
     *
     * @param extentTest The ExtentTest instance that needs to be wrapped.
     * @return A new instance of ReportTestImpl wrapping the provided ExtentTest.
     */
    static ReportTest getReportTest(final ExtentTest extentTest) {
        return new ReportTestImpl(extentTest);
    }
}

