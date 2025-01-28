package com.twozo.commons.util;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.commons.exception.error.code.CommonsErrorCode;

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
 * provides methods to retrieve key-value pairs from a configuration file.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public final class ConfigFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigFileReader.class);

    /**
     * <p>
     * Reads {@link Properties} from the configuration file.
     * </p>
     *
     * @return {@link Properties} containing the key-value pairs from the configuration file.
     */
    public static Map<String, String> get(final String fileName) {
        final File file = new File(EnvUtility.getConfDirectory(), fileName);

        if (!file.exists()) {
            LOGGER.error("Commons : The given file path '{}' is not found", file.getAbsolutePath());
            throw ErrorCode.get(CommonsErrorCode.FILE_NOT_FOUND);
        }
        final Properties properties = new Properties();

        try (final FileReader reader = new FileReader(file)) {
            properties.load(reader);
        } catch (IOException exception) {
            LOGGER.error("Commons : The file '{}' can't be read", file.getAbsolutePath());
            throw ErrorCode.get(CommonsErrorCode.CANNOT_READ);
        }

        return properties.stringPropertyNames().stream()
                .collect(Collectors.toMap(key -> key, properties::getProperty));
    }
}