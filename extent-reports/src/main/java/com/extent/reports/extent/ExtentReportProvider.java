package com.extent.reports.extent;

import com.extent.reports.service.ReportProvider;

/**
 * Provides an ExtentReport instance using ExtentReportImpl.
 * @see ReportProvider
 */
public class ExtentReportProvider implements ReportProvider {

    /**
     * {@inheritDoc}
     */
    @Override
    public ExtentReport getReport() {
        return new ExtentReportImpl();
    }
}


