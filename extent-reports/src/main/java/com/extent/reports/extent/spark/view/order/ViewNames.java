package com.extent.reports.extent.spark.view.order;

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
public enum ViewNames {

    /*
     * Enum representing the author entity.
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
     * @param status The collection of ViewNames enum values to be converted.
     * @return The list of equivalent ViewName enum values.
     */
    public static List<ViewName> getViewName(final Collection<ViewNames> status) {
        final List<ViewName> names = new ArrayList<>();

        for (final ViewNames viewNames : status) {

            names.add(switch (viewNames) {
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