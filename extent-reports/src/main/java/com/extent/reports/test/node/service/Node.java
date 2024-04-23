package com.extent.reports.test.node.service;

import com.aventstack.extentreports.GherkinKeyword;
import com.extent.reports.test.Test;


/**
 * defines the contract for creating test nodes.
 * It specifies methods to create test nodes with different configurations.
 */
public interface Node {

    /**
     * Creates a test node with the specified name.
     *
     * @param name - the name of the test node
     * @return Test - the created test node
     */
    Test createNode(final String name);

    /**
     * Creates a test node with the specified name and description.
     *
     * @param name        - the name of the test node
     * @param description - the description of the test node
     * @return Test - the created test node
     */
    Test createNode(final String name, final String description);

    /**
     * Creates a test node with the specified Gherkin keyword and name.
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @return Test - the created test node
     */
    Test createNode(final GherkinKeyword gherkinKeyword, final String name);

    /**
     * Creates a test node with the specified Gherkin keyword, name, and description.
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @param description    - the description of the test node
     * @return Test - the created test node
     */
    Test createNode(final GherkinKeyword gherkinKeyword, final String name, final String description);
}

