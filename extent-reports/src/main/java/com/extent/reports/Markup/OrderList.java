package com.extent.reports.Markup;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an ordered list (OL) in HTML, implementing the Markup interface.
 * This class extends HtmlList to provide functionality for generating HTML ordered lists,
 * and it implements Mark to signify its role as a markup element.
 * <p>
 * The class utilizes Lombok annotations to automatically generate getter, setter, toString, and builder methods,
 * reducing boilerplate code and improving code readability.
 */
@Getter
@Setter
@ToString
@Builder
public class OrderList extends HtmlList implements MarkupItem {

    private Object object;

    /**
     * Generates the markup representation of the ordered list.
     * This method overrides the getMarkup() method defined in the Markup interface.
     *
     * @return The HTML markup representation of the ordered list.
     */
    @Override
    public String getMarkup() {
        return getList(object, ListFormat.OL);
    }
}