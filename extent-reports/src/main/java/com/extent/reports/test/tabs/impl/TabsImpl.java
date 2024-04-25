package com.extent.reports.test.tabs.impl;

import com.extent.reports.test.Test;
import com.extent.reports.test.tabs.service.Tabs;

/**
 * The {@code TabsImpl} class provides an implementation of the {@code Tabs} interface,
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
 * @see Test
 */
public final class TabsImpl implements Tabs {

    /**
     * The underlying {@code Test} instance responsible for handling the actual
     * assignment and management of metadata attributes with the test execution or operation.
     */
    private final Test test;

    /**
     * Constructs a {@code TabsImpl} instance with the specified {@code Test} generator.
     *
     * @param testGenerator - the {@code Test} generator representing the test execution
     *                      context and responsible for managing metadata attributes.
     */
    public TabsImpl(final Test testGenerator) {
        this.test = testGenerator;
    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    public Test assignAuthor(final String name) {
        return test.assignAuthor(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test assignCategory(final String name) {
        return test.assignCategory(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test assignDevice(final String name) {
        return test.assignDevice(name);
    }
}

