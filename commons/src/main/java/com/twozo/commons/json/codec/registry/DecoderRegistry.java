package com.twozo.commons.json.codec.registry;

import com.twozo.commons.json.codec.decoder.*;

import java.io.File;
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
public final class DecoderRegistry {

    private final Map<Class<?>, Decoder<?, ?>> registry;

    public DecoderRegistry(){
        this.registry = new HashMap<>();
        register();
    }

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
    public <T, R> Decoder<T, R> get(final Class<T> inputType) {
        final Decoder<?, ?> decoder = registry.get(inputType);

        if (Objects.isNull(decoder)) {
            throw new IllegalArgumentException("No decoder registered for input" ); // TODO: Replace generic catch block with proper exception handling
        }

        return (Decoder<T, R>) decoder;
    }

    /**
     * <p>
     * Registers various decoders for different input types.
     * </p>
     */
    private void register(){
        registerDecoder(String.class, new StringToListDecoder());
        registerDecoder(String.class, new StringToMapDecoder());
        registerDecoder(File.class, new FileToMapDecoder());
        registerDecoder(File.class, new FileToListDecoder());
    }
}
