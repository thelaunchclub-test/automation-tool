package com.extent.reports.extent;

import com.extent.reports.service.ReportGenerator;
import com.extent.reports.service.ReportService;

/**
 * Provides an ExtentReport instance using ExtentReportImpl.
 *
 */
public final class ExtentReportServiceImpl implements ReportService {

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportGenerator getReport() {
        return new ExtentReportBuilderImpl();
    }
}


