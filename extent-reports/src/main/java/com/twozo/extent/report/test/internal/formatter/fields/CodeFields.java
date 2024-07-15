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
public class CodeFields {

    public static final String CODE = "code";
    public static final String INDEX = "INDEX";
    public static final String JSON_TEMPLATE_FILE_NAME = "codeblock.json.ftl";
    public static final String DEFAULT_TEMPLATE_FILE_NAME = "codeblock.ftl";
    public static final String EMPTY_STRING = "";

    private CodeFields() {
    }
}