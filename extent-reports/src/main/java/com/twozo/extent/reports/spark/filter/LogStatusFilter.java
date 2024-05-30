package com.twozo.extent.reports.spark.filter;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.EntityFilters;
import com.aventstack.extentreports.reporter.configuration.StatusFilter;

import com.twozo.extent.reports.AbstractExtentReporter;
import com.twozo.extent.reports.spark.SparkReporter;
import com.twozo.extent.reports.test.status.LogStatus;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Provides functionality for filtering status-related data within an ExtentReport.
 * It operates with a generic type T, extending AbstractExtentReporter, representing the type of the associated reporter.
 * This class offers methods to specify and apply status filters to the ExtentReport.
 *
 * @version 1.0
 * @Author Navin Jones
 */
@Getter
public final class LogStatusFilter<T extends AbstractExtentReporter> {

    private final T reporter;
    private Set<LogStatus> statuses;
    private ExtentSparkReporter extentReporter;
    private EntityFilters<ExtentSparkReporter> filter;
    private StatusFilter<ExtentSparkReporter> extentSparkReporterStatusFilter;

    public LogStatusFilter(final T reporter) {
        this.reporter = reporter;

        if (reporter instanceof final SparkReporter spark) {
            this.extentReporter = spark.getExtentSparkReporter();
            this.filter = extentReporter.filter();
            this.extentSparkReporterStatusFilter = filter.statusFilter();
        }
    }

    /**
     * Applies the entity filters and returns the associated ExtentReport instance.
     *
     * @return The associated ExtentReport instance after applying filters.
     */
    public T apply() {
        return reporter;
    }

    /**
     * Sets the statuses to be filtered.
     *
     * @param statuses The set of statuses to be filtered.
     * @return This StatusFilter instance for method chaining.
     */
    public LogStatusFilter<T> as(final Set<LogStatus> statuses) {
        this.statuses = statuses;

        extentSparkReporterStatusFilter.as(LogStatus.getStatus(statuses));

        return this;
    }

    /**
     * Sets the statuses to be filtered.
     *
     * @param statuses The list of statuses to be filtered.
     * @return This StatusFilter instance for method chaining.
     */
    public LogStatusFilter<T> as(final List<LogStatus> statuses) {
        return as(new HashSet<>(statuses));
    }

    /**
     * Sets the statuses to be filtered.
     *
     * @param statuses The array of statuses to be filtered.
     * @return This StatusFilter instance for method chaining.
     */
    public LogStatusFilter<T> as(final LogStatus[] statuses) {
        return as(Arrays.asList(statuses));
    }
}