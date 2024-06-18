package com.twozo.extent.report.reporter.view.order;

import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.twozo.extent.report.reporter.impl.ExtentReporterImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Defines the different entities available in the navigation bar of the {@link ExtentReporterImpl}.
 * <p>
 * Represents a distinct section or entity within the {@link ExtentReporterImpl}, which can be accessed and managed
 * through the navigation. Determines the order and available variables
 * within the {@link ExtentReporterImpl}.
 * </p>
 *
 * <p>
 * Key Features:
 * <ul>
 *     <li>Defines constants for each section/entity in the navigation bar.</li>
 *     <li>Facilitates the organization and retrieval of different report sections.</li>
 *     <li>Helps in maintaining a clear structure and access control within the report interface.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * NavigationBar currentSection = NavigationBar.DASHBOARD;
 * }</pre>
 * </p>
 * Demonstrates how to use the enum to switch between different sections of the report.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see ViewName
 */
public enum NavigationBar {

    /*
     * Represents the author entity.
     */
    AUTHOR,

    /*
     * Represents the category entity.
     */
    CATEGORY,

    /*
     * Represents the dashboard entity.
     */
    DASHBOARD,

    /*
     * Represents the device entity.
     */
    DEVICE,

    /*
     * Represents the exception entity.
     */
    EXCEPTION,

    /*
     * Represents the log entity.
     */
    LOG,

    /*
     * Represents the test entity.
     */
    TEST,
    ;

    /**
     * <p>
     * Converts a collection of {@link NavigationBar} values to a list of corresponding {@link ViewName} values.
     * Uses for retrieving the appropriate view names for the navigation bar in the report.
     * </p>
     *
     * <p>
     * Demonstrates how to convert a collection of {@link NavigationBar} enums to a list of {@link ViewName}.
     * </p>
     *
     * @param navigationBars The collection of {@link NavigationBar } enum values to be converted.
     * @return A list of corresponding {@link ViewName} values.
     *
     * @see NavigationBar
     * @see ViewName
     */
    public static List<ViewName> getNavigationBar(final Collection<NavigationBar> navigationBars) {
        final List<ViewName> viewName = new ArrayList<>();

        for (final NavigationBar navigationBar : navigationBars) {

            viewName.add(switch (navigationBar) {
                case AUTHOR -> ViewName.AUTHOR;
                case DEVICE -> ViewName.DEVICE;
                case CATEGORY -> ViewName.CATEGORY;
                case EXCEPTION -> ViewName.EXCEPTION;
                case TEST -> ViewName.TEST;
                case LOG -> ViewName.LOG;
                case DASHBOARD -> ViewName.DASHBOARD;
            });
        }

        return viewName;
    }
}