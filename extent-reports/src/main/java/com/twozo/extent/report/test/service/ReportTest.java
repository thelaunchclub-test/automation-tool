package com.twozo.extent.report.test.service;

/**
 * <p>
 * Manages and reports reportTest execution details.
 * </p>
 *
 * <p>
 * Interacts with reportTest nodes, assign authors, categories, and devices to tests, add snapshots,
 * and create reportTest nodes with various configurations. Provides access to logs, screen captures,
 * and tabs associated with the reportTest.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 */
public interface ReportTest {

    /**
     * <p>
     * Retrieves the current node associated with the {@link ReportTest}.
     * </p>
     *
     * @return Represents {@link Node}
     */
    Node getNode();

    /**
     * <p>
     * Retrieves the {@link Log} associated with the {@link ReportTest}.
     * </p>
     *
     * @return Represents {@link Log}.
     */
    Log getLog();

    /**
     * <p>
     * Retrieves the {@link ScreenCapture} associated with the {@link ReportTest}.
     * </p>
     *
     * @return Represents {@link ScreenCapture} .
     */
    ScreenCapture getScreenCapture();

    /**
     * <p>
     * Retrieves the {@link Tabs} associated with the {@link ReportTest}.
     * </p>
     *
     * @return Represents {@link Tabs}.
     */
    Tabs getTabs();

    /**
     * <p>
     * Creates a new {@link ReportTest} with the specified testName.
     * </p>
     *
     * @param testName  The testName of the {@link ReportTest}.
     * @return The newly created {@link ReportTest}.
     */
    ReportTest createTest(final String testName);

    /**
     * <p>
     * Creates a new {@link ReportTest} with the specified testName and description.
     * </p>
     *
     * @param testName    The testName of the test.
     * @param details     The description of the test.
     * @return The newly created test.
     */
    ReportTest createTest(final String testName, final String details);

    /**
     * <p>
     * Removes a specified {@link ReportTest}.
     * </p>
     *
     * @param reportTest   The {@link ReportTest} to remove.
     */
    void removeTest(final ReportTest reportTest);
}