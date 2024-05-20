package com.extent.reports.Markup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Represents a utility class for generating HTML tables, implementing the Markup interface.
 * This class provides methods for generating HTML tables from either provided data or an object.
 * <p>
 * The class utilizes Lombok annotations (@Getter, @Builder, @AllArgsConstructor, @ToString) to automatically generate
 * getter methods, a builder, constructor with all fields, and a toString representation, reducing code verbosity.
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
public final class TableGenerator implements MarkupItem {

    private final String[][] tableData;
    private final Object sourceObject;
    private final String[] headerRow;
    private String tableAttributes;

    /**
     * Generates the markup representation of the table.
     * This method overrides the getMarkup() method defined in the Markup interface.
     *
     * @return The HTML markup representation of the table.
     */
    @Override
    public String getMarkup() {

        if (headerRow != null && headerRow.length > 0) {
            tableAttributes = String.join(" ", headerRow);
        }

        if (tableData != null) {
            return generateTableFromData();
        }

        try {
            return generateTableFromObject();
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Generates the markup representation of the table from the provided data.
     *
     * @return The HTML markup representation of the table.
     */
    private String generateTableFromData() {
        final StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<table border='1 ").append(tableAttributes).append("'>");

        for (final String[] row : tableData) {
            htmlBuilder.append("<tr>");

            for (final String cell : row) {
                htmlBuilder.append("<td>").append(cell).append("</td>");
            }
            htmlBuilder.append("</tr>");
        }
        htmlBuilder.append("</table>");

        return htmlBuilder.toString();
    }

    /**
     * Generates the markup representation of the table from the provided object.
     *
     * @return The HTML markup representation of the table.
     * @throws IllegalArgumentException if the object type is not supported
     * @throws IllegalAccessException   if accessing the object's properties is not allowed
     */
    private String generateTableFromObject() throws IllegalArgumentException, IllegalAccessException {

        if (sourceObject == null) {
            return "";
        }

        final StringBuilder htmlBuilder = new StringBuilder();
        final StringBuilder contentBuilder = new StringBuilder();

        htmlBuilder.append("<table ").append(tableAttributes).append("'>");
        htmlBuilder.append("<tbody>");

        if (sourceObject instanceof Map) {
            appendMapItems((Map<?, ?>) sourceObject, contentBuilder);
        } else if (sourceObject instanceof Collection || sourceObject.getClass().isArray()) {
            appendCollectionItems(sourceObject, contentBuilder);
        } else {
            appendSingleItem(sourceObject, contentBuilder);
        }

        htmlBuilder.append(contentBuilder);
        htmlBuilder.append("</tbody>");
        htmlBuilder.append("</table>");

        return htmlBuilder.toString();
    }

    /**
     * Appends items from a Map to the table content StringBuilder.
     *
     * @param map            The map containing key-value pairs to be added as table rows.
     * @param contentBuilder The StringBuilder to which table rows will be appended.
     */
    private void appendMapItems(final Map<?, ?> map, final StringBuilder contentBuilder) {
        map.forEach((key, value) -> contentBuilder.append("<tr><td>").append(key).append(":").append(value).append("</td></tr>"));
    }

    /**
     * Appends items from a Collection or array to the table content StringBuilder.
     *
     * @param collection     The Collection or array containing items to be added as table rows.
     * @param contentBuilder The StringBuilder to which table rows will be appended.
     */
    private void appendCollectionItems(final Object collection, final StringBuilder contentBuilder) {

        final Collection<?> coll = (collection instanceof Collection) ?
                (Collection<?>) collection :
                Arrays.asList(toArray(collection));

        coll.forEach(item -> contentBuilder.append("<tr><td>").append(item).append("</td></tr>"));
    }

    /**
     * Appends a single item to the table content StringBuilder.
     *
     * @param item           The item to be added as a table row.
     * @param contentBuilder The StringBuilder to which the table row will be appended.
     */
    private void appendSingleItem(Object item, StringBuilder contentBuilder) {
        contentBuilder.append("<tr><td>").append(item).append("</td></tr>");
    }

    /**
     * Converts an array to a List.
     *
     * @param array The array to be converted.
     * @return The converted List.
     */
    private Object[] toArray(Object array) {
        int length = Array.getLength(array);
        List<Object> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(Array.get(array, i));
        }

        return list.toArray();
    }
}