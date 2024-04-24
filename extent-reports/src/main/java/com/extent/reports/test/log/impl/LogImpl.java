package com.extent.reports.test.log.impl;

import com.extent.reports.test.Test;
import com.extent.reports.test.log.service.Log;
import com.extent.reports.test.status.Status;

/**
 * Manages logging functionalities such as setting log details, retrieving logs,
 * and handling exceptions and media attachments for a test.
 * @see Log
 */
public class LogImpl implements Log {

    private Test test;

    /**
     * {@inheritDoc}
     */
    @Override
    public Log log(final Status status, final String details) {
        return new LogImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLog(final Status status, final String details) {
        test.setLog(status, details);
    }
}

