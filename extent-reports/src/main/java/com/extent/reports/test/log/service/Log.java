package com.extent.reports.test.log.service;

import com.extent.reports.test.status.Status;

public interface Log {

    /**
     * Logs the given status and details.
     *
     * @param status  - the Status enum value indicating the log status
     * @param details - the details or message to be logged
     * @return Log - the updated Log instance
     */
    Log log(final Status status, final String details);

    /**
     * Sets the log status and details.
     *
     * @param status  - the Status enum value indicating the log status
     * @param details - the details or message to be logged
     */
    void setLog(final Status status, final String details);
}

