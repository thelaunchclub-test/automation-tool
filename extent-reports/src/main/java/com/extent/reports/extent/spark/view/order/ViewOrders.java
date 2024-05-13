package com.extent.reports.extent.spark.view.order;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewConfigurer;
import com.aventstack.extentreports.reporter.configuration.ViewOrder;

import com.extent.reports.extent.AbstractExtentReporter;
import com.extent.reports.extent.spark.SparkReporter;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * Managing view order configurations within an ExtentReport.
 * It operates with a generic type T, extending AbstractExtentReporter, representing the type of the associated reporter.
 *
 * @version 1.0
 * @Author Navin Jones
 */
public final class ViewOrders<T extends AbstractExtentReporter> {

    private final T reporter;
    @Getter
    private ExtentSparkReporter extentSparkReporter;
    private ViewOrder<ExtentSparkReporter> viewOrder;

    public ViewOrders(final T reporter) {
        this.reporter = reporter;

        if (reporter instanceof final SparkReporter spark) {
            this.extentSparkReporter = spark.getExtentSparkReporter();
            final ViewConfigurer<ExtentSparkReporter> config = extentSparkReporter.viewConfigurer();
            this.viewOrder = config.viewOrder();
        }
    }

    /**
     * Specifies the view order based on the provided list of view names.
     *
     * @param order The list of view names representing the desired view order.
     * @return This ViewOrders instance for method chaining.
     */
    public ViewOrders<T> as(final List<ViewNames> order) {
        viewOrder.as(ViewNames.getViewName(order));

        return this;
    }

    /**
     * Specifies the view order based on the provided array of view names.
     *
     * @param viewOrder The array of view names representing the desired view order.
     * @return This ViewOrders instance for method chaining.
     */
    public ViewOrders<T> as(final ViewNames[] viewOrder) {
        return as(Arrays.asList(viewOrder));
    }

    /**
     * Applies the configured view order and returns the associated reporter instance.
     *
     * @return The associated reporter instance after applying the view order.
     */
    public T apply() {
        return reporter;
    }
}