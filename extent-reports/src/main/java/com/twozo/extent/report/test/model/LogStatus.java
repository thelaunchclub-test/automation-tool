package com.twozo.extent.report.test.model;

import com.aventstack.extentreports.Status;

import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Represents the status levels for test executions or results.
 * </p>
 *
 * <p>
 * Defines different statuses such as INFO, PASS, WARNING, SKIP, and FAIL
 * with associated names and levels to indicate the severity or outcome of a test.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
@Getter
public enum LogStatus {

    INFO("info", 10),
    PASS("pass", 20),
    WARNING("warn", 30),
    SKIP("skip", 40),
    FAIL("fail", 50);

    private final String logStatusName;
    private final int logStatusLevel;

    LogStatus(final String logStatusName, final int logStatusLevel) {
        this.logStatusName = logStatusName;
        this.logStatusLevel = logStatusLevel;
    }

    /**
     * <p>
     * Retrieves the {@link Status} value for a given {@code LogStatus}.
     * </p>
     *
     * @param logStatus The {@code LogStatus}.
     * @return The {@link Status}.
     */
    public static Status getStatus(final LogStatus logStatus) {
        return switch (logStatus) {
            case INFO -> Status.INFO;
            case PASS -> Status.PASS;
            case WARNING -> Status.WARNING;
            case SKIP -> Status.SKIP;
            case FAIL -> Status.FAIL;
        };
    }

    /**
     * <p>
     * Retrieves the {@link Status} values for a {@link Collection} of {@code LogStatus} values.
     * </p>
     *
     * @param logStatus The {@link Collection} of {@code LogStatus}.
     * @return The {@link Set} of {@link Status}.
     */
    public static Set<Status> getStatus(final Collection<LogStatus> logStatus) {
        final Set<Status> statuses = new HashSet<>();

        for (final LogStatus status : logStatus) {
            statuses.add(switch (status) {
                case INFO -> Status.INFO;
                case PASS -> Status.PASS;
                case WARNING -> Status.WARNING;
                case SKIP -> Status.SKIP;
                case FAIL -> Status.FAIL;
            });
        }

        return statuses;
    }
}