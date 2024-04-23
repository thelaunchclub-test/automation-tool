package com.commons.json;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Provides methods to wrap a List of Objects into a JsonArray and a Map into a JsonObject.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonWrapper {

    /**
     * Wraps a List of Objects into a JsonArray.
     *
     * @param list The List of Objects to wrap.
     * @return A JsonArray containing the wrapped list.
     */
    JsonArray wrappedJsonArray(final List<Object> list);

    /**
     * Wraps a Map of key-value pairs into a JsonObject.
     *
     * @param map The Map of key-value pairs to wrap.
     * @return A JsonObject containing the wrapped map.
     */
    JsonObject wrappedJsonObject(final Map<String, Object> map);

}