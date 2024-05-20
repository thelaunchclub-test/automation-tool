package com.extent.reports.Markup;

import lombok.*;

/**
 * Represents a label element in HTML, implementing the Mark interface.
 * This class provides functionality for generating HTML markup for labels with text and color.
 * <p>
 * The class utilizes Lombok annotations (@Getter, @Setter, @Builder, @AllArgsConstructor, @ToString) to
 * automatically generate getter methods, setter methods, a builder, a constructor with all fields, and
 * a toString representation, reducing code verbosity and improving code readability.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
class Label implements MarkupItem {

    private String text;
    private ColourType color;

    /**
     * Generates the markup representation of the label.
     * This method overrides the getMarkup() method defined in the Mark interface.
     *
     * @return The HTML markup representation of the label.
     */
    @Override
    public String getMarkup() {

        if (text == null || text.isEmpty()) {
            return "";
        }

        final String textColor = color != ColourType.WHITE ? "white-text" : "black-text";

        return "<span class='badge " + textColor + " " + color.toString().toLowerCase() + "'>" + text + "</span>";
    }
}

