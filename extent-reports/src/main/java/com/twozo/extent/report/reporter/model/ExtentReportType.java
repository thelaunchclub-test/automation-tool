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
    SPARK("spark"),

    /*
     * Used for historical test reporting and trend analysis.
     */
    KLOV("klov"),

    /*
     * Customized reporting solution for specific project needs.
     */
    AVENT("avent"),

    /*
     * Integration with email systems to send reports via email.
     */
    EMAIL("email"),
    ;

    private final String name;

    ExtentReportType(final String name) {
      this.name = name;
    }

    public static ExtentReportType get(final String name) {
        return switch (name) {
            case "spark" -> ExtentReportType.SPARK;
            case "klov" -> ExtentReportType.KLOV;
            case "avent" -> ExtentReportType.AVENT;
            case "email" -> ExtentReportType.EMAIL;
            default -> throw new IllegalStateException("Unexpected value: " + name);
        };
    }
}