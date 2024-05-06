package com.extent.reports.test.status;

/**
 * represents the status levels for test executions or results.
 * It defines different statuses such as INFO, PASS, WARNING, SKIP, and FAIL
 * with associated names and levels to indicate the severity or outcome of a test.
 *
 * @author Navin Jones
 * @version 1.0
 */
public enum Status {

    INFO("info", 10),
    PASS("pass", 20),
    WARNING("warning", 30),
    SKIP("skip", 40),
    FAIL("fail", 50),
    ;

    private final String name;
    private final int level;

    Status(final String name, final int level) {
        this.name = name;
        this.level = level;
    }
}