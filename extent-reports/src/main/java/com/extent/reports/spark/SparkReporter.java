package com.extent.reports.spark;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.extent.reports.extent.ExtentReport;
import com.extent.reports.test.Test;
import lombok.Getter;

import java.io.IOException;

import static com.extent.reports.Main.Main.report;

/**
 * Provides functionalities for Spark reporting.
 */
@Getter
public class SparkReporter extends ExtentReport {

    private final ExtentSparkReporter extentSparkReporter;

    public SparkReporter(final String path) {
        super();
        this.extentSparkReporter = new ExtentSparkReporter(path);
    }

    /**
     * Loads the XML configuration from the specified path.
     *
     * @param xmlPath The path to the XML configuration file.
     * @throws IOException If there is an issue loading the XML configuration.
     */
    public void loadXMLConfig(String xmlPath) throws IOException {
        extentSparkReporter.loadXMLConfig(xmlPath);
    }

    /**
     * Sets the document title for the report.
     *
     * @param title The title to set.
     */
    public void setDocumentTitle(final String title) {
        extentSparkReporter.config().setDocumentTitle(title);
    }

    /**
     * Sets the report name for the report.
     *
     * @param reportName The report name to set.
     */
    public void setReportName(final String reportName) {
        extentSparkReporter.config().setReportName(reportName);
    }

    /**
     * Sets the theme for the report.
     *
     * @param theme The theme to set.
     */
    public void setTheme(final Theme theme) {
        extentSparkReporter.config().setTheme(theme);
    }

    /**
     * Attaches the SparkReporter to the ExtentReports instance.
     */
    public void start() {
        reports.attachReporter(extentSparkReporter);
    }

    /**
     * Flushes the ExtentReports instance to write the report.
     */
    public void stop() {
        reports.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test getTest() {
        return report.getTest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReport getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReport getReporter() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReport getReporter(SparkReporter reporter) {
        return new SparkReporter(reporter.toString());
    }

    /**
     * Returns the ExtentSparkReporter instance for reporting.
     *
     * @return An ExtentSparkReporter instance.
     */
    public ExtentSparkReporter getReport() {
        return extentSparkReporter;
    }
}




