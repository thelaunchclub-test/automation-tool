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
public enum ReportType {

    /*
     * TestNG report.
     * Used for generating reports with TestNG test framework.
     */
    TESTNG_REPORTER("testNg report"),

    /*
     * JUnit report.
     * Used for generating reports with JUnit test framework.
     */
    JUNIT_REPORTER("junit report"),

    /*
     * Extent report.
     * Used for generating Extent reports for detailed test reporting.
     */
    EXTENT_REPORT("extent report"),

    /*
     * Calliope report.
     * Specific reporting tool for advanced reporting needs.
     */
    CALLIOPE_PRO("calliope report");

    @Getter
    private final String name;

    ReportType(final String name) {
        this.name = name;
    }
}