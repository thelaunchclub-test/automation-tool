package com.extent.reports.Markup;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * Represents a utility class for generating HTML lists.
 * This class provides methods to generate HTML lists (unordered or ordered) based on input data.
 */
public class HtmlList {

    /**
     * Generates an HTML list based on the provided object and list type.
     *
     * @param object The object from which to generate the list items.
     * @param list   The type of list to generate (UL for unordered list, OL for ordered list).
     * @return The HTML representation of the list.
     */
    protected String getList(final Object object, final ListFormat list) {
        final String listType;
        final StringBuilder stringBuilder = new StringBuilder();

        listType = switch (list) {
            case UL -> "ul";
            default -> "ol";
        };

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
     * @param map           The map containing key-value pairs to be added as list items.
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
     * Appends collection elements as list items to the StringBuilder.
     *
     * @param collection    The collection containing elements to be added as list items.
     * @param stringBuilder The StringBuilder to which list items will be appended.
     */
    private void appendCollectionElements(final Object collection, final StringBuilder stringBuilder) {
        Collection<?> elements;

        if (collection.getClass().isArray()) {
            elements = Arrays.asList((Object[]) collection);
        } else {
            elements = (Collection<?>) collection;
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

