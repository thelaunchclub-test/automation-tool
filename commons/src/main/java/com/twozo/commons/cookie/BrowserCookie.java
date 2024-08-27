package com.twozo.commons.cookie;

import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

/**
 * <p>
 * Provides functionality and attributes for managing cookies.
 * </p>
 *
 * <p>
 * Encapsulates cookie properties like name,value, path, domain, expiry date, and security settings,
 * along with `SameSite` attribute support, enabling more flexible and secure cookie handling during web testing
 * and automation.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@NonNull
public record BrowserCookie(String name, String value, String path, String domain, Date expiry, boolean secure,
                            boolean httpOnly, String sameSite) {
}