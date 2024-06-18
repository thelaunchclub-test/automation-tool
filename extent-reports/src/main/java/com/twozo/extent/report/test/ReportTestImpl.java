package com.twozo.extent.report.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.twozo.extent.report.test.log.Log;
import com.twozo.extent.report.test.log.impl.LogImpl;
import com.twozo.extent.report.test.node.Node;
import com.twozo.extent.report.test.node.impl.NodeImpl;
import com.twozo.extent.report.test.screenshot.ScreenCapture;
import com.twozo.extent.report.test.screenshot.impl.ScreenCaptureImpl;
import com.twozo.extent.report.test.tabs.Tabs;
import com.twozo.extent.report.test.tabs.impl.TabsImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages and reports {@link ReportTest} execution details.
 *
 * <p>
 * Interacts with {@link ReportTest} nodes, assign authors, categories, and devices to tests, add snapshots,
 * and create {@link ReportTest} nodes with various configurations. Provides access to logs, screen captures,
 * and tabs associated with the {@link ReportTest}.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ReportTest
 */
public final class ReportTestImpl implements ReportTest  {

    private final ExtentReports reports;
    private final Map<ReportTest, ExtentTest> test;
    private ExtentTest extentTest;

    public ReportTestImpl(final ExtentReports extentReports) {
        this.reports = extentReports;
        this.test = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     *
     * @return Represents {@link Node}.
     */
    @Override
    public Node getNode() {
        return new NodeImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @return Represents {@link Log}.
     */
    @Override
    public Log getLog() {
        return new LogImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @return Represents {@link ScreenCapture}.
     */
    @Override
    public ScreenCapture getScreenCapture() {
        return new ScreenCaptureImpl(extentTest);
    }

    /**
     * {@inheritDoc}
     *
     * @return Represents {@link Tabs}.
     */
    @Override
    public Tabs getTabs() {
        return new TabsImpl(extentTest);
    }

    /**
     * <p>
     * Creates a new {@link ReportTest} with the specified testName.
     * </p>
     *
     * @param testName The testName of the test.
     * @return The newly created {@link ReportTest}.
     */
    public ReportTest createTest(final String testName) {
        return createTest(testName, null);
    }

    /**
     * <p>
     * Creates a new {@link ReportTest} with the specified testName and description.
     * </p>
     *
     * @param testName    The testName of the test.
     * @param description The description of the test.
     * @return The newly created {@link ReportTest}.
     */
    public ReportTest createTest(final String testName, final String description) {
        this.extentTest = reports.createTest(testName, description);

        this.test.put(this, extentTest);

        return this;
    }

    /**
     * <p>
     * Removes a Test value from the {@link ReportTest}.
     * </p>
     *
     * @param test The Test to remove.
     */
    public void removeTest(final ReportTest test) {

        if (this.test.containsKey(test)) {
            final ExtentTest extentTest = this.test.get(test);

            reports.removeTest(extentTest);
            this.test.remove(test);
        }
    }
}