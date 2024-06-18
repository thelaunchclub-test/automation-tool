package com.twozo.extent.report.reporter.view.order;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.aventstack.extentreports.reporter.configuration.ViewOrder;

import com.twozo.extent.report.reporter.AbstractExtentReporter;
import com.twozo.extent.report.reporter.SparkReporter;

import lombok.Getter;

import java.util.Collection;
import java.util.Set;

/**
 * Manages and configuring the view order of the report.
 * Allows for the selection of specific view names, such setViewOrder author, and defines the order in which
 * these views are displayed in the report. To facilitate customized report generation.
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
 * <p>
 * Example usage:
 * <pre>{@code
 * OrderSummary<ExtentReporterImpl> orderSummary = new OrderSummary<>(getReporter);
 * orderSummary.setViewOrder(ViewOrder.AUTHOR);
 * }</pre>
 * </p>
 *
 * <p>
 * Demonstrates how to initialize an {@link OrderSummary} instance, set a specific view order, and prepare the report.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see AbstractExtentReporter
 * @see ExtentSparkReporter
 * @see ViewOrder
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
     * converts the {@link Collection} of {@link NavigationBar} into a format
     * that can be used by the {@link ViewName} configuration. Ensures that the report displays the views
     * in the specified order.
     * </p>
     *
     * @param navigationBar The list of NavigationBar enums specifying the desired view order.
     * @return The current OrderSummary instance, with the view order updated.
     *
     * @see NavigationBar
     * @see ViewOrder
     */
    public OrderSummary<T> setViewOrder(final Collection<NavigationBar> navigationBar) {
        viewOrder.as(NavigationBar.getNavigationBar(navigationBar));

        return this;
    }

    /**
     * <p>
     * Sets the view order for the report based on the specified varArgs of {@link NavigationBar}.
     * Converts the varArgs of {@link NavigationBar} into a set and then updates the view order configuration.
     * </p>
     *
     * @param navigationBars The array of NavigationBar enums specifying the desired view order.
     * @return The current {@link OrderSummary} with the view order set.
     *
     * @see NavigationBar
     * @see ViewOrder
     */
    public OrderSummary<T> setViewOrder(final NavigationBar... navigationBars) {
        return setViewOrder(Set.of(navigationBars));
    }

    /**
     * <p>
     * Retrieves the getReporter instance associated with {@link OrderSummary}.
     * </p>
     *
     * @return The getReporter associated with {@link OrderSummary}.
     */
    public T getOrderReporter() {
        return reporter;
    }
}