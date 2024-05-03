package com.extent.reports.test.tabs.service;


import com.extent.reports.test.TestFunction;

/**
 * Defines the contract for managing and associating
 * various metadata attributes, such as author, category, and device, with a test
 * execution or operation within the testing framework. This interface offers methods
 * to assign and update these metadata attributes to provide additional context and
 * categorization for test executions or operations.
 *
 * <p>
 * The interface serves as a bridge between the test execution context and the
 * associated metadata attributes, facilitating the seamless integration and
 * management of metadata within the testing environment. By leveraging these
 * methods, users can enhance the organization and analysis of test executions
 * or operations based on specified metadata attributes.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>{@code assignAuthor(String name)}: Assigns the specified author name
 *         to the test execution or operation, allowing for the identification
 *         and categorization of tests based on the authorship.</li>
 *     <li>{@code assignCategory(String name)}: Assigns the specified category
 *         name to the test execution or operation, facilitating the grouping
 *         and organization of tests based on predefined categories.</li>
 *     <li>{@code assignDevice(String name)}: Assigns the specified device name
 *         to the test execution or operation, providing insights into the
 *         targeted device or platform for the test execution or operation.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note: Implementations of this interface should handle the association
 * and management of metadata attributes with the test execution or operation.
 * It is essential to ensure compatibility and alignment with the underlying
 * test framework or system for seamless integration and accurate representation
 * of metadata within test reports and logs.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see com.extent.reports.test.tabs.impl.TabsImpl
 * @see TestFunction
 */
public interface Tabs {

    /**
     * Assigns the specified author name to the test execution or operation.
     *
     * @param name - the name of the author, providing identification and
     *             categorization based on authorship.
     * @return an updated instance of {@code Test} reflecting the assignment
     * of the author name to the test execution or operation.
     */
    TestFunction assignAuthor(final String name);

    /**
     * Assigns the specified category name to the test execution or operation.
     *
     * @param name - the name of the category, facilitating grouping and
     *             organization based on predefined categories.
     * @return an updated instance of {@code Test} reflecting the assignment
     * of the category name to the test execution or operation.
     */
    TestFunction assignCategory(final String name);

    /**
     * Assigns the specified device name to the test execution or operation.
     *
     * @param name - the name of the device, providing insights into the
     *             targeted device or platform for the test execution or operation.
     * @return an updated instance of {@code Test} reflecting the assignment
     * of the device name to the test execution or operation.
     */
    TestFunction assignDevice(final String name);
}

