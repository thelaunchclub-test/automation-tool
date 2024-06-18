package com.twozo.extent.report.test.tabs.impl;

import com.aventstack.extentreports.ExtentTest;
import com.twozo.extent.report.test.ReportTest;
import com.twozo.extent.report.test.tabs.Tabs;

/**
 * <p>
 * Defines the contract for managing and associating various attributes, such as author, category,
 * and device, with a test execution.
 * </p>
 *
 * <p>
 * Assigns and updates these attributes to provide additional context and  categorization for
 * test executions.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public final class TabsImpl implements Tabs {

    private final ExtentTest extentTest;

    public TabsImpl(final ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    /**
     * {@inheritDoc}
     *
     * @param authorName - the name of the author.
     * @return The {@code ReportTest}.
     */
    @Override
    public Tabs assignAuthor(final String authorName) {
        extentTest.assignAuthor(authorName);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param categoryName - the name of the category.
     * @return The {@code ReportTest}.
     */
    @Override
    public Tabs assignCategory(final String categoryName) {
        extentTest.assignCategory(categoryName);

        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @param deviceName - the name of the device.
     * @return The {@code ReportTest}.
     */
    @Override
    public Tabs assignDevice(final String deviceName) {
        extentTest.assignDevice(deviceName);

        return this;
    }
}