package com.twozo.extent.report.reporter.service;

import com.twozo.extent.report.reporter.util.PropertyReader;

import com.twozo.extent.report.reporter.internal.extent.AbstractExtentReporter;
import com.twozo.extent.report.reporter.internal.extent.ExtentReporterImpl;

import com.twozo.extent.report.reporter.model.ExtentReportType;
import com.twozo.extent.report.reporter.model.ReportType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * Creates and select appropriate reporter based on the specified types.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see ReportService
 */
public final class ReporterFactory implements ReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReporterFactory.class);

    /**
     * <p>
     * Creates an {@link Reporter} based on the given {@link ExtentReportType}.
     * </p>
     *
     * @param type Type of {@link Reporter} to create.
     * @return     A new {@link AbstractExtentReporter}.
     */
    private static Reporter createReporter(final ExtentReportType type) {

        switch (type) {
            case SPARK, KLOV, AVENT, EMAIL -> {
                return new ExtentReporterImpl();
            }
            default -> {
                String errorMessage = "ReporterFactory : Unknown reporter type" + type;
                LOGGER.error(errorMessage);
                throw new IllegalArgumentException("Unknown reporter type: " + type);
            }
        }
    }

    /**
     * <p>
     * Selects the appropriate {@link ReportService} based on the given ReportType.
     * </p>
     *
     * @param reportType The type of {@link ReportService} to select.
     */
    private static void selectReporter(final ReportType reportType) {

        switch (reportType) {
            case EXTENT_REPORT -> new ExtentReporterImpl();
            case TESTNG_REPORTER, JUNIT_REPORTER, CALLIOPE_PRO -> {
                LOGGER.error("ReporterFactory : Reporter not implemented yet");
                throw new UnsupportedOperationException("Reporter not implemented yet");
            }
        }
    }

    /**
     * <p>
     * Chooses the appropriate {@link ReportService} based on the given {@link ReportType}.
     * </p>
     *
     * @param reportType The type of {@link ReportService} to choose.
     */
    public static void chooseReporter(final ReportType reportType) {
        selectReporter(reportType);
    }

    /**
     * <p>
     * Creates a default {@link ExtentReportType} reporter.
     * </p>
     *
     * @return A new {@link AbstractExtentReporter}.
     */
    @Override
    public Reporter createReporter() {
        createReporter(get());

        return createReporter();
    }

    /**
     * <p>
     * Retrieves the {@link ExtentReportType} from the properties file.
     * </p>
     *
     * @return The {@link ExtentReportType} value based on the 'extentReportType' property.
     */
    private static ExtentReportType get() {

        try {
            final Map<String, String> properties = PropertyReader.get("ReportConfig.properties");
            final String reportType = properties.get("extentReportType");

            if (Objects.nonNull(reportType) && reportType.equalsIgnoreCase("SPARK")) {
                return ExtentReportType.SPARK;
            } else {
                throw new IllegalArgumentException("Invalid or missing extentReportType in properties file.");
            }
        } catch (IOException exception) {
            LOGGER.error("Spark : Failed to read property File {}" , exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    /**
     * Retrieves the {@link ReportType} from the properties file.
     *
     * @return The {@link ReportType} enum value based on the 'report' property.
     */
    public static ReportType getReport() {

        try {
            final Map<String, String> properties = PropertyReader.get("ReportConfig.properties");
            final String reportType = properties.get("report");

            if (Objects.nonNull(reportType) && reportType.equalsIgnoreCase("EXTENT_REPORT")) {
                return ReportType.EXTENT_REPORT;
            } else {
                throw new IllegalArgumentException("Invalid or missing extentReportType in properties file.");
            }
        } catch (IOException exception) {
            LOGGER.error("Reporter factory : Failed to read properties file" , exception);
            throw new RuntimeException("Failed to read properties file.", exception);
        }
    }

    /**
     * Creates a default {@link ExtentReportType}.
     *
     * @return A new {@link ExtentReporterImpl} for {@link ExtentReportType}.
     */
    public static Reporter selectReporter() {
        chooseReporter(getReport());

        return createReporter(get());
    }
}