package com.twozo.extent.report.test.formatter.list;

import com.twozo.extent.report.test.formatter.fields.ListFields;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * Represents a utility class for generating lists. Generates lists (unordered or ordered)
 * based on input data.
 * </p>
 *
 *
 * @version 1.0
 * @Author Navin Jones
 */
public class HtmListFormatter {

    /**
     * <p>
     * Generates an HTML list based on the provided value and list format.
     * </p>
     *
     * @param object The value from which to generate the list items.
     * @param list   The type of list to generate.
     * @return The HTML representation of the list.
     */
    protected String getList(final Object object, final ListFormat list) {
        final String listType;
        final StringBuilder stringBuilder = new StringBuilder();

        listType = (list == ListFormat.UL) ? ListFields.UNORDERED_LIST : ListFields.ORDERED_LIST;

        stringBuilder.append(ListFields.HTML_OPEN_TAG).append(listType).append(ListFields.HTML_CLOSE_TAG);

        if (object instanceof Map) {
            appendMapEntries((Map<?, ?>) object, stringBuilder);
        } else if (object instanceof Collection || object.getClass().isArray()) {
            appendCollectionElements(object, stringBuilder);
        } else {
            appendSingleElement(object, stringBuilder);
        }

        stringBuilder.append(ListFields.END_TAG_PREFIX).append(listType).append(ListFields.HTML_CLOSE_TAG);

        return stringBuilder.toString();
    }

    /**
     * <p>
     * Appends data as list items to the StringBuilder.
     * </p>
     *
     * @param data          The data to be added as list items.
     * @param stringBuilder The StringBuilder to which list items will be appended.
     */
    private void appendMapEntries(final Map<?, ?> data, final StringBuilder stringBuilder) {
        data.forEach((key, value) -> stringBuilder.append(ListFields.LIST_ITEM_OPEN_TAG)
                .append(key)
                .append(ListFields.COLON)
                .append(value)
                .append(ListFields.LIST_ITEM_END_TAG));
    }

    /**
     * <p>
     * Appends value elements as list items to the StringBuilder.
     * </p>
     *
     * @param object        The value containing elements to be added as list items.
     * @param stringBuilder The StringBuilder to which list items will be appended.
     */
    private void appendCollectionElements(final Object object, final StringBuilder stringBuilder) {
        final Collection<?> elements;

        elements = object.getClass().isArray() ? Arrays.asList((Object[]) object) : (Collection<?>) object;

        for (Object element : elements) {
            stringBuilder.append(ListFields.LIST_ITEM_OPEN_TAG).append(element).append(ListFields.LIST_ITEM_END_TAG);
        }
    }

    /**
     * <p>
     * Appends a single element as a list item to the StringBuilder.
     * </p>
     *
     * @param object        The value to be added as a list item.
     * @param stringBuilder The StringBuilder to which the list item will be appended.
     */
    private void appendSingleElement(final Object object, final StringBuilder stringBuilder) {
        stringBuilder.append(ListFields.LIST_ITEM_OPEN_TAG).append(object).append(ListFields.LIST_ITEM_END_TAG);
    }
}