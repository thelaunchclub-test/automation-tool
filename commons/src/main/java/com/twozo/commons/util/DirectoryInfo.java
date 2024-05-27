package com.twozo.commons.util;

import java.io.File;

/**
 * <p>
 * Provides utility methods to retrieve directory paths related to the user's home directory.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * String seleniumDir = DirectoryInfo.getSeleniumDirectory();
 * }</pre>
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public final class DirectoryInfo {

    private static final String USER_HOME = System.getProperty("user.home");
    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String SELENIUM = String.format("%s%sselenium", USER_HOME, File.separator);
    private static final String FILE = String.format("%s%sfile", SELENIUM, File.separator);
    private static final String JSON = String.format("%s%sjson", SELENIUM, File.separator);
    private static final String CONF = String.format("%s%ssrc", USER_DIRECTORY, File.separator);

    /**
     * Returns the path of the user's home directory.
     *
     * @return the path of the user's home directory
     */
    public static String getUserHomeDirectory() {
        return USER_HOME;
    }

    /**
     * Returns the path of the selenium directory located in the user's home directory.
     *
     * @return the path of the selenium directory
     */
    public static String getSeleniumDirectory() {
        return SELENIUM;
    }

    /**
     * Returns the path of the file directory located in the selenium directory.
     *
     * @return the path of the file directory
     */
    public static String getFileDirectory() {
        return FILE;
    }

    /**
     * Returns the path of the JSON directory located in the selenium directory.
     *
     * @return the path of the JSON directory
     */
    public static String getJsonDirectory() {
        return JSON;
    }

    /**
     * Returns the path of the conf directory located in the selenium directory.
     *
     * @return the path of the conf directory
     */
    public static String getConfDirectory() {
        return CONF;
    }
}
