package com.twozo.commons.json.codec;

import com.twozo.commons.json.codec.decoder.Decoder;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

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
 * @author Petchimuthu
 * @version 1.0
 * @see com.twozo.commons.json.codec.Codec
 */
@Value
@NonNull
@AllArgsConstructor
public class CodecImpl<T, R> implements Codec<T, R> {

    Decoder<T, R> decoder;

    /**
     * {@inheritDoc}
     *
     * @param input the input object to be encoded
     * @return the encoded representation of the input object
     */
    @Override
    public R encode(final T input) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param input the input {@link Object} to be decoded
     * @return the decoded representation of the input {@link Object}
     */
    @Override
    public R decode(final T input) {
        return decoder.decode(input);
    }
}
