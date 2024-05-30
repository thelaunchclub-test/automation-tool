package com.twozo.extent.reports.formatter;

import com.twozo.extent.reports.formatter.Table.TableFormatter;
import com.twozo.extent.reports.formatter.codeblock.CodeLanguage;
import com.twozo.extent.reports.formatter.codeblock.CodeFormatter;
import com.twozo.extent.reports.formatter.label.ColourType;
import com.twozo.extent.reports.formatter.label.Label;
import com.twozo.extent.reports.formatter.list.OrderList;
import com.twozo.extent.reports.formatter.list.UnOrderList;

/**
 * Utility class for generating various format elements conveniently.
 * Provides static methods to create different types of format elements such as labels, code blocks, lists, and tables.
 * <p>
 * Format elements are created using builder patterns, offering flexibility in customization.
 * <p>
 * Note: The class name "FormatHelper" could be improved for better clarity and adherence to naming conventions.
 *
 * @version 1.0
 * @Author Navin Jones
 */
public final class FormatHelper {

    private FormatHelper() {
    }

    /**
     * Creates a label markup element with the specified text and color.
     *
     * @param text   The text content of the label.
     * @param colour The color of the label.
     * @return The created label markup.
     */
    public static Formatter createLabel(final String text, final ColourType colour, final ColourType textColor) {
        return Label.builder().text(text).color(colour).textColor(textColor).build();
    }

    /**
     * Creates a code block markup element with the specified code.
     *
     * @param code The code content of the code block.
     * @return The created code block markup.
     */
    public static Formatter createCodeBlock(final String code) {
        final String[] codeBlock = code == null ? null : new String[]{code};

        return CodeFormatter.builder().codeArray(codeBlock).build();
    }

    /**
     * Creates a new {@link CodeFormatter} with the specified code snippets.
     *
     * @param code the code snippets to format.
     * @return a {@link Formatter} instance configured with the provided code snippets.
     */
    public static Formatter createCodeBlock(final String... code) {
        return CodeFormatter.builder().codeArray(code).build();
    }

    /**
     * Creates a code block markup element with the specified code and language.
     *
     * @param code The code content of the code block.
     * @param lang The language of the code block.
     * @return The created code block markup.
     */
    public static Formatter createCodeBlock(final String code, final CodeLanguage lang) {
        return CodeFormatter.builder().codeArray(new String[]{code}).lang(lang).build();
    }

    /**
     * Creates a code block markup element with multiple lines of code.
     *
     * @param code The array of code lines.
     * @return The created code block markup.
     */
    public static Formatter createCodeBlocks(final String[] code) {
        return CodeFormatter.builder().codeArray(code).build();
    }

    /**
     * Creates an ordered list markup element from the provided object.
     *
     * @param object The object to be converted into an ordered list.
     * @return The created ordered list markup.
     */
    public static Formatter createOrderedList(final Object object) {
        return OrderList.builder().object(object).build();
    }

    /**
     * Creates an unordered list markup element from the provided object.
     *
     * @param object The object to be converted into an unordered list.
     * @return The created unordered list markup.
     */
    public static Formatter createUnOrderedList(final Object object) {
        return UnOrderList.builder().object(object).build();
    }

    /**
     * Creates a table markup element with the specified data and CSS class for header row.
     *
     * @param data     The data for the table.
     * @param cssClass The CSS class for the header row.
     * @return The created table markup.
     */
    public static Formatter createTable(final String[][] data, final String[] cssClass) {
        return TableFormatter.builder().tableData(data).headerRow(cssClass).build();
    }

    /**
     * Creates a table markup element with the specified data and CSS class.
     *
     * @param data     The data for the table.
     * @param cssClass The CSS class for the table.
     * @return The created table markup.
     */
    public static Formatter createTable(final String[][] data, final String cssClass) {
        return TableFormatter.builder().tableData(data).tableAttributes(cssClass).build();
    }

    /**
     * Creates a table markup element with the specified data.
     *
     * @param data The data for the table.
     * @return The created table markup.
     */
    public static Formatter createTable(final String[][] data) {
        return TableFormatter.builder().tableData(data).build();
    }

    /**
     * Converts the provided object into a table markup element with the specified CSS class for header row.
     *
     * @param o        The object to be converted into a table.
     * @param cssClass The CSS class for the header row.
     * @return The created table markup.
     */
    public static Formatter toTable(final Object o, final String[] cssClass) {
        return TableFormatter.builder().sourceObject(o).headerRow(cssClass).build();
    }

    /**
     * Converts the provided object into a table markup element with the specified CSS class.
     *
     * @param o        The object to be converted into a table.
     * @param cssClass The CSS class for the table.
     * @return The created table markup.
     */
    public static Formatter toTable(Object o, String cssClass) {
        return TableFormatter.builder().sourceObject(o).tableAttributes(cssClass).build();
    }

    /**
     * Converts the provided object into a table markup element.
     *
     * @param o The object to be converted into a table.
     * @return The created table markup.
     */
    public static Formatter toTable(Object o) {
        return TableFormatter.builder().sourceObject(o).build();
    }
}