package com.extent.reports.service;

import com.extent.reports.test.TestFunction;

/**
 * Provides methods for reporting test results and generating reports.
 * It defines a contract for classes that implement reporting functionalities.
 *
 * <p>
 * This interface declares a method to retrieve a {@link TestFunction} object
 * representing the current test context for reporting purposes.
 * Implementing classes should provide an implementation for this method
 * to return a Test object that encapsulates the current test's details
 * and provides methods for reporting test steps and results.
 * </p>
 *
 * @see ReportGenerator
 * @see TestFunction
 *
 * @Author Navin Jones
 * @version 1.1
 */
public interface ExtentReporterService extends ReportGenerator {

    /**
     * Returns a {@link TestFunction} object representing the current test context
     * for reporting purposes.
     *
     * <p>
     * Implementing classes should provide an implementation for this method
     * to return a Test object that encapsulates the current test's details
     * and provides methods for reporting test steps and results.
     * </p>
     *
     * @return A {@link TestFunction} object representing the current test.
     *
     * @see TestFunction
     */
    TestFunction getTest();
}



