package com.extent.reports.Markup;

/**
 * Utility class for generating various markup elements conveniently.
 * This class provides static methods to create different types of markup elements such as labels, code blocks, lists, and tables.
 * <p>
 * Markup elements are created using builder patterns, offering flexibility in customization.
 * <p>
 * Note: The class name "MarkUpHelp" could be improved for better clarity and adherence to naming conventions.
 */
public class MarkupGenerator {

    private MarkupGenerator() {
    }

    /**
     * Creates a label markup element with the specified text and color.
     *
     * @param text   The text content of the label.
     * @param colour The color of the label.
     * @return The created label markup.
     */
    public static MarkupItem createLabel(final String text, final ColourType colour) {
        return Label.builder().text(text).color(colour).build();
    }

    /**
     * Creates a code block markup element with the specified code.
     *
     * @param code The code content of the code block.
     * @return The created code block markup.
     */
    public static MarkupItem createCodeBlock(final String code) {
        final String[] codeBlock = code == null ? null : new String[]{code};
        return MarkupCodeBlock.builder().codeArray(codeBlock).build();
    }

    /**
     * Creates a code block markup element with multiple lines of code.
     *
     * @param code1 The first line of code.
     * @param code2 The second line of code.
     * @return The created code block markup.
     */
    public static MarkupItem createCodeBlock(final String code1, final String code2) {
        return MarkupCodeBlock.builder().codeArray(new String[]{code1, code2}).build();
    }

    /**
     * Creates a code block markup element with multiple lines of code.
     *
     * @param code1 The first line of code.
     * @param code2 The second line of code.
     * @param code3 The third line of code.
     * @return The created code block markup.
     */
    public static MarkupItem createCodeBlock(String code1, String code2, String code3) {
        return MarkupCodeBlock.builder().codeArray(new String[]{code1, code2, code3}).build();
    }

    /**
     * Creates a code block markup element with multiple lines of code.
     *
     * @param code1 The first line of code.
     * @param code2 The second line of code.
     * @param code3 The third line of code.
     * @param code4 The fourth line of code.
     * @return The created code block markup.
     */
    public static MarkupItem createCodeBlock(final String code1, final String code2, final String code3, final String code4) {
        return MarkupCodeBlock.builder().codeArray(new String[]{code1, code2, code3, code4}).build();
    }

    /**
     * Creates a code block markup element with the specified code and language.
     *
     * @param code The code content of the code block.
     * @param lang The language of the code block.
     * @return The created code block markup.
     */
    public static MarkupItem createCodeBlock(final String code, final CodeLanguage lang) {
        return MarkupCodeBlock.builder().codeArray(new String[]{code}).lang(lang).build();
    }

    /**
     * Creates a code block markup element with multiple lines of code.
     *
     * @param code The array of code lines.
     * @return The created code block markup.
     */
    public static MarkupItem createCodeBlocks(final String[] code) {
        return MarkupCodeBlock.builder().codeArray(code).build();
    }

    /**
     * Creates an ordered list markup element from the provided object.
     *
     * @param object The object to be converted into an ordered list.
     * @return The created ordered list markup.
     */
    public static MarkupItem createOrderedList(final Object object) {
        return OrderList.builder().object(object).build();
    }

    /**
     * Creates an unordered list markup element from the provided object.
     *
     * @param object The object to be converted into an unordered list.
     * @return The created unordered list markup.
     */
    public static MarkupItem createUnOrderedList(final Object object) {
        return UnOrderList.builder().object(object).build();
    }

    /**
     * Creates a table markup element with the specified data and CSS class for header row.
     *
     * @param data     The data for the table.
     * @param cssClass The CSS class for the header row.
     * @return The created table markup.
     */
    public static MarkupItem createTable(final String[][] data, final String[] cssClass) {
        return TableGenerator.builder().tableData(data).headerRow(cssClass).build();
    }

    /**
     * Creates a table markup element with the specified data and CSS class.
     *
     * @param data     The data for the table.
     * @param cssClass The CSS class for the table.
     * @return The created table markup.
     */
    public static MarkupItem createTable(final String[][] data, final String cssClass) {
        return TableGenerator.builder().tableData(data).tableAttributes(cssClass).build();
    }

    /**
     * Creates a table markup element with the specified data.
     *
     * @param data The data for the table.
     * @return The created table markup.
     */
    public static MarkupItem createTable(final String[][] data) {
        return TableGenerator.builder().tableData(data).build();
    }

    /**
     * Converts the provided object into a table markup element with the specified CSS class for header row.
     *
     * @param o        The object to be converted into a table.
     * @param cssClass The CSS class for the header row.
     * @return The created table markup.
     */
    public static MarkupItem toTable(final Object o, final String[] cssClass) {
        return TableGenerator.builder().sourceObject(o).headerRow(cssClass).build();
    }

    /**
     * Converts the provided object into a table markup element with the specified CSS class.
     *
     * @param o        The object to be converted into a table.
     * @param cssClass The CSS class for the table.
     * @return The created table markup.
     */
    public static MarkupItem toTable(Object o, String cssClass) {
        return TableGenerator.builder().sourceObject(o).tableAttributes(cssClass).build();
    }

    /**
     * Converts the provided object into a table markup element.
     *
     * @param o The object to be converted into a table.
     * @return The created table markup.
     */
    public static MarkupItem toTable(Object o) {
        return TableGenerator.builder().sourceObject(o).build();
    }
}