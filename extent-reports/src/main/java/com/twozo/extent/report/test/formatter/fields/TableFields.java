package com.twozo.extent.report.test.formatter.fields;

/**
 * Provides various constants used for constructing HTML table elements.
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * String tableStart = TableFields.TABLE_WITH_BORDER + TableFields.HTML_TAG_END;
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 */
public class TableFields {

    public static final String EMPTY = "";
    public static final String TABLE_BODY_START = "<tbody>";
    public static final String TABLE_BODY_END = "</tbody>";
    public static final String TABLE_WITH_BORDER = "<table border='1' ";
    public static final String TABLE_END_TAG = "</table>";
    public static final String HTML_TAG_END = ">";
    public static final String TABLE_ROW_START = "<tr>";
    public static final String TABLE_ROW_CLOSE = "</tr>";
    public static final String TABLE_CELL_START = "<td>";
    public static final String TABLE_CELL_CLOSE = "</td>";
}
