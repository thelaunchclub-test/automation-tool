package com.twozo.extent.reports.spark.view.order;

import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents various view names in an ExtentReport.
 * These view names are used to categorize and organize report elements.
 *
 * @version 1.0
 * @Author Navin Jones
 */
public enum NavigationBar {

    /*
     * Represents the author entity.
     */
    AUTHOR,

    /*
     * Enum representing the category entity.
     */
    CATEGORY,

    /*
     * Enum representing the dashboard entity.
     */
    DASHBOARD,

    /*
     * Enum representing the device entity.
     */
    DEVICE,

    /*
     * Enum representing the exception entity.
     */
    EXCEPTION,

    /*
     * Enum representing the log entity.
     */
    LOG,

    /*
     * Enum representing the test entity.
     */
    TEST,
    ;

    /**
     * Converts a collection of ViewNames enum values to a list of equivalent ViewName enum values.
     *
     * @param navBar The collection of NavigationBar enum values to be converted.
     * @return The list of equivalent ViewName enum values.
     */
    public static List<ViewName> getNavBar(final Collection<NavigationBar> navBar) {
        final List<ViewName> names = new ArrayList<>();

        for (final NavigationBar navigationBar : navBar) {

            names.add(switch (navigationBar) {
                case AUTHOR -> ViewName.AUTHOR;
                case DEVICE -> ViewName.DEVICE;
                case CATEGORY -> ViewName.CATEGORY;
                case EXCEPTION -> ViewName.EXCEPTION;
                case TEST -> ViewName.TEST;
                case LOG -> ViewName.LOG;
                case DASHBOARD -> ViewName.DASHBOARD;
            });
        }

        return names;
    }
}