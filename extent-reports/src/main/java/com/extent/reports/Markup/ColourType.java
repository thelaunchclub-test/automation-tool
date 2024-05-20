package com.extent.reports.Markup;

import com.aventstack.extentreports.markuputils.ExtentColor;

/**
 * Representing a broad spectrum of colors.
 * This enum encapsulates various colors, providing a comprehensive palette for different use cases.
 */
public enum ColourType {

    /**
     * RED color, often associated with energy, war, danger, strength, and passion.
     */
    RED,

    /**
     * PINK color, typically associated with love, romance, and femininity.
     */
    PINK,

    /**
     * PURPLE color, often linked to royalty, luxury, wisdom, and ambition.
     */
    PURPLE,

    /**
     * INDIGO color, representing intuition, perception, and the higher mind.
     */
    INDIGO,

    /**
     * BLUE color, symbolizing trust, loyalty, wisdom, confidence, and intelligence.
     */
    BLUE,

    /**
     * CYAN color, a shade of blue-green, often associated with calmness and serenity.
     */
    CYAN,

    /**
     * TEAL color, a deeper variant of cyan, combining the calming properties of blue with the renewal qualities of green.
     */
    TEAL,

    /**
     * GREEN color, associated with nature, growth, harmony, and freshness.
     */
    GREEN,

    /**
     * LIME color, a bright yellow-green, symbolizing energy and vibrancy.
     */
    LIME,

    /**
     * YELLOW color, representing sunshine, happiness, intellect, and energy.
     */
    YELLOW,

    /**
     * AMBER color, a warm shade of yellow, often associated with autumn and honey.
     */
    AMBER,

    /**
     * ORANGE color, combining the energy of red and the happiness of yellow, associated with enthusiasm, creativity, and success.
     */
    ORANGE,

    /**
     * BROWN color, symbolizing reliability, stability, and approachability.
     */
    BROWN,

    /**
     * GREY color, representing neutrality, balance, and sophistication.
     */
    GREY,

    /**
     * WHITE color, symbolizing purity, innocence, cleanliness, and simplicity.
     */
    WHITE,

    /**
     * BLACK color, often associated with power, elegance, formality, and mystery.
     */
    BLACK,

    /**
     * TRANSPARENT color, representing the absence of color, often used to denote visibility without visual interference.
     */
    TRANSPARENT,

    // Placeholder for future colors. The semicolon here is optional and indicates
    // the end of enum constants; it is included to easily extend the enum with methods or additional constants.
    ;

    /**
     * Converts a ColourType enum constant to its corresponding ExtentColor representation.
     * This method leverages a switch expression for concise and clear mapping.
     *
     * @param colour the ColourType enum constant to be converted
     * @return the corresponding ExtentColor constant
     */
    public static ExtentColor getColour(final ColourType colour) {

        return switch (colour) {
            case RED -> ExtentColor.RED;
            case PINK -> ExtentColor.PINK;
            case PURPLE -> ExtentColor.PURPLE;
            case INDIGO -> ExtentColor.INDIGO;
            case BLUE -> ExtentColor.BLUE;
            case CYAN -> ExtentColor.CYAN;
            case TEAL -> ExtentColor.TEAL;
            case GREEN -> ExtentColor.GREEN;
            case LIME -> ExtentColor.LIME;
            case YELLOW -> ExtentColor.YELLOW;
            case AMBER -> ExtentColor.AMBER;
            case ORANGE -> ExtentColor.ORANGE;
            case BROWN -> ExtentColor.BROWN;
            case GREY -> ExtentColor.GREY;
            case WHITE -> ExtentColor.WHITE;
            case BLACK -> ExtentColor.BLACK;
            case TRANSPARENT -> ExtentColor.TRANSPARENT;
        };
    }
}