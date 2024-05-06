package com.extent.reports.extent;

import com.extent.reports.service.ReportGenerator;
import com.extent.reports.service.ReportService;

/**
 * Provides an ExtentReport instance using ExtentReportImpl.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ReportService
 */
public final class ExtentReportServiceImpl implements ReportService {

    /**
     * {@inheritDoc}
     *
     * @return A new instance of ExtentReporterImpl, which implements the ReportGenerator interface.
     */
    @Override
    public ReportGenerator getReport() {
        return new ExtentReporterImpl();
    }
}


