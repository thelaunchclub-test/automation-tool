package com.extent.reports.extent.spark;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.extent.reports.extent.ExtentReportBuilder;
import com.extent.reports.extent.ExtentReportBuilderImpl;
import com.extent.reports.service.ReportGenerator;
import com.extent.reports.test.Test;

import lombok.Getter;

import java.io.IOException;

/**
 * The {@code SparkReporter} class extends the {@code ExtentReport} class
 * to provide a custom reporter implementation using ExtentSparkReporter
 * for generating reports with enhanced features.
 *
 * <p>
 * This class encapsulates the functionality to configure and generate
 * reports using the ExtentSparkReporter library.
 * </p>
 *
 * @version 1.1
 * @Author Navin Jones
 * @see ExtentReportBuilder
 */
@Getter
public class SparkReporter extends ExtentReportBuilder {


    private final ExtentSparkReporter extentSparkReporter;

    private ExtentReportBuilderImpl report;

    private SparkReporter sparkReporter;

    /**
     * Constructs a new SparkReporter with the specified path.
     *
     * @param path The path to the report file.
     */
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
    public void loadXMLConfig(final String xmlPath) throws IOException {
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
     *
     * @see Test
     */
    @Override
    public Test getTest() {
        return report.getTest();
    }

    @Override
    protected ExtentReportBuilder getReporter() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ExtentReportBuilder getReporter(final String path) {
        return new SparkReporter(path);
    }

    /**
     * {@inheritDoc}
     *
     * @see ReportGenerator
     */
    public ReportGenerator getReport() {
        return new ExtentReportBuilderImpl();
    }
}





