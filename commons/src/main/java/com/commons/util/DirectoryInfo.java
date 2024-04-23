package com.commons.util;

import java.io.File;

public class DirectoryInfo {

    private static final String USER_HOME = System.getProperty("user.home");
    private static final String SELENIUM = USER_HOME + File.separator + "selenium";
    private static final String FILE = SELENIUM + File.separator + "file";
    private static final String json = SELENIUM + File.separator + "json";
    private static final String CONF = SELENIUM + File.separator + "conf";

    public static String getUserHomeDirectory() {
        return USER_HOME;
    }

    public static String getSeleniumDirectory() {
        return SELENIUM;
    }

    public static String getFileDirectory() {
        return FILE;
    }

    public static String getJsonDirectory() {
        return json;
    }

    public static String getConfDirectory() {
        return CONF;
    }

}
