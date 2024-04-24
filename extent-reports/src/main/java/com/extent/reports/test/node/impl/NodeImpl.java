package com.extent.reports.test.node.impl;

import com.aventstack.extentreports.GherkinKeyword;
import com.extent.reports.test.Test;
import com.extent.reports.test.node.service.Node;


/**
 * provides an implementation of the Node interface.
 * It wraps around an ExtentTest object from ExtentReports library to manage test node creation.
 */
public class NodeImpl implements Node {

    private final Test test;

    /**
     * Constructs a NodeImpl instance with the given ExtentTest object.
     *
     */
    public NodeImpl(final Test test) {
        this.test = test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final String name) {
        return test.createNodeWithName(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final String name, final String description) {
        return test.createNodeWithNameAndDesc(name, description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final GherkinKeyword gherkinKeyword, final String name) {
        return test.createNodeWithGherkin(gherkinKeyword, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final GherkinKeyword gherkinKeyword, final String name, final String description) {
        return test.createNodeWithNameAndDescAndGherkin(gherkinKeyword, name, description);
    }
}




