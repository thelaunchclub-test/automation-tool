package com.extent.reports.test.status;

import com.aventstack.extentreports.Status;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * represents the status levels for test executions or results.
 * It defines different statuses such as INFO, PASS, WARNING, SKIP, and FAIL
 * with associated names and levels to indicate the severity or outcome of a test.
 *
 * @author Navin Jones
 * @version 1.0
 */
public enum Statuses {

    INFO("info", 10),
    PASS("pass", 20),
    WARNING("warning", 30),
    SKIP("skip", 40),
    FAIL("fail", 50),
    ;

    private final String name;
    private final int level;

    Statuses(final String name, final int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * Retrieves the equivalent Status enum value for a single Statuses enum value.
     * This method converts a Statuses enum value to its corresponding Status enum value.
     *
     * @param statuses The single Statuses enum value to be converted.
     * @return The equivalent Status enum value.
     */
    public static Status getStatus(final Statuses statuses) {
        return switch (statuses) {
            case INFO -> Status.INFO;
            case PASS -> Status.PASS;
            case WARNING -> Status.WARNING;
            case SKIP -> Status.SKIP;
            case FAIL -> Status.FAIL;
        };
    }

    /**
     * Retrieves the equivalent Status enum values for a collection of Statuses enum values.
     * This method converts each Status enum value in the collection to its corresponding Status enum value.
     *
     * @param status The collection of Statuses enum values to be converted.
     * @return The set of equivalent Status enum values.
     */
    public static Set<Status> getStatus(final Collection<Statuses> status) {
        final Set<Status> statuses = new HashSet<>();

        for (final Statuses statuses1 : status) {
            statuses.add(switch (statuses1) {
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