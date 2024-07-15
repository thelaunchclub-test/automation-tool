package com.twozo.extent.report.reporter.util;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.extent.report.reporter.error.code.ExtentReportErrorCode;
import lombok.Getter;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Value
public class PropertyReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyReader.class);

    private PropertyReader() {
    }

    /**
     * <p>
     * Reads properties from a specified file.
     * </p>
     *
     * @param fileName The name of the properties file to read.
     * @return         A map containing key-value pairs of properties read from the file.
     */
    public static Map<String, String> get(String fileName) throws IOException {
        final File file = new File(ENVUtility.getConf(), fileName);

        if (!file.exists()) {
            LOGGER.error("PropertyReader : Properties file not found" + fileName);
            throw ErrorCode.get(ExtentReportErrorCode.FILE_NOT_FOUND);
        }

        final Properties properties = new Properties();

        try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
        }

        return properties.stringPropertyNames().stream()
                .collect(Collectors.toMap(key -> key, properties::getProperty));
    }
}