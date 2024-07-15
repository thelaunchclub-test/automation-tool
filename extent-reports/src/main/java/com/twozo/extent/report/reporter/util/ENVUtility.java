package com.twozo.extent.report.reporter.util;

import lombok.Value;

import java.io.File;

/**
 * <p>
 * Utility class for managing environment-related paths in the project.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
@Value
public class ENVUtility {

    private static final String SEPARATOR = File.separator;
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String AUTOMATION_TOOL = String.format("%s%s%s", USER_DIRECTORY, SEPARATOR, "automation-tool");
    private static final String EXTENT_REPORT = String.format("%s%s%s", AUTOMATION_TOOL, SEPARATOR, "extent-reports");
    private static final String CONF = String.format("%s%s%s%s%s%s%s", EXTENT_REPORT, SEPARATOR, "src", SEPARATOR, "main", SEPARATOR, "resources");

    private ENVUtility() {
    }

    /**
     * <p>
     * Returns the constructed path to the "resources" directory.
     * </p>
     *
     * @return the path to the "resources" directory.
     */
    public static String getConf() {
        return CONF;
    }
}

