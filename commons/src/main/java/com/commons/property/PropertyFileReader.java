package com.commons.property;

import com.commons.util.DirectoryInfo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads getProperty from a configuration file.
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public final class PropertyFileReader {

    /**
     * Read getProperty from the configuration file.
     *
     * @return Properties object containing the key-value pairs from the configuration file.
     */
    public static Properties read() {
        final Properties properties = new Properties();
        final File file = new File(DirectoryInfo.getConfDirectory(), "config.properties");
        final String filePath = file.getAbsolutePath();

        try (final FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);

        } catch (Exception e) {
            System.err.println("Error loading getProperty file: " + e.getMessage());
        }

        return properties;
    }
}
