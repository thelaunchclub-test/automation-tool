package com.twozo.extent.report.reporter.model;

/**
 * <p>
 * Represents different types of extent reports that can be generated.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public enum ExtentReportType {

    /*
     * Typically used for interactive and visually appealing reports.
     */
    SPARK,

    /*
     * Used for historical test reporting and trend analysis.
     */
    KLOV,

    /*
     * Customized reporting solution for specific project needs.
     */
    AVENT,

    /*
     * Integration with email systems to send reports via email.
     */
    EMAIL,
}