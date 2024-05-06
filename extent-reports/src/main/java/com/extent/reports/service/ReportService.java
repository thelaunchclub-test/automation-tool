package com.extent.reports.service;

/**
 * Serves as an abstraction for obtaining instances of report generation utilities.
 *
 * <p>
 * This interface declares a method to retrieve an instance of
 * {@link ReportGenerator}, which encapsulates the functionality
 * for generating reports.
 * </p>
 *
 * <p>
 * Implementing classes should provide an implementation for the
 * {@code getReport()} method to return an instance of a class that
 * adheres to the {@link ReportGenerator} contract, allowing clients
 * to generate reports using the returned instance.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * ReportService reportService = ReportGenerator.getInstance();
 * ReportGenerator reportGenerator = reportProvider.getReport();
 * }</pre>
 * </p>
 *
 * @version 1.1
 * @Author Navin Jones
 * @see ReportGenerator
 */
public interface ReportService {

    /**
     * Retrieves an instance of {@link ReportGenerator} for report generation.
     *
     * <p>
     * Implementing classes should provide an implementation for this method
     * to return an instance of {@link ReportGenerator} that encapsulates
     * the report generation functionality.
     * </p>
     *
     * @return An instance of {@link ReportGenerator} for generating reports.
     * @see ReportGenerator
     */
    ReportGenerator getReport();
}