package com.twozo.extent.report.test.internal.formatter.fields;

import lombok.Value;

/**
 * <p>
 * Serves as a container constants used for generating HTML labels and badges.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
@Value
public class LabelFields {

    public static final String EMPTY = " ";
    public static final String SPAN_BADGE_START = "<span class='badge";
    public static final String TAG_END = "'>";
    public static final String SPAN_CLOSE_TAG = "</span>";

    private LabelFields() {
    }
}