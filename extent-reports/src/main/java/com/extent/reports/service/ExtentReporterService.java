package com.extent.reports.service;

import com.extent.reports.test.ReportTest;

/**
 * Provides methods for reporting test results and generating reports.
 * It defines a contract for classes that implement reporting functionalities.
 *
 * <p>
 * This interface declares a method to retrieve a {@link ReportTest} object
 * representing the current test context for reporting purposes.
 * Implementing classes should provide an implementation for this method
 * to return a Test object that encapsulates the current test's details
 * and provides methods for reporting test steps and results.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ReportGenerator
 * @see ReportTest
 */
public interface ExtentReporterService extends ReportGenerator {

    /**
     * Returns a {@link ReportTest} object representing the current test context
     * for reporting purposes.
     *
     * <p>
     * Implementing classes should provide an implementation for this method
     * to return a Test object that encapsulates the current test's details
     * and provides methods for reporting test steps and results.
     * </p>
     *
     * @return A {@link ReportTest} object representing the current test.
     * @see ReportTest
     */
    ReportTest getTest();
}