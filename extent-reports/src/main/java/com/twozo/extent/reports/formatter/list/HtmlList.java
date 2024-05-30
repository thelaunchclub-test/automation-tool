package com.twozo.extent.reports.formatter.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Represents a utility class for generating HTML lists.
 * Provides methods to generate HTML lists (unordered or ordered) based on input data.
 *
 * @version 1.0
 * @Author Navin Jones
 */
public class HtmlList {

    /**
     * Generates an HTML list based on the provided object and list type.
     *
     * @param object The object from which to generate the list items.
     * @param list The type of list to generate (UL for unordered list, OL for ordered list).
     * @return The HTML representation of the list.
     */
    protected String getList(final Object object, final ListFormat list) {
        final String listType;
        final StringBuilder stringBuilder = new StringBuilder();

        if (list == ListFormat.UL) {
            listType = "ul";
        } else {
            listType = "ol";
        }

        stringBuilder.append("<").append(listType).append(">");

        if (object instanceof Map) {
            appendMapEntries((Map<?, ?>) object, stringBuilder);
        } else if (object instanceof Collection || object.getClass().isArray()) {
            appendCollectionElements(object, stringBuilder);
        } else {
            appendSingleElement(object, stringBuilder);
        }

        stringBuilder.append("</").append(listType).append(">");

        return stringBuilder.toString();
    }

    /**
     * Appends map entries as list items to the StringBuilder.
     *
     * @param map The map containing key-value pairs to be added as list items.
     * @param stringBuilder The StringBuilder to which list items will be appended.
     */
    private void appendMapEntries(final Map<?, ?> map, final StringBuilder stringBuilder) {
        map.forEach((key, value) -> stringBuilder.append("<li>")
                .append(key)
                .append(":")
                .append(value)
                .append("</li>"));
    }

    /**
     * Appends object elements as list items to the StringBuilder.
     *
     * @param object The object containing elements to be added as list items.
     * @param stringBuilder The StringBuilder to which list items will be appended.
     */
    private void appendCollectionElements(final Object object, final StringBuilder stringBuilder) {
        final Collection<?> elements;

        if (object.getClass().isArray()) {
            elements = Arrays.asList((Object[]) object);
        } else {
            elements = (Collection<?>) object;
        }

        for (Object element : elements) {
            stringBuilder.append("<li>").append(element).append("</li>");
        }
    }

    /**
     * Appends a single element as a list item to the StringBuilder.
     *
     * @param object        The object to be added as a list item.
     * @param stringBuilder The StringBuilder to which the list item will be appended.
     */
    private void appendSingleElement(final Object object, final StringBuilder stringBuilder) {
        stringBuilder.append("<li>").append(object).append("</li>");
    }
}