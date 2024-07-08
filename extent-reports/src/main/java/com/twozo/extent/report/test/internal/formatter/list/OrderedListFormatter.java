package com.twozo.extent.report.test.internal.formatter.list;

import com.twozo.extent.report.test.model.ListFormat;
import com.twozo.extent.report.test.service.Formatter;

import lombok.Builder;

/**
 * <p>
 * Represents an ordered list.
 * </p>
 *
 * <p>
 * Provide functionality for generating ordered lists, and {@link Formatter} to signify its role
 * as a format element.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * Map<String, Integer> orderedMap = Map.of("Apple", 3, "Banana", 5, "Orange", 2);
 * OrderedListFormatter orderList = OrderedListFormatter.builder()
 *     .value(map)
 *     .build();
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @author Navin Jones
 * @see HtmListFormatter
 * @see Formatter
 */
@Builder
public final class OrderedListFormatter extends HtmListFormatter implements Formatter {

    private final Object value;

    /**<P>
     * Generates an ordered list using the value.
     * </P>
     */
    @Override
    public String getMarkup() {
        return getList(value, ListFormat.OL);
    }
}