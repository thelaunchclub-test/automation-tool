package com.twozo.extent.report.reporter.internal.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.twozo.extent.report.reporter.logger.ExtentLogger;
import com.twozo.extent.report.reporter.internal.spark.SparkReporter;
import com.twozo.extent.report.reporter.model.ExtentReportType;
import com.twozo.extent.report.reporter.service.Reporter;
import com.twozo.extent.report.test.internal.ReportTestImpl;
import com.twozo.extent.report.test.service.ReportTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Provides the core functionalities for managing reports and test executions.
 * Decides which Reporter and tests are executed.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>Attaches {@link SparkReporter}</li>
 *     <li>Sets system information.</li>
 *     <li>Creates and manages {@link ReportTest}</li>
 *     <li>Flushes the report to write logs and close the report.</li>
 * </ul>
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see Reporter
 */
public abstract class AbstractExtentReporter implements Reporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractExtentReporter.class);
    protected final ExtentReports reports;

    protected AbstractExtentReporter() {
        reports = new ExtentReports();
    }

    /**
     * {@inheritDoc}
     *
     * @param reporters The {@link ExtentReportType}
     */
    @Override
    public void attachReporter(final Reporter... reporters) {

        for (final Reporter reporter : reporters) {
            reports.attachReporter(reporter.getExtentSparkReporter());
            LOGGER.info("AbstractExtentReporter : The Report was Attached successfully {}", reporter);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flush() {
        reports.flush();
    }

    /**
     * {@inheritDoc}
     *
     * @param name The Name of the {@link ReportTest}.
     * @return     The newly created {@link ReportTest}.
     */
    @Override
    public ReportTest createTest(final String name) {
        final ExtentTest extentTest = reports.createTest(name);

        ExtentLogger.getInstance().setExtentTest(extentTest);

        return new ReportTestImpl(extentTest);
    }

    /**
     *{@inheritDoc}
     *
     * @param name        The Name of the {@link ReportTest}.
     * @param description The description of the {@link ReportTest}.
     * @return            The newly created test.
     */
    @Override
    public ReportTest createTest(final String name, final String description) {
        final ExtentTest extentTest = reports.createTest(name, description);

        return new ReportTestImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @param key   The type of system information (e.g., "Browser Version").
     * @param value The corresponding value of the system information (e.g., "Chrome 98").
     */
    @Override
    public void systemInfo(final String key, final String value) {
        reports.setSystemInfo(key, value);
    }

    /**
     * {@inheritDoc}
     * 
     * @return The {@link ExtentSparkReporter}
     */
    @Override
    public ExtentSparkReporter getExtentSparkReporter() {
        return getExtentSparkReporter();
    }
}