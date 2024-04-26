package com.extent.reports.service;

import com.extent.reports.extent.ExtentReportBuilderImpl;

/**
 * Defines a contract for classes that mark a report generation capability.
 * It serves as a marker interface indicating the ability to generate reports.
 *
 * <p>
 * This interface provides a static factory method to obtain an instance
 * of a concrete implementation that fulfills the contract.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * ReportMarker reportMarker = ReportMarker.getInstance();
 * }</pre>
 * </p>
 *
 * @see ReportService
 * @see ExtentReportBuilderImpl
 *
 * @Author Navin Jones
 * @version 1.1
 */
@FunctionalInterface
public interface ReportGenerator extends ReportService {

    /**
     * Returns an instance of the {@code ReportGenerator} implementation
     * to facilitate report generation.
     *
     * <p>
     * This method provides a way to obtain an instance of a concrete class
     * that adheres to the {@code ReportMarker} contract.
     * The returned instance can be used to generate reports.
     * </p>
     *
     * @return An instance of {@code ReportGenerator} implementation.
     *
     * @see ExtentReportBuilderImpl
     */
    static ReportGenerator getInstance(){
        return new ExtentReportBuilderImpl();
    }
}

