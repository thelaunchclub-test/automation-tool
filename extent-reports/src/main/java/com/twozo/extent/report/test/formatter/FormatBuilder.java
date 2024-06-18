package com.twozo.extent.report.test.formatter;

import com.twozo.extent.report.test.formatter.table.TableFormatter;
import com.twozo.extent.report.test.formatter.codeblock.CodeLanguage;
import com.twozo.extent.report.test.formatter.codeblock.CodeFormatter;
import com.twozo.extent.report.test.formatter.label.ColourType;
import com.twozo.extent.report.test.formatter.label.Label;
import com.twozo.extent.report.test.formatter.list.OrderedListFormatter;
import com.twozo.extent.report.test.formatter.list.UnOrderListFormatter;

import java.util.Objects;

/**
 * <p>
 * Generates various format elements conveniently. Creates different types of format elements such as
 * labels, code blocks, lists, and tables.
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 */
public final class FormatBuilder {

    /**
     * <p>
     * Creates a label format element with the specified text and color.
     * </p>
     *
     * @param text   The text content of the label.
     * @param colour The color of the label.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createLabel(final String text, final ColourType colour, final ColourType textColor) {
        return Label.builder().text(text).color(colour).textColor(textColor).build();
    }

    /**
     * <p>
     * Creates a code block format element with the specified code block.
     * </p>
     *
     * @param code The code block.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createCodeBlock(final String code) {
        final String[] codeBlock = Objects.isNull(code) ? null : new String[]{code};

        return CodeFormatter.builder().codeArray(codeBlock).build();
    }

    /**
     * <p>
     * Creates a code blocks format element with the specified code blocks.
     * </p>
     *
     * @param code the code blocks to format.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createCodeBlock(final String... code) {
        return CodeFormatter.builder().codeArray(code).build();
    }

    /**
     * <p>
     * Creates a code block format element with the specified code and language.
     * </p>
     *
     * @param code The code content of the code block.
     * @param lang The language of the code block.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createCodeBlock(final String code, final CodeLanguage lang) {
        return CodeFormatter.builder().codeArray(new String[]{code}).codeLanguage(lang).build();
    }

    /**
     * <p>
     * Creates a code block with multiple lines of code.
     * </p>
     *
     * @param code The array of code lines.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createCodeBlocks(final String[] code) {
        return CodeFormatter.builder().codeArray(code).build();
    }

    /**
     * <p>
     * Creates an ordered list from the provided value.
     * </p>
     *
     * @param object The {@link Object}.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createOrderedList(final Object object) {
        return OrderedListFormatter.builder().value(object).build();
    }

    /**
     * <p>
     * Creates an unordered list from the provided value.
     * </p>
     *
     * @param object The {@link Object}.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createUnOrderedList(final Object object) {
        return UnOrderListFormatter.builder().value(object).build();
    }

    /**
     * <p>
     * Creates a table with the specified data and CSS class for header row.
     * </p>
     *
     * @param data   The data for the table.
     * @param header The header for the table.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createTable(final String[][] data, final String[] header) {
        return TableFormatter.builder().tableData(data).headerRow(header).build();
    }

    /**
     * <p>
     * Creates a table with the specified data and the attribute.
     * </p>
     *
     * @param data      The data for the table.
     * @param attribute The attribute for the table.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createTable(final String[][] data, final String attribute) {
        return TableFormatter.builder().tableData(data).tableAttributes(attribute).build();
    }

    /**
     * <p>
     * Creates a table with the specified data.
     * </p>
     *
     * @param data The data for the table.
     * @return Represents {@link Formatter}.
     */
    public static Formatter createTable(final String[][] data) {
        return TableFormatter.builder().tableData(data).build();
    }

    /**
     * <p>
     * Converts the provided value into a table with the specified header row.
     * </p>
     *
     * @param object    The value to be converted into a table.
     * @param headerRow The header row.
     * @return Represents {@link Formatter}.
     */
    public static Formatter toTable(final Object object, final String[] headerRow) {
        return TableFormatter.builder().sourceObject(object).headerRow(headerRow).build();
    }

    /**
     * <p>
     * Converts the provided value into a table with the specified table attribute.
     * </p>
     *
     * @param object    The value to be converted into a table.
     * @param attribute The attribute for the table.
     * @return Represents {@link Formatter}.
     */
    public static Formatter toTable(final Object object, final String attribute) {
        return TableFormatter.builder().sourceObject(object).tableAttributes(attribute).build();
    }

    /**
     * <p>
     * Converts the provided value into a table.
     * </p>
     *
     * @param object The value to be converted into a table.
     * @return Represents {@link Formatter}.
     */
    public static Formatter toTable(final Object object) {
        return TableFormatter.builder().sourceObject(object).build();
    }
}