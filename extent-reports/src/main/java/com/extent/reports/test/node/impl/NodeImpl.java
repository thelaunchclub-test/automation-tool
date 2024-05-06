package com.extent.reports.test.node.impl;

import com.aventstack.extentreports.GherkinKeyword;

import com.extent.reports.test.ReportTest;
import com.extent.reports.test.node.service.Node;

/**
 * Provides an implementation of the {@code Node} interface,
 * encapsulating the logic for creating test nodes based on the provided parameters
 * and delegating the actual node creation to an underlying {@code Test} instance.
 *
 * <p>
 * This implementation serves as a bridge between the {@code Node} interface and the
 * underlying test framework or system, facilitating the seamless integration and
 * execution of test nodes within the testing environment.
 * </p>
 *
 * <p>
 * The class leverages an underlying {@code Test} instance to handle the actual node
 * creation, utilizing specialized methods tailored for different node creation scenarios.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>{@code createNode(String name)}: Delegates the creation of a test node with
 *         the specified name to the underlying {@code Test} instance, utilizing a
 *         dedicated method for creating nodes based on name.</li>
 *     <li>{@code createNode(String name, String description)}: Delegates the creation
 *         of a test node with the specified name and description to the underlying
 *         {@code Test} instance, utilizing a specialized method for detailed node creation.</li>
 *     <li>{@code createNode(GherkinKeyword gherkinKeyword, String name)}: Delegates the
 *         creation of a test node with the specified Gherkin keyword and name to the
 *         underlying {@code Test} instance, utilizing a method tailored for Gherkin-based node creation.</li>
 *     <li>{@code createNode(GherkinKeyword gherkinKeyword, String name, String description)}:
 *         Delegates the creation of a test node with the specified Gherkin keyword, name,
 *         and description to the underlying {@code Test} instance, utilizing a method that
 *         combines Gherkin keyword alignment with detailed node creation.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Example Usage:
 * <pre>
 *     Test test = new TestService();
 *     Node node = new NodeImpl(test);
 *     node.createNode("LoginTest");
 *     node.createNode(GherkinKeyword.SCENARIO, "LoginScenario", "Verify user login workflow");
 * </pre>
 * </p>
 *
 * <p>
 * Note: This implementation relies on an underlying {@code Test} instance to perform
 * the actual node creation. It is essential to ensure that the provided {@code Test}
 * instance is compatible and aligned with the expected node creation methods and behaviors.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see Node
 * @see ReportTest
 * @see GherkinKeyword
 */
public final class NodeImpl implements Node {

    private final ReportTest test;

    public NodeImpl(final ReportTest test) {
        this.test = test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createNode(final String name) {
        test.createNode(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportTest createNode(final String name, final String description) {
        return test.createNode(name, description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportTest createNode(final GherkinKeyword gherkinKeyword, final String name) {
        return test.createNode(gherkinKeyword, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportTest createNode(final GherkinKeyword gherkinKeyword, final String name, final String description) {
        return test.createNode(gherkinKeyword, name, description);
    }
}






