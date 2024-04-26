package com.extent.reports.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import com.extent.reports.test.log.impl.LogImpl;
import com.extent.reports.test.log.service.Log;
import com.extent.reports.test.node.impl.NodeImpl;
import com.extent.reports.test.node.service.Node;
import com.extent.reports.test.screenshot.impl.ScreenCaptureImpl;
import com.extent.reports.test.screenshot.service.ScreenCapture;
import com.extent.reports.test.status.Status;
import com.extent.reports.test.tabs.impl.TabsImpl;
import com.extent.reports.test.tabs.service.Tabs;

/**
 * The {@code TestService} class implements the {@link Test} interface
 * and provides an implementation for managing and reporting test execution details
 * using an ExtentTest instance.
 *
 * <p>
 * This class encapsulates methods to interact with test nodes, assign authors,
 * categories, and devices to tests, add snapshots, and create test nodes
 * with various configurations. It also provides access to logs, screen captures,
 * and tabs associated with the test.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Test
 * @see ExtentTest
 * @see Node
 * @see Log
 * @see ScreenCapture
 * @see Tabs
 * @see GherkinKeyword
 * @see Status
 */

public final class TestService implements Test {

    private ExtentTest extentTest;
    private final Test test;

    public TestService(final ExtentTest test) {
        this.extentTest = test;
        this.test = this;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNode() {
        return new NodeImpl(test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test assignAuthor(final String author) {
        this.extentTest = extentTest.assignAuthor(author);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test assignCategory(final String category) {
        this.extentTest = extentTest.assignCategory(category);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test assignDevice(final String device) {
        this.extentTest = extentTest.assignDevice(device);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test addSnapShotFromPath(final String path) {
        this.extentTest = extentTest.addScreenCaptureFromPath(path);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test addSnapShotFromBase64String(final String base64) {
        this.extentTest = extentTest.addScreenCaptureFromBase64String(base64);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final String name) {
        this.extentTest = extentTest.createNode(name);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final String name, final String description) {
        this.extentTest = extentTest.createNode(name, description);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final GherkinKeyword gherkinKeyword, final String name, final String description) {
        this.extentTest = extentTest.createNode(gherkinKeyword, name, description);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNode(final GherkinKeyword gherkinKeyword, final String name) {
        this.extentTest = extentTest.createNode(gherkinKeyword, name);

        return this;
    }

    @Override
    public void setLog(final Status status, final String details) {

    }

    @Override
    public void LogInfo(final String message) {
        extentTest.info(message);
    }

    @Override
    public void LogPass(final String message) {
        extentTest.pass(message);
    }

    @Override
    public void LogFail(final String message) {
        extentTest.fail(message);
    }

    @Override
    public void LogSkip(final String message) {
        extentTest.skip(message);
    }

    @Override
    public void LogWarning(final String message) {
        extentTest.warning(message);
    }

    @Override
    public Log getLog() {
        return new LogImpl();
    }

    @Override
    public ScreenCapture getScreenCapture() {
        return new ScreenCaptureImpl(test);
    }

    @Override
    public Tabs getTabs() {
        return new TabsImpl(test);
    }
}



