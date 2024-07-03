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
 * String seleniumDir = DirectoryUtility.getAutomationToolDirectory();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public final class DirectoryUtility {

    private static final String separator = File.separator;
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String USER_DIRECTORY = System.getProperty("user.dir");
    private static final String AUTOMATION_TOOL = String.format("%s%s%s", USER_HOME, separator, "automation tool");
    private static final String FILE = String.format("%s%s%s", AUTOMATION_TOOL, separator,"file");
    private static final String JSON = String.format("%s%s%s", AUTOMATION_TOOL, separator,"json");
    private static final String CONF = USER_DIRECTORY + File.separator + "src"+"main"+"resources";

    /**
     * Returns the path of the user's home directory.
     *
     * @return the path of the user's home directory
     */
    public static String getUserHomeDirectory() {
        return USER_HOME;
    }

    /**
     * Returns the path of the user's directory.
     *
     * @return the path of the user's directory
     */
    public static String getUserDirectory() {
        return USER_DIRECTORY;
    }

    /**
     * Returns the path of the selenium directory located in the user's home directory.
     *
     * @return the path of the selenium directory
     */
    public static String getAutomationToolDirectory() {
        return AUTOMATION_TOOL;
    }

    /**
     * Returns the path of the file directory located in the automation tool directory.
     *
     * @return the path of the file directory
     */
    public static String getFileDirectory() {
        return FILE;
    }

    /**
     * Returns the path of the JSON directory located in the automation tool directory.
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
