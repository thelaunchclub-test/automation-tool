package com.twozo.extent.report.test.internal.formatter.list;

import com.twozo.extent.report.test.model.ListFormat;
import com.twozo.extent.report.test.service.Formatter;

import lombok.Builder;

/**
 * <p>
 * Represents an unordered list (UL). Provides functionality for generating unordered lists,
 * and to signify its role as a format element.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * List<String> items = List.of("Apple", "Banana", "Orange");
 * UnorderedList unorderedList = UnorderedList.builder()
 *    .value(items)
 *    .build();
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @Author Navin Jones
 * @see HtmListFormatter
 * @see Formatter
 */
@Builder
public final class UnOrderListFormatter extends HtmListFormatter implements Formatter {

    private final Object value;

    /**<P>
     * Generates an unOrdered list using the value.
     * </P>
     */
    @Override
    public String getMarkup() {
        return getList(value, ListFormat.UL);
    }
}