package com.extent.reports.extent;

import com.extent.reports.service.ReportProvider;

/**
 * Implementation class for the ReportProvider interface.
 * Provides an ExtentReport instance using ExtentReportImpl.
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


