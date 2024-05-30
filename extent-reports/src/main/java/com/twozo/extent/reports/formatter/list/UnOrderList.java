package com.twozo.extent.reports.formatter.list;

import com.twozo.extent.reports.formatter.Formatter;

import lombok.Builder;

/**
 * Represents an unordered list (UL) in HTML, implementing {@link Formatter}.
 * This class extends HtmlList to provide functionality for generating HTML unordered lists,
 * and it implements Mark to signify its role as a markup element.
 * <p>
 * Utilizes Lombok annotations to automatically generate builder, and constructor methods,
 * reducing boilerplate code and improving code readability.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see HtmlList
 * @see Formatter
 */

@Builder
public final class UnOrderList extends HtmlList implements Formatter {

    private final Object object;

    /**
     * Generates the markup representation of the unordered list.
     * This method overrides the getMarkup() method defined in the Markup interface.
     *
     * @return The HTML markup representation of the unordered list.
     */
    @Override
    public String getMarkup() {
        return getList(object, ListFormat.UL);
    }
}