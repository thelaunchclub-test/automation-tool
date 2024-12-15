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
public enum ScreenMode {

    /*
     * Represents a dark visual style
     */
    DARK,

    /*
     * Represents a light visual style
     */
    LIGHT,
    ;

    /**
     * <p>
     * Converts a {@link Theme} value to a corresponding {@link ScreenMode} value.
     * </p>
     *
     * @param screenMode {@link ScreenMode} value to convert
     * @return       The corresponding {@link ScreenMode} based on the style
     */
    public static Theme getTheme(final ScreenMode screenMode) {

        return switch (screenMode) {
            case DARK -> Theme.DARK;
            case LIGHT -> Theme.STANDARD;
        };
    }
}
