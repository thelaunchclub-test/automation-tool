package com.extent.reports.extent.spark;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.extent.reports.extent.AbstractExtentReporter;
import com.extent.reports.extent.ExtentReporterImpl;
import com.extent.reports.service.ExtentReporterService;
import com.extent.reports.service.ReportGenerator;
import com.extent.reports.test.ReportTest;

import lombok.Getter;

import java.io.IOException;

/**
 * Provides a custom reporter implementation using ExtentSparkReporter
 * for generating reports with enhanced features.
 *
 * <p>
 * This class encapsulates the functionality to configure and generate
 * reports using the ExtentSparkReporter library.
 * </p>
 *
 * @version 1.1
 * @Author Navin Jones
 * @see AbstractExtentReporter
 */
@Getter
public final class SparkReporter extends AbstractExtentReporter {

    private final ExtentSparkReporter extentSparkReporter;
    private ExtentReporterService report;

    public SparkReporter(final String path) {
        super();
        this.extentSparkReporter = new ExtentSparkReporter(path);
    }

    /**
     * Loads the XML configuration file from the specified path and configures the ExtentSparkReporter.
     * This method attempts to load the XML configuration file from the provided path and configures
     * the ExtentSparkReporter accordingly. It handles IOException if encountered during the process.
     *
     * @param xmlPath The path to the XML configuration file.
     */
    public void loadXMLConfig(final String xmlPath) {
        try {
            extentSparkReporter.loadXMLConfig(xmlPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the configuration settings for the ExtentSparkReporter.
     * Delegates the call to the config() method of the ExtentSparkReporter instance.
     *
     * @return ExtentSparkReporterConfig object containing the configuration settings.
     */
    public ExtentSparkReporterConfig config() {
        return extentSparkReporter.config();
    }

    /**
     * Sets the document title for the report.
     *
     * @param title The title to set.
     */
    public void setDocumentTitle(final String title) {
        config().setDocumentTitle(title);
    }

    /**
     * Sets the report name for the report.
     *
     * @param reportName The report name to set.
     */
    public void setReportName(final String reportName) {
        config().setReportName(reportName);
    }

    /**
     * Sets the theme for the report.
     *
     * @param theme The theme to set.
     */
    public void setTheme(final Theme theme) {
        config().setTheme(theme);
    }

    /**
     * Attaches the SparkReporter to the ExtentReports instance.
     */
    public void attach() {
        reports.attachReporter(extentSparkReporter);
    }

    /**
     * Flushes the ExtentReports instance to write the report.
     */
    public void save() {
        reports.flush();
    }

    /**
     * {@inheritDoc}
     *
     * @return The ReportTest instance representing the current test context.
     * @see ReportTest
     */
    @Override
    public ReportTest getTest() {
        return report.getTest();
    }

    /**
     * {@inheritDoc}
     *
     * @param path The file path used to initialize the SparkReporter instance.
     * @return An AbstractExtentReporter instance, specifically a SparkReporter object, initialized with the provided path.
     */
    @Override
    protected AbstractExtentReporter getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * Obtains a ReportGenerator instance.
     * This method instantiates a new instance of ExtentReporterImpl, a concrete implementation
     * of the ReportGenerator interface, and returns it.
     *
     * @return A ReportGenerator instance, specifically an instance of ExtentReporterImpl.
     */
    public ReportGenerator getReport() {
        return new ExtentReporterImpl();
    }
}