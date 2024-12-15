package com.twozo.extent.report.test.internal.node;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import com.twozo.extent.report.test.service.ReportTest;
import com.twozo.extent.report.test.service.Log;
import com.twozo.extent.report.test.internal.log.LogImpl;
import com.twozo.extent.report.test.service.Node;

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
 * @see Node
 */
public final class NodeImpl implements Node {

    private final ExtentTest extentTest;

    public NodeImpl(final ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    /**
     * {@inheritDoc}
     *
     * @param nodeName The name of the test node.
     * @return The {@link ReportTest}.
     */
    @Override
    public Node createNode(final String nodeName) {
        extentTest.createNode(nodeName);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param nodeName    The name of the test node.
     * @param description The description of the test node.
     * @return The {@link ReportTest}.
     */
    @Override
    public Node createNode(final String nodeName, final String description) {
        extentTest.createNode(nodeName, description);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gherkinKeyword The Gherkin keyword that has to be associated with the test node.
     * @param nodeName       The name of the test node.
     * @return The {@link ReportTest}.
     */
    @Override
    public Node createNode(final GherkinKeyword gherkinKeyword, final String nodeName) {
        extentTest.createNode(gherkinKeyword, nodeName);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gherkinKeyword The Gherkin keyword that has to be associated with the test node.
     * @param nodeName       The name of the test node.
     * @param description    The description of the test node.
     * @return The {@link ReportTest}.
     */
    @Override
    public Node createNode(final GherkinKeyword gherkinKeyword, final String nodeName, final String description) {
        extentTest.createNode(gherkinKeyword, nodeName, description);

        return this;
    }

    /**
     * <p>
     * Retrieves the {@link Log} associated with the {@link ReportTest}.
     * </p>
     *
     * @return Represents {@link Log}.
     */
    @Override
    public Log getLog() {
        return new LogImpl(extentTest);
    }
}