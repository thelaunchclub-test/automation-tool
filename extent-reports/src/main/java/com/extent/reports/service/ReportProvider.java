package com.extent.reports.service;

import com.extent.reports.extent.ExtentReport;

/**
 * represents a provider for generating reports.
 */
public interface ReportProvider {

    /**
     * Retrieves an ExtentReport instance for reporting.
     *
     * @return An ExtentReport instance.
     */
    ExtentReport getReport();
}
