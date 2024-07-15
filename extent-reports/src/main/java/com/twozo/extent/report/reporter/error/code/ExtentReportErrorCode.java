package com.twozo.extent.report.reporter.error.code;

import com.twozo.commons.exception.provider.PrefixProvider;
import com.twozo.commons.exception.service.ErrorCodeProvider;

public enum ExtentReportErrorCode implements ErrorCodeProvider {

    FILE_NOT_FOUND(1),
    INVALID_REPORTER(2);

    private static final PrefixProvider PREFIX_PROVIDER = new PrefixProvider();
    private static final int BASE_CODE = 0x1000;

    private final int code;

    ExtentReportErrorCode(final int code) {
        this.code = code;
    }

    /**
     * {@inheritDoc}
     *
     * @return The error code.
     */
    @Override
    public int getErrorCode() {
        return PREFIX_PROVIDER.get(BASE_CODE, code);
    }
}

