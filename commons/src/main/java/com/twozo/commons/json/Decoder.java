package com.twozo.commons.json;

/**
 * <p>
 * Decodes JSON data into Java objects.
 *
 * Defines a generic contract for classes that are responsible for decoding
 * JSON data into {@link Object}.
 * </p>
 *
 * <p>
 * The {@code decode} allows for flexible handling of different types of JSON input,
 * such as JSON strings, files containing JSON data. Encapsulate the logic for parsing
 * and converting JSON data into Java objects, enabling diverse JSON sources and formats
 * to be processed.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public interface Decoder<R> {

    /**
     * Decodes the given object into a Java object of type {@code R}.
     *
     * @param object The object to be decoded, typically representing JSON data.
     * @return The decoded Java object of type {@code R}.
     */
    R decode(final Object object);
}
