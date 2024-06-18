package com.twozo.extent.report.test.formatter.table;

import com.twozo.extent.report.test.formatter.Formatter;
import com.twozo.extent.report.test.formatter.fields.TableFields;

import lombok.Builder;

import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * Generates the table based on provided data or a source value.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * TableFormatter tableFormatter = TableFormatter.builder()
 *    .tableData(data)
 *    .headerRow(new String[]{"class='table'", "id='dataTable'"})
 *    .build();
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see Formatter
 */
@Builder
public final class TableFormatter implements Formatter {

    private final String[][] tableData;
    private final Object sourceObject;
    private final String[] headerRow;
    private String tableAttributes;

    /**
     * <p>
     * Generates the HTML format for the table based on the provided data and attributes.
     * </p>
     *
     * @return The String that represents the table in HTML.
     */
    @Override
    public String getMarkup() {
        if (Objects.nonNull(headerRow) && headerRow.length > 0) {
            tableAttributes = String.join(" ", headerRow);
        }

        if (Objects.nonNull(tableData)) {
            return generateTableFromData();
        }

        try {
            return generateTableFromObject();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return TableFields.EMPTY;
    }

    /**
     * <p>
     * Generates a table from the provided data.
     * </p>
     *
     * @return The String that represents the table in HTML.
     */
    private String generateTableFromData() {
        final StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append(TableFields.TABLE_WITH_BORDER).append(tableAttributes).append(TableFields.HTML_TAG_END);

        for (final String[] row : tableData) {
            htmlBuilder.append(TableFields.TABLE_ROW_START);

            for (final String column : row) {
                htmlBuilder.append(TableFields.TABLE_CELL_START).append(column).append(TableFields.TABLE_CELL_CLOSE);
            }
            htmlBuilder.append(TableFields.TABLE_ROW_CLOSE);
        }

        htmlBuilder.append(TableFields.TABLE_END_TAG);

        return htmlBuilder.toString();
    }

    /**
     * <p>
     * Generates a table from the source value.
     * </p>
     *
     * @return The String that represents the table in HTML.
     */
    private String generateTableFromObject() {

        if (Objects.isNull(sourceObject)) {
            return TableFields.EMPTY;
        }

        final StringBuilder htmlBuilder = new StringBuilder();
        final StringBuilder contentBuilder = new StringBuilder();

        try {
            htmlBuilder.append(TableFields.TABLE_WITH_BORDER)
                    .append(tableAttributes)
                    .append(TableFields.HTML_TAG_END)
                    .append(TableFields.TABLE_BODY_START);
        } catch (Exception exception) {
            exception.printStackTrace();
            return TableFields.EMPTY;
        }

        try {
            if (sourceObject instanceof Map) {
                createTableRowsFromMap((Map<?, ?>) sourceObject, contentBuilder);
            } else if (sourceObject instanceof Collection || sourceObject.getClass().isArray()) {
                createTableRowsFromCollection(sourceObject, contentBuilder);
            } else {
                appendSingleItem(sourceObject, contentBuilder);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return TableFields.EMPTY;
        }

        try {
            htmlBuilder.append(contentBuilder)
                    .append(TableFields.TABLE_BODY_END)
                    .append(TableFields.TABLE_END_TAG);
        } catch (Exception exception) {
            exception.printStackTrace();
            return TableFields.EMPTY;
        }

        return htmlBuilder.toString();
    }



    /**
     * <p>
     * Appends data to the table.
     * </p>
     *
     * @param data           The data of the table.
     * @param contentBuilder The StringBuilder to append the content to.
     */
    private void createTableRowsFromMap(final Map<?, ?> data, final StringBuilder contentBuilder) {
        data.forEach((key, value) -> contentBuilder.append(TableFields.TABLE_ROW_START)
                .append(TableFields.TABLE_CELL_START).append(key).append(TableFields.TABLE_CELL_CLOSE)
                .append(TableFields.TABLE_CELL_START).append(value).append(TableFields.TABLE_CELL_CLOSE)
                .append(TableFields.TABLE_ROW_CLOSE));
    }

    /**
     * <p>
     * Appends items from a data to the table.
     * </p>
     *
     * @param data        The data of the table.
     * @param htmlBuilder The StringBuilder to append the HTML markup to.
     */
    private void createTableRowsFromCollection(final Object data, final StringBuilder htmlBuilder) {
        Collection<?> collection = (data instanceof Collection) ? (Collection<?>) data : Arrays.asList(toArray(data));

        collection.forEach(item -> {
            if (item instanceof String) {
                appendStringRow((String) item, htmlBuilder);
            } else {
                htmlBuilder.append(TableFields.TABLE_ROW_START).append(TableFields.TABLE_CELL_START).append(item).
                        append(TableFields.TABLE_CELL_CLOSE).append(TableFields.TABLE_ROW_CLOSE);
            }
        });
    }

    /**
     * <p>
     * Appends a single item to the table.
     * </p>
     *
     * @param object      The {@link Object}
     * @param htmlBuilder The StringBuilder to append the HTML markup to.
     */
    private void appendSingleItem(final Object object, final StringBuilder htmlBuilder) {
        htmlBuilder.append(TableFields.TABLE_ROW_START).append(TableFields.TABLE_CELL_START).append(object).
                append(TableFields.TABLE_CELL_CLOSE).append(TableFields.TABLE_ROW_CLOSE);
    }

    /**
     * <p>
     * Appends a string row split by commas to the table.
     * </p>
     *
     * @param row         The string row to be split and appended.
     * @param htmlBuilder The StringBuilder to append the HTML markup to.
     */
    private void appendStringRow(final String row, final StringBuilder htmlBuilder) {
        final String[] columns = row.split(",\\s*");

        htmlBuilder.append(TableFields.TABLE_ROW_START);

        for (final String column : columns) {
            htmlBuilder.append(TableFields.TABLE_CELL_START).append(column).append(TableFields.TABLE_CELL_CLOSE);
        }
        htmlBuilder.append(TableFields.TABLE_ROW_CLOSE);
    }

    /**
     * <p>
     * Converts an {@link Object} to an array of {@link Object}.
     * </p>
     *
     * @param object The {@link Object} to be converted.
     * @return The array of {@link Object}.
     */
    private Object[] toArray(final Object object) {
        final int length = Array.getLength(object);
        final Object[] result = new Object[length];

        for (int specifcObject = 0; specifcObject < length; specifcObject++) {
            result[specifcObject] = Array.get(object, specifcObject);
        }

        return result;
    }
}
