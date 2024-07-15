package com.twozo.extent.report.test.internal.formatter.list;

import com.twozo.extent.report.test.model.ListFormat;
import com.twozo.extent.report.test.service.Formatter;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

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
 * @version 1.0
 * @author Navin Jones
 * @see HtmListFormatter
 * @see Formatter
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Value
public class OrderedListFormatter extends HtmListFormatter implements Formatter {

    transient Object value;

    /**<P>
     * Generates an ordered list using the value.
     * </P>
     */
    @Override
    public String getMarkup() {
        return getList(value, ListFormat.OL);
    }
}