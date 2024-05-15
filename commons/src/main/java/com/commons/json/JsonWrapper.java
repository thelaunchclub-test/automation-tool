package com.commons.json;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Provides methods to wrap a {@link List} of Objects into a {@link JsonArray} and a {@link Map} into a {@link JsonObject}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * JsonArray jsonArray = Json.array(file);
 * List<Object> dataList = new ArrayList<>();
 * JsonArray jsonArray = jsonArray.wrappedJsonArray(dataList);
 * }</pre>
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 */
public interface JsonWrapper {

    /**
     * <p>
     * Wraps a {@link List} of Objects into a {@link JsonArray}.
     * </p>
     *
     * @param list The {@link List} of Objects to wrap.
     * @return A {@link JsonArray} containing the wrapped {@link List}.
     */
    JsonArray wrappedJsonArray(final List<Object> list);

    /**
     * <p>
     * Wraps a {@link Map} of key-value pairs into a {@link JsonObject}.
     * </p>
     *
     * @param map The {@link Map} of key-value pairs to wrap.
     * @return A {@link JsonObject} containing the wrapped {@link Map}.
     */
    JsonObject wrappedJsonObject(final Map<String, Object> map);
}
