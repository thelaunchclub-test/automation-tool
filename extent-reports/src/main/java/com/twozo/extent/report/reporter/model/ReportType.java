package com.twozo.extent.report.reporter.model;

import com.twozo.extent.report.reporter.service.Reporter;

import lombok.Getter;

/**
 * <p>
 * Represents different types of {@link Reporter} available.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
@Getter
public enum ReportType {

    /*
     * Used for generating reports with TestNG test framework.
     */
    TESTNG_REPORTER("testNgReport"),

    /*
     * Used for generating reports with JUnit test framework.
     */
    JUNIT_REPORTER("junitReport"),

    /*
     * Used for generating Extent reports for detailed test reporting.
     */
    EXTENT_REPORT("extentReport"),

    /*
     * Specific reporting tool for advanced reporting needs.
     */
    CALLIOPE_PRO("calliopeReport"),
    ;

    private final String name;

    ReportType(final String name) {
        this.name = name;
    }

    public static ReportType get(final String name) {
        return switch (name) {
            case "testNgReport" -> ReportType.TESTNG_REPORTER;
            case "junitReport" -> ReportType.JUNIT_REPORTER;
            case "extentReport" -> ReportType.EXTENT_REPORT;
            case "calliopeReport" -> ReportType.CALLIOPE_PRO;
            default -> throw new IllegalStateException("Unexpected value: " + name);
        };
    }
}