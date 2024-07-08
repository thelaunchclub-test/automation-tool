package com.twozo.extent.report.reporter.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * <p>
 * Utility class for reading properties from a file.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 */
public final class PropertyReader {

    /**
     * Reads properties from a specified file.
     *
     * @param fileName The name of the properties file to read.
     * @return A map containing key-value pairs of properties read from the file.
     */
    public static Map<String, String> get(String fileName) throws IOException {
        final File file = new File(ENVUtility.getResources(), fileName);

        if (!file.exists()) {
            throw new IOException("Properties file not found: " + fileName);
        }

        final Properties properties = new Properties();

        try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
        }

        return properties.stringPropertyNames().stream()
                .collect(Collectors.toMap(key -> key, properties::getProperty));
    }

    public static void main(String[] args) {
        System.out.println(ENVUtility.getResources());
    }
}