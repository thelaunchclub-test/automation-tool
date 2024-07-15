package com.twozo.extent.report.reporter.internal.order;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewOrder;

import com.twozo.extent.report.reporter.internal.extent.AbstractExtentReporter;
import com.twozo.extent.report.reporter.internal.spark.SparkReporter;

import com.twozo.extent.report.reporter.model.NavigationBar;

import lombok.Getter;

import java.util.Collection;
import java.util.Set;

/**
 * <p>
 * Manages and configuring the view order of the report.
 * Allows for the selection of specific view names, such setViewOrder author, and defines the order in which
 * these views are displayed in the report. To facilitate customized report generation.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>Manages the order of views in the report.</li>
 *     <li>Supports customization of view names based on user preference.</li>
 *     <li>Integrates with {@link SparkReporter} to generate the report.</li>
 * </ul>
 * </p>
 *
 * @version 1.0
 * @author Navin Jones
 * @see AbstractExtentReporter
 */
@Getter
public final class OrderSummary<T extends AbstractExtentReporter> {

    private final T reporter;
    private ExtentSparkReporter extentSparkReporter;
    private ViewOrder<ExtentSparkReporter> viewOrder;

    public OrderSummary(final T reporter) {
        this.reporter = reporter;

        if (reporter instanceof final SparkReporter sparkReporter) {
            this.extentSparkReporter = sparkReporter.getExtentSparkReporter();
            this.viewOrder = extentSparkReporter.viewConfigurer().viewOrder();
        }
    }

    /**
     * <p>
     * Configures the view order based on the specified {@link NavigationBar} list.
     * </p>
     *
     * @param navigationBar The list of {@link NavigationBar} specifying the desired view order.
     * @return              The current {@link OrderSummary}, with the view order updated.
     */
    public OrderSummary<T> setViewOrder(final Collection<NavigationBar> navigationBar) {
        viewOrder.as(NavigationBar.get(navigationBar));

        return this;
    }

    /**
     * <p>
     * Sets the view order for the report based on the specified varArgs of {@link NavigationBar}.
     * </p>
     *
     * @param navigationBars The array of {@link NavigationBar} specifying the desired view order.
     * @return               The current {@link OrderSummary} with the view order set.
     */
    public OrderSummary<T> setViewOrder(final NavigationBar... navigationBars) {
        return setViewOrder(Set.of(navigationBars));
    }

    /**
     * <p>
     * Retrieves the getReporter associated with {@link OrderSummary}.
     * </p>
     *
     * @return The getReporter associated with {@link OrderSummary}.
     */
    public T getOrderReporter() {
        return reporter;
    }
}