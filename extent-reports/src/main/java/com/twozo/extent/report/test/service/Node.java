package com.twozo.extent.report.test.service;

import com.aventstack.extentreports.GherkinKeyword;

/**
 * <p>
 * Defines the contract for creating test nodes within the test.
 * Serves as fundamental building blocks for structuring and organizing tests.
 * </p>
 *
 * <p>
 * Accommodates different combinations for creating test nodes, providing flexibility and adaptability
 * to various testing scenarios.
 * </p>
 *
 * <p>
 * Example Usage:
 * <pre>
 *     node.createNode("LoginTest", "Verify user login functionality");
 *     node.createNode(GherkinKeyword.SCENARIO, "LoginScenario", "Verify user login workflow");
 * </pre>
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public interface Node {

    /**
     * <p>
     * Creates a test node with the specified name.
     * </p>
     *
     * @param nodeName The name of the test node.
     * @return The {@link ReportTest}.
     */
    Node createNode(final String nodeName);

    /**
     * <p>
     * Creates a test node with the specified name and description.
     * </p>
     *
     * @param nodeName    The name of the test node.
     * @param description The description of the test node.
     * @return The {@link ReportTest}.
     */
    Node createNode(final String nodeName, final String description);

    /**
     * <p>
     * Creates a test node with the specified Gherkin keyword and name.
     * </p>
     *
     * @param gherkinKeyword The Gherkin keyword that has to be associated with the test node.
     * @param nodeName       The name of the test node.
     * @return The {@link ReportTest}.
     */
    Node createNode(final GherkinKeyword gherkinKeyword, final String nodeName);

    /**
     * <p>
     * Creates a test node with the specified Gherkin keyword, name, and description.
     * </p>
     *
     * @param gherkinKeyword The Gherkin keyword that has to be associated with the test node.
     * @param nodeName       The name of the test node.
     * @param description    The description of the test node.
     * @return The {@link ReportTest}.
     */
    Node createNode(final GherkinKeyword gherkinKeyword, final String nodeName, final String description);

    Log getLog();
}