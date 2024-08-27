package com.twozo.commons.cookie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

/**
 * <p>
 * Provides functionality and attributes for managing cookies. Encapsulates cookie properties like name,
 * value, path, domain, expiry date, and security settings, along with `SameSite` attribute support, enabling more
 * flexible and secure cookie handling during web testing and automation.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@NonNull
@AllArgsConstructor
@Getter
public class HttpCookie {

    private final String name;
    private final String value;
    private final String path;
    private final String domain;
    private final Date expiry;
    private final boolean isSecure;
    private final boolean isHttpOnly;
    private final String sameSite;
}