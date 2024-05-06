package com.extent.reports.test.tabs.impl;

import com.extent.reports.test.ReportTest;
import com.extent.reports.test.tabs.service.Tabs;

/**
 * Provides an implementation of the {@code Tabs} interface,
 * encapsulating the logic for managing and associating metadata attributes, such as author,
 * category, and device, with a test execution or operation within the testing framework.
 *
 * <p>
 * This implementation leverages an underlying {@code Test} instance to handle the actual
 * assignment and management of metadata attributes, facilitating the seamless integration
 * and application of metadata within the testing environment.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>{@code assignAuthor(String name)}: Delegates the assignment of the specified
 *         author name to the underlying {@code Test} instance, allowing for the
 *         identification and categorization of tests based on authorship.</li>
 *     <li>{@code assignCategory(String name)}: Delegates the assignment of the specified
 *         category name to the underlying {@code Test} instance, facilitating the grouping
 *         and organization of tests based on predefined categories.</li>
 *     <li>{@code assignDevice(String name)}: Delegates the assignment of the specified
 *         device name to the underlying {@code Test} instance, providing insights into
 *         the targeted device or platform for the test execution or operation.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: This implementation relies on an underlying {@code Test} instance to perform
 * the actual assignment and management of metadata attributes. It is essential to ensure
 * compatibility and alignment with the {@code Test} instance to facilitate seamless
 * integration and accurate representation of metadata within test reports and logs.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see Tabs
 * @see ReportTest
 */
public final class TabsImpl implements Tabs {

    private final ReportTest test;

    public TabsImpl(final ReportTest testGenerator) {
        this.test = testGenerator;
    }

    /**
     * {@inheritDoc}
     *
     * @param name - the name of the author, providing identification and categorization based on authorship.
     * @return an updated instance of {@code Test} reflecting the assignment
     * of the author name to the test execution or operation.
     */
    @Override
    public ReportTest assignAuthor(final String name) {
        return test.assignAuthor(name);
    }

    /**
     * {@inheritDoc}
     *
     * @param name - the name of the category, facilitating grouping and
     *             organization based on predefined categories.
     * @return an updated instance of {@code Test} reflecting the assignment
     * of the category name to the test execution or operation.
     */
    @Override
    public ReportTest assignCategory(final String name) {
        return test.assignCategory(name);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Assigns the specified device name to the test execution or operation.
     *
     * @param name - the name of the device, providing insights into the
     *             targeted device or platform for the test execution or operation.
     * @return an updated instance of {@code Test} reflecting the assignment
     * of the device name to the test execution or operation.
     */
    @Override
    public ReportTest assignDevice(final String name) {
        return test.assignDevice(name);
    }
}