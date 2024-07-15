package com.twozo.extent.report.reporter.internal.extent;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.extent.report.reporter.error.code.ExtentReportErrorCode;
import com.twozo.extent.report.reporter.internal.spark.SparkReporter;
import com.twozo.extent.report.reporter.model.ExtentReportType;
import com.twozo.extent.report.reporter.service.Reporter;
import com.twozo.extent.report.reporter.util.PropertyReader;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * Provides various services for generating and managing reports.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see AbstractExtentReporter
 */
@EqualsAndHashCode(callSuper = true)
@Value
public class ExtentReporterInitializer extends AbstractExtentReporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtentReporterInitializer.class);
    public static final Map<String, String> map;

    static {
        try {
            map = PropertyReader.get("ReportConfig.properties");
        } catch (IOException e) {
            LOGGER.error("ExtentReporterInitializer : The Config file was not found {}", e.getMessage());
            throw ErrorCode.get(ExtentReportErrorCode.FILE_NOT_FOUND);
        }
    }

    public static Reporter createReporter() {
        final ExtentReportType reportType = ExtentReportType.get(map.get("extentReportType"));

        return switch (reportType) {
            case SPARK -> new ExtentReporterInitializer();
            case KLOV, AVENT, EMAIL -> null;
        };
    }
    public static Reporter create(final String path) {
        final ExtentReportType reportType = ExtentReportType.get(map.get("extentReportType"));

        return switch (reportType) {
            case SPARK -> new SparkReporter(path);
            case KLOV, AVENT, EMAIL -> null;
        };
    }
}