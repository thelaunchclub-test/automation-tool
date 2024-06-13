package com.twozo.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * <p>
 * provides methods to retrieve key-value pairs from a configuration file.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public final class PropertyFileReader {

    private static PropertyFileReader propertyFileReader;

    private PropertyFileReader() {
    }

    /**
     * <p>
     * Retrieves {@link PropertyFileReader}.
     * </p>
     *
     * @return The {@link PropertyFileReader}.
     */
    public static PropertyFileReader getInstance() {

        if (Objects.isNull(propertyFileReader)) {
            propertyFileReader = new PropertyFileReader();
        }

        return propertyFileReader;
    }

    /**
     * <p>
     * Reads {@link Properties} from the configuration file.
     * </p>
     *
     * @return {@link Properties} containing the key-value pairs from the configuration file.
     */
    public Properties getProperty() {
        final Properties properties = new Properties();

        try (final FileInputStream fileInputStream = new FileInputStream(new File(DirectoryInfo.
                getConfDirectory(), "config.properties").getAbsolutePath())) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.err.println("Error loading getProperty file: " + e.getMessage());
        }

        return properties;
    }
}