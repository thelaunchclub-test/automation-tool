package com.extent.reports.Markup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents an unordered list (UL) in HTML, implementing the Markup interface.
 * This class extends HtmlList to provide functionality for generating HTML unordered lists,
 * and it implements Mark to signify its role as a markup element.
 * <p>
 * The class utilizes Lombok annotations to automatically generate getter, builder, and constructor methods,
 * reducing boilerplate code and improving code readability.
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
public class UnOrderList extends HtmlList implements MarkupItem {


    private Object object;

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