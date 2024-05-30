package com.twozo.extent.reports;

import com.twozo.extent.reports.ExtentReporterImpl;
import com.twozo.extent.reports.service.ReportGenerator;
import com.twozo.extent.reports.service.ReportService;

/**
 * Serves as a concrete implementation of the ReportService interface,
 * encapsulating the logic for providing Extent report generation services.
 * <p>
 * This implementation ensures strict adherence to the interface contract by furnishing a method, getReport(),
 * which retrieves a new instance of the ExtentReporterImpl class. ExtentReporterImpl, in turn,
 * abides by the ReportGenerator interface, guaranteeing uniformity and compatibility with the specified
 * reporting standards.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ReportService
 */
public final class ExtentReportServiceImpl implements ReportService {

    /**
     * {@inheritDoc}
     *
     * @return A new instance of ExtentReporterImpl, adhering to the ReportGenerator contract.
     */
    @Override
    public ReportGenerator getReport() {
        return new ExtentReporterImpl();
    }
}