package com.extent.reports.service;

import com.extent.reports.test.Test;

/**
 * represents a Reporter for reporting functionalities.
 * Extends the ReportMarker interface.
 * @see ReportMarker
 */
public interface Reporter extends ReportMarker {

    /**
     * Returns a Test object for reporting.
     *
     * @return A Test object representing the current test.
     */
    Test getTest();
}

