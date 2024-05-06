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
 * The {@code TestOperation} class implements the {@link ReportTest} interface
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
 * @see ReportTest
 * @see ExtentTest
 * @see Node
 * @see Log
 * @see ScreenCapture
 * @see Tabs
 * @see GherkinKeyword
 * @see Status
 */

public final class ReportTestImpl implements ReportTest {

    private ExtentTest extentTest;
    private final ReportTest test;

    public ReportTestImpl(final ExtentTest test) {
        this.extentTest = test;
        this.test = this;

    }

    /**
     * {@inheritDoc}
     *
     * @return Node - the current test node
     * @see Node
     */
    @Override
    public Node getNode() {
        return new NodeImpl(test);
    }

    /**
     * {@inheritDoc}
     *
     * @param author - the name of the author
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest assignAuthor(final String author) {
        this.extentTest = extentTest.assignAuthor(author);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param category - the name of the category
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest assignCategory(final String category) {
        this.extentTest = extentTest.assignCategory(category);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param device - the name of the device
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest assignDevice(final String device) {
        this.extentTest = extentTest.assignDevice(device);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param path - the file path of the snapshot
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest addSnapShotFromPath(final String path) {
        this.extentTest = extentTest.addScreenCaptureFromPath(path);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param base64 - the Base64 encoded string of the snapshot
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest addSnapShotFromBase64String(final String base64) {
        this.extentTest = extentTest.addScreenCaptureFromBase64String(base64);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name - the name of the test node
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest createNode(final String name) {
        this.extentTest = extentTest.createNode(name);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param name - the name of the test node
     * @param description - the description of the test node
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest createNode(final String name, final String description) {
        this.extentTest = extentTest.createNode(name, description);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @param description    - the description of the test node
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest createNode(final GherkinKeyword gherkinKeyword, final String name, final String description) {
        this.extentTest = extentTest.createNode(gherkinKeyword, name, description);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param gherkinKeyword - the GherkinKeyword enum value
     * @param name           - the name of the test node
     * @return Test - the updated Test instance
     */
    @Override
    public ReportTest createNode(final GherkinKeyword gherkinKeyword, final String name) {
        this.extentTest = extentTest.createNode(gherkinKeyword, name);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param status  - the Status enum value
     * @param details - the details to be logged
     * @see Status
     */
    @Override
    public void setLog(final Status status, final String details) {
        test.setLog(status, details);
    }

    /**
     * {@inheritDoc}
     *
     * @return Log - the log instance
     * @see Log
     */
    @Override
    public Log getLog() {
        return new LogImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @return ScreenCapture - the screen capture instance
     * @see ScreenCapture
     */
    @Override
    public ScreenCapture getScreenCapture() {
        return new ScreenCaptureImpl(test);
    }

    /**
     * {@inheritDoc}
     *
     * @return Tabs - the tabs instance
     * @see Tabs
     */
    @Override
    public Tabs getTabs() {
        return new TabsImpl(test);
    }
}



