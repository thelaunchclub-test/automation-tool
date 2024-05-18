package com.twozo.commons.json.codec;

import com.twozo.commons.json.codec.decoder.Decoder;

/**
 * <p>
 * Defines methods for encoding and decoding objects.
 * </p>
 *
 * <p>
 * Converts objects of type T to a specific representation
 * of type R and vice versa.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see Codec
 */
public class CodecImpl<T, R> implements Codec<T, R> {

    private final Decoder<T, R> decoder;

    public CodecImpl(final Decoder<T, R> decoder) {
        this.decoder = decoder;
    }

    @Override
    public R encode(final T input) {
        return null;
    }

    @Override
    public R decode(final T input) {
        return decoder.decode(input);
    }
}
