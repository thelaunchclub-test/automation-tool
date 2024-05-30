package com.twozo.extent.reports.formatter.list;

import com.twozo.extent.reports.formatter.Formatter;

import lombok.Builder;

/**
 * Represents an ordered list (OL) in HTML, implementing the {@link Formatter} .
 * This class extends HtmlList to provide functionality for generating HTML ordered lists,
 * and it implements Mark to signify its role as a markup element.
 * <p>
 * Utilizes Lombok annotation builder methods,for
 * reducing boilerplate code and improving code readability.
 *
 * @version 1.0
 * @Author Navin Jones
 * @see HtmlList
 * @see Formatter
 */

@Builder
public final class OrderList extends HtmlList implements Formatter {

    private final Object object;

    /**
     * Generates the markup representation of the ordered list.
     * Overrides the getMarkup() method defined in the Markup interface.
     *
     * @return The HTML markup representation of the ordered list.
     */
    @Override
    public String getMarkup() {
        return getList(object, ListFormat.OL);
    }
}