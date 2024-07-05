package com.twozo.extent.report.test.model.label;

import com.twozo.extent.report.test.internal.formatter.fields.LabelFields;
import com.twozo.extent.report.test.service.Formatter;

import lombok.Builder;

import java.util.Objects;

/**
 * <p>
 * Represents a label with text, background color, and text color. {@link Formatter} To generate HTML format
 * representation of the label.
 * </p>
 *
 * <p>
 * Allows easy creation of labels with specified text, background color, and text color.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * Label label = Label.builder()
 *     .text("Priority")
 *     .color(ColourType.RED)
 *     .textColor(ColourType.WHITE)
 *     .build();
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Formatter
 */
@Builder
public record Label(String text, ColourType color, ColourType textColor) implements Formatter {

    /**
     * <p>
     * Generates {@link Formatter} representation of the label.
     * </p>
     *
     * @return The HTML format representation of the label.
     */
    @Override
    public String getMarkup() {

        if (Objects.isNull(text) || text.isEmpty()) {
            return LabelFields.EMPTY;
        }
        final String textColorClass = getTextColor(textColor());
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(LabelFields.SPAN_BADGE_START)
                .append(textColorClass)
                .append(LabelFields.EMPTY)
                .append(color.toString().toLowerCase())
                .append(LabelFields.TAG_END)
                .append(text)
                .append(LabelFields.SPAN_CLOSE_TAG);

        return stringBuilder.toString();
    }

    /**
     * <p>
     *
     * </p>
     *
     * @param colourType
     * @return
     */
    private String getTextColor(final ColourType colourType) {

        if (Objects.isNull(colourType)) {
            return "black-text";
        }

        return colourType.getColorName();
    }
}