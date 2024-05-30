package com.twozo.extent.reports.formatter.label;

import com.twozo.extent.reports.formatter.Formatter;

import lombok.Builder;

import java.util.Objects;

/**
 * Represents a label element in HTML, implementing the {@link Formatter}.
 * Provides functionality for generating HTML markup for labels with text and color.
 * <p>
 * Utilizes Lombok annotations (@Builder) to
 * automatically generate a builder reducing code verbosity and improving code readability.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Formatter
 */

@Builder
public record Label(String text, ColourType color, ColourType textColor) implements Formatter {

    /**
     * Generates the formatter representation of the label.
     * This method overrides the getMarkup() method defined in the Mark interface.
     *
     * @return The HTML markup representation of the label.
     */
    @Override
    public String getMarkup() {

        if (Objects.isNull(text) || text.isEmpty()) {
            return "";
        }

        final String textColor = getTextColorClass(textColor());

        return "<span class='badge " + textColor + " " + color.toString().toLowerCase() + "'>" + text + "</span>";
    }

    /**
     * Provides the CSS class for the text color based on the ColourType.
     *
     * @param textColor The ColourType for the text.
     * @return The CSS class for the text color.
     */
    private String getTextColorClass(final ColourType textColor) {

        if (Objects.isNull(textColor)) {
            return "black-text";
        }

        return switch (textColor) {
            case WHITE -> "white-text";
            case RED -> "red-text";
            case PINK -> "pink-text";
            case CYAN -> "cyan-text";
            case GREY -> "grey-text";
            case LIME -> "lime-text";
            case TEAL -> "teal-text";
            case AMBER -> "amber-text";
            case BROWN -> "brown-text";
            case GREEN -> "green-text";
            case INDIGO -> "indigo-text";
            case ORANGE -> "orange-text";
            case PURPLE -> "purple-text";
            case YELLOW -> "yellow-text";
            case BLUE -> "blue-text";
            default -> "black-text";
        };
    }
}