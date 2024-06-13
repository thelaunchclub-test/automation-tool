package com.twozo.extent.report.reporter;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * <p>
 * Allows different types of reports to be generated depending on the needs of the implementing class.
 * Ensures that the method {@link #getReporter()} can return any type
 * of report, whether it be a simple string, a complex object, or any other form.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 */
public interface Reporter<T extends AbstractExtentReporter> {
    T getReporter();

    ExtentSparkReporter getExtentSparkReporter();
}
