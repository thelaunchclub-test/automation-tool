package com.twozo.extent.report.reporter.service;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.extent.report.reporter.error.code.ExtentReportErrorCode;
import com.twozo.extent.report.reporter.util.PropertyReader;

import com.twozo.extent.report.reporter.internal.extent.ExtentReporterInitializer;

import com.twozo.extent.report.reporter.model.ExtentReportType;
import com.twozo.extent.report.reporter.model.ReportType;

import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static com.twozo.extent.report.reporter.internal.extent.ExtentReporterInitializer.map;

/**
 * <p>
 * Creates and select appropriate reporter based on the specified types.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see ReporterService
 */
@Value
public class ReporterFactory implements ReporterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReporterFactory.class);
    private static final String FILENAME = "ReportConfig.properties";
    private static final String REPORTER = "report";
    private static final String EXTENT_REPORT = "EXTENT_REPORT";

    /**
     * <p>
     * Selects the appropriate {@link ReporterService} based on the given ReportType.
     * </p>
     *
     * @param reportType The type of {@link ReporterService} to select.
     */
    private static Reporter selectReporter(final ReportType reportType) {

        return switch (reportType) {
            case EXTENT_REPORT -> ExtentReporterInitializer.createReporter();
            case TESTNG_REPORTER, JUNIT_REPORTER, CALLIOPE_PRO -> {
                LOGGER.error("ReporterFactory : Reporter not implemented yet");
                throw new UnsupportedOperationException("Reporter not implemented yet");
            }
        };
    }

    /**
     * Retrieves the {@link ReportType} from the properties file.
     *
     * @return The {@link ReportType} enum value based on the 'report' property.
     */
    public static ReportType getReport() {

        try {
            final Map<String, String> properties = PropertyReader.get(FILENAME);
            final String reportType = properties.get(REPORTER);

            if (Objects.nonNull(reportType) && reportType.equalsIgnoreCase(EXTENT_REPORT)) {
                return ReportType.EXTENT_REPORT;
            } else {
                LOGGER.error("ReporterFactory : Invalid or missing extentReportType in properties file");
                throw ErrorCode.get(ExtentReportErrorCode.INVALID_REPORTER);
            }
        } catch (IOException exception) {
            LOGGER.error("Reporter factory : Failed to read properties file {}" , exception.getMessage());
            throw ErrorCode.get(ExtentReportErrorCode.FILE_NOT_FOUND);
        }
    }

    /**
     * Creates a default {@link ExtentReportType}.
     *
     * @return A new {@link ExtentReporterInitializer} for {@link ExtentReportType}.
     */
    public static Reporter create() {
       return selectReporter(ReportType.get(map.get(REPORTER)));
    }

    @Override
    public Reporter createReporter() {
        return create();
    }
}