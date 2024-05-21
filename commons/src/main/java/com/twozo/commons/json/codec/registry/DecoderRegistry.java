package com.twozo.commons.json.codec.registry;

import com.twozo.commons.json.codec.decoder.Decoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * The {@code DecoderRegistry} is a registry for managing different types of Decoders.
 * Allows registration of decoders for specific input types and provides
 * the appropriate decoder based on the input type.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 */
public class DecoderRegistry {

    private final Map<Class<?>, Decoder<?, ?>> registry = new HashMap<>();

    /**
     * Registers a {@link Decoder} for a specific input type.
     *
     * @param <T>       The type of the input that the {@link Decoder} will process.
     * @param <R>       The type of the output that the {@link Decoder} will produce.
     * @param inputType The {@link Class} of the input type.
     * @param decoder   The {@link Decoder} instance.
     */
    public <T, R> void registerDecoder(final Class<T> inputType, final Decoder<T, R> decoder) {
        registry.put(inputType, decoder);
    }

    /**
     * Retrieves the appropriate {@link Decoder} for the given input type.
     *
     * @param <T>       The type of the input that the {@link Decoder} will process.
     * @param <R>       The type of the output that the {@link Decoder} will produce.
     * @param inputType The {@link Class} of the input type.
     * @return The {@link Decoder} for the specified input type.
     * @throws IllegalArgumentException if no {@link Decoder} is registered for the given input type.
     */
    public <T, R> Decoder<T, R> getDecoder(final Class<T> inputType) {
        final Decoder<?, ?> decoder = registry.get(inputType);

        if (Objects.isNull(decoder)) {
            throw new IllegalArgumentException("No decoder registered for input type: " + inputType.getName());
        }
        return (Decoder<T, R>) decoder;
    }
}
