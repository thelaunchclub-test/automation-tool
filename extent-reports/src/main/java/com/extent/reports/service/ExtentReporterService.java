package com.extent.reports.service;

import com.extent.reports.test.TestOperation;

/**
 * Provides methods for reporting test results and generating reports.
 * It defines a contract for classes that implement reporting functionalities.
 *
 * <p>
 * This interface declares a method to retrieve a {@link TestOperation} object
 * representing the current test context for reporting purposes.
 * Implementing classes should provide an implementation for this method
 * to return a Test object that encapsulates the current test's details
 * and provides methods for reporting test steps and results.
 * </p>
 *
 * @see ReportGenerator
 * @see TestOperation
 *
 * @Author Navin Jones
 * @version 1.1
 */
public interface ExtentReporterService extends ReportGenerator {

    /**
     * Returns a {@link TestOperation} object representing the current test context
     * for reporting purposes.
     *
     * <p>
     * Implementing classes should provide an implementation for this method
     * to return a Test object that encapsulates the current test's details
     * and provides methods for reporting test steps and results.
     * </p>
     *
     * @return A {@link TestOperation} object representing the current test.
     *
     * @see TestOperation
     */
    TestOperation getTest();
}



