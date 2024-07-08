package com.twozo.extent.report.test.model.label;

import lombok.Getter;

/**
 * Represents the set of color types.
 *
 * @Author Navin Jones
 * @version 1.0
 */
@Getter
public enum ColourType {

    /**
     * <p>
     * Represents the color red.
     * </p>
     */
    RED("red-text"),

    /**
     * <p>
     * Represents the color pink.
     * </p>
     */
    PINK("pink"),

    /**
     * <p>
     * Represents the color purple.
     * </p>
     */
    PURPLE("purple"),

    /**
     * <p>
     * Represents the color indigo.
     * </p>
     */
    INDIGO("indigo"),

    /**
     * <p>
     * Represents the color blue.
     * </p>
     */
    BLUE("blue"),

    /**
     * <p>
     * Represents the color cyan.
     * </p>
     */
    CYAN("cyan"),

    /**
     * <p>
     * Represents the color teal.
     * </p>
     */
    TEAL("teal"),

    /**
     * <p>
     * Represents the color green.
     * </p>
     */
    GREEN("green"),

    /**
     * <p>
     * Represents the color lime.
     * </p>
     */
    LIME("lime"),

    /**
     * <p>
     * Represents the color yellow.
     * </p>
     */
    YELLOW("yellow"),

    /**
     * <p>
     * Represents the color amber.
     * </p>
     */
    AMBER("amber"),

    /**
     * <p>
     * Represents the color orange.
     * </p>
     */
    ORANGE("orange"),

    /**
     * <p>
     * Represents the color brown.
     * </p>
     */
    BROWN("brown"),

    /**
     * <p>
     * Represents the color grey.
     * </p>
     */
    GREY("grey"),

    /**
     * <p>
     * Represents the color white.
     * </p>
     */
    WHITE("white"),

    /**
     * <p>
     * Represents the color black.
     * </p>
     */
    BLACK("black"),
    ;

    private final String colorName;

    ColourType(final String colorName) {
        this.colorName = colorName;
    }
}