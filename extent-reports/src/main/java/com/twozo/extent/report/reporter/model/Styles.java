package com.twozo.extent.report.reporter.model;

import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * <p>
 * Represents different visual styles for themes.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public enum Styles {

    /*
     * Represents a dark visual style
     */
    DARK,

    /*
     * Represents a light visual style
     */
    LIGHT;

    /**
     * <p>
     * Converts a {@link Theme} value to a corresponding {@link Styles} value.
     * </p>
     *
     * @param styles {@link Styles} value to convert
     * @return The corresponding {@link Styles} based on the style
     */
    public static Theme getTheme(final Styles styles) {
        switch (styles) {
            case DARK:
                return Theme.DARK;
            case LIGHT:
                return Theme.STANDARD;
            default:
                throw new IllegalArgumentException("Unknown style: " + styles);
        }
    }
}
