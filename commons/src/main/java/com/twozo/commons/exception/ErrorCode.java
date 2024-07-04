package com.twozo.commons.exception;

import com.twozo.commons.exception.service.ErrorCodeProvider;

import lombok.AllArgsConstructor;

/**
 * <p>
 * Manages errors with associated error codes and messages.
 * </p>
 *
 * <p>
 * Provides additional context through messages and causes. Ensures a standardized way of
 * handling and reporting issues in the application by associating each error
 * with a specific error code.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * throw ErrorCode.get(CommonsErrorCode.INVALID_BASE_CODE_VALUE);
 * }
 * </pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see RuntimeException
 */
@AllArgsConstructor
public final class ErrorCode extends RuntimeException {

    private final ErrorCodeProvider errorCodeProvider;

    public ErrorCode(final ErrorCodeProvider errorCodeProvider, final String message) {
        super(message);
        this.errorCodeProvider = errorCodeProvider;
    }

    public ErrorCode(final ErrorCodeProvider errorCodeProvider, final Throwable cause) {
        super(cause);
        this.errorCodeProvider = errorCodeProvider;
    }

    public ErrorCode(final ErrorCodeProvider errorCodeProvider, final String message, final Throwable cause) {
        super(message, cause);
        this.errorCodeProvider = errorCodeProvider;
    }

    /**
     * <p>
     * Creates an {@code ErrorCode} with the specified error code.
     * </p>
     *
     * @param errorCodeProvider The {@link ErrorCodeProvider} associated with the error.
     * @return An{@code ErrorCode} .
     */
    public static ErrorCode get(final ErrorCodeProvider errorCodeProvider) {
        return new ErrorCode(errorCodeProvider);
    }

    /**
     * <p>
     * Creates {@code ErrorCode} with the specified error code and message.
     * </p>
     *
     * @param errorCodeProvider The {@link ErrorCodeProvider} associated with the error.
     * @param message           The message describing the error.
     * @return An {@code ErrorCode}.
     */
    public static ErrorCode get(final ErrorCodeProvider errorCodeProvider, final String message) {
        return new ErrorCode(errorCodeProvider, message);
    }

    /**
     * <p>
     * Creates {@code ErrorCode} with the specified error code and cause.
     * </p>
     *
     * @param errorCodeProvider The {@link ErrorCodeProvider} associated with the error.
     * @param cause             The cause of the error.
     * @return An {@code ErrorCode}.
     */
    public static ErrorCode get(final ErrorCodeProvider errorCodeProvider, final Throwable cause) {
        return new ErrorCode(errorCodeProvider, cause);
    }

    /**
     * <p>
     * Creates {@code ErrorCode} with the specified error code, message, and cause.
     * </p>
     *
     * @param errorCodeProvider The {@link ErrorCodeProvider} associated with the error.
     * @param message           The message describing the error.
     * @param cause             The cause of the error.
     * @return An {@code ErrorCode}.
     */
    public static ErrorCode get(final ErrorCodeProvider errorCodeProvider, final String message, final Throwable cause) {
        return new ErrorCode(errorCodeProvider, message, cause);
    }

    /**
     * <p>
     * Retrieves the error code from the error code provider.
     * </p>
     *
     * @return The error code.
     */
    public int getErrorCode() {
        return errorCodeProvider.getErrorCode();
    }

    /**
     * <p>
     * Retrieves the message associated with the {@code ErrorCode}.
     * </p>
     *
     * @return The message.
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * <p>
     * Prints the stack trace of the {@code ErrorCode}.
     * </p>
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    /**
     * <p>
     * Customizes the stack trace filling behavior.
     * </p>
     *
     * @return Reference to the {@link Throwable}.
     */
    @Override
    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
