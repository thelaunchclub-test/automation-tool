package com.extent.reports.test;

import com.aventstack.extentreports.AbstractProcessor;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import com.extent.reports.test.log.impl.LogImpl;
import com.extent.reports.test.log.service.Log;
import com.extent.reports.test.node.service.Node;
import com.extent.reports.test.screenshot.impl.ScreenshotImpl;
import com.extent.reports.test.screenshot.service.ScreenCapture;
import com.extent.reports.test.status.Status;
import com.extent.reports.test.tabs.impl.TabsImpl;
import com.extent.reports.test.tabs.service.Tabs;


public class TestersImpl extends AbstractProcessor implements Test {

    private ExtentTest extentTest;
    private Test test;

    public TestersImpl(final ExtentTest test) {
        this.extentTest = test;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNode() {
        return null;
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
    public Test createNodeWithName(final String name) {
        this.extentTest = extentTest.createNode(name);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNodeWithNameAndDesc(final String name, final String description) {
        this.extentTest = extentTest.createNode(name, description);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNodeWithNameAndDescAndGherkin(final GherkinKeyword gherkinKeyword, final String name, final String description) {
        this.extentTest = extentTest.createNode(gherkinKeyword, name, description);

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Test createNodeWithGherkin(final GherkinKeyword gherkinKeyword, final String name) {
        this.extentTest = extentTest.createNode(gherkinKeyword, name);

        return this;
    }

    @Override
    public void setLog(Status status, String details) {
    }

    @Override
    public Log getLog() {
        return new LogImpl();
    }

    @Override
    public ScreenCapture getScreenCapture() {
        return new ScreenshotImpl();
    }

    @Override
    public Tabs getTabs() {
        return new TabsImpl(test);
    }
}



