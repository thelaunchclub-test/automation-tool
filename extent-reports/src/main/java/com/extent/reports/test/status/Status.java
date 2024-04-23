package com.extent.reports.test.status;

/**
 * represents the status levels for test executions or results.
 * It defines different statuses such as INFO, PASS, WARNING, SKIP, and FAIL
 * with associated names and levels to indicate the severity or outcome of a test.
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

    /**
     * Constructs a Status enum with the specified name and level.
     *
     * @param name  - the name of the status
     * @param level - the level or severity of the status
     */
    Status(final String name, final int level) {
        this.name = name;
        this.level = level;
    }
}
