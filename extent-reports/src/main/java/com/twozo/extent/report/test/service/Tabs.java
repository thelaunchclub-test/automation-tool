package com.twozo.extent.report.test.service;

/**
 * <p>
 * Defines the contract for managing and associating various attributes, such as author, category,
 * and device, with a test execution.
 * </p>
 *
 * <p>
 * Assigns and updates these attributes to provide additional context and  categorization for
 * test executions.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public interface Tabs {

    /**
     * <p>
     * Assigns the specified author name to the test.
     * </p>
     *
     * @param authorName - the name of the author.
     * @return The {@code ReportTest}.
     */
    Tabs assignAuthor(final String authorName);

    /**
     * <p>
     * Assigns the specified category name to the test.
     * </p>
     *
     * @param categoryName - the name of the category.
     * @return The {@code ReportTest}.
     */
    Tabs assignCategory(final String categoryName);

    /**
     * <p>
     * Assigns the specified device name to the test.
     * </p>
     *
     * @param deviceName - the name of the device.
     * @return The {@code ReportTest}.
     */
    Tabs assignDevice(final String deviceName);
}