package com.extent.reports.extent;

import com.extent.reports.service.ReportGenerator;
import com.extent.reports.service.ReportService;

/**
 * Provides an ExtentReport instance using ExtentReportImpl.
 *
 * @see ReportService
 *
 * @Author Navin Jones
 * @version 1.0
 */
public final class ExtentReportServiceImpl implements ReportService {

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportGenerator getReport() {
        return new ExtentReporterImpl();
    }
}


