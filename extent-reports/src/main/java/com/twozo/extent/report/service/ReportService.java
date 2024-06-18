package com.twozo.extent.report.service;

/**
 * Generates report generator for generating reports.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ReportGenerator
 */
public interface ReportService {

    /**
     * <p>
     * Retrieves {@link ReportGenerator} for report generation.
     * </p>
     *
     * @return The {@link ReportGenerator} for generating reports.
     */
    ReportGenerator getReport();
}