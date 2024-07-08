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
    TESTNG_REPORTER("testNg report"),

    /*
     * Used for generating reports with JUnit test framework.
     */
    JUNIT_REPORTER("junit report"),

    /*
     * Used for generating Extent reports for detailed test reporting.
     */
    EXTENT_REPORT("extent report"),

    /*
     * Specific reporting tool for advanced reporting needs.
     */
    CALLIOPE_PRO("calliope report"),
    ;

    private final String name;

    ReportType(final String name) {
        this.name = name;
    }
}