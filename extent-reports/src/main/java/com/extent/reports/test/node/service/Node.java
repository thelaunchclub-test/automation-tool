package com.extent.reports.test.node.service;

import com.aventstack.extentreports.GherkinKeyword;
import com.extent.reports.test.TestOperation;

/**
 * Defines the contract for creating test nodes within the testing framework.
 * Test nodes serve as fundamental building blocks for structuring and organizing test executions,
 * encapsulating various attributes such as name, description, and Gherkin keywords.
 *
 * <p>
 * The interface offers multiple overloaded methods to accommodate different combinations of parameters
 * for creating test nodes, providing flexibility and adaptability to various testing scenarios.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>{@code createNode(String name)}: Creates a test node with the specified name, serving as
 *         a basic unit for organizing tests without additional description or Gherkin keywords.</li>
 *     <li>{@code createNode(String name, String description)}: Creates a test node with the specified
 *         name and description, offering more context and details about the test node.</li>
 *     <li>{@code createNode(GherkinKeyword gherkinKeyword, String name)}: Creates a test node with
 *         the specified Gherkin keyword and name, aligning the test node with Gherkin syntax
 *         conventions for behavior-driven development (BDD).</li>
 *     <li>{@code createNode(GherkinKeyword gherkinKeyword, String name, String description)}: Creates
 *         a test node with the specified Gherkin keyword, name, and description, combining the
 *         flexibility of Gherkin keywords with detailed descriptions.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Example Usage:
 * <pre>
 *     Node node = new TestNodeFactory();
 *     node.createNode("LoginTest", "Verify user login functionality");
 *     node.createNode(GherkinKeyword.SCENARIO, "LoginScenario", "Verify user login workflow");
 * </pre>
 * </p>
 *
 * <p>
 * Note: Implementations of this interface should handle the instantiation and configuration
 * of test nodes based on the provided parameters, ensuring consistency and adherence to
 * the testing framework's standards and conventions.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see TestOperation
 * @see GherkinKeyword
 */
public interface Node {

    /**
     * Creates a test node with the specified name.
     */
    void createNode(final String name);

    /**
     * Creates a test node with the specified name and description.
     */
    TestOperation createNode(final String name, final String description);

    /**
     * Creates a test node with the specified Gherkin keyword and name.
     */
    TestOperation createNode(final GherkinKeyword gherkinKeyword, final String name);

    /**
     * Creates a test node with the specified Gherkin keyword, name, and description.
     */
    TestOperation createNode(final GherkinKeyword gherkinKeyword, final String name, final String description);
}


