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
 * @author petchimuthu1520
 * @version 1.0
 */
public final class PropertyFileReader {

    private static final String PATH = getPath();
    private static PropertyFileReader propertyFileReader;

    private PropertyFileReader() {
    }

    /**
     * <p>
     * Retrieves the path to the configuration file.
     * </p>
     *
     * @return The absolute path to the configuration file.
     */
    private static String getPath() {
        final StringBuilder builder = new StringBuilder(System.getProperty("user.dir"));

        builder.append(File.separator)
                .append("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("resources");

        return builder.toString();
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
        final File file = new File(PATH, "config.properties");
        final String filePath = file.getAbsolutePath();

        try (final FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.err.println("Error loading getProperty file: " + e.getMessage());
        }

        return properties;
    }
}