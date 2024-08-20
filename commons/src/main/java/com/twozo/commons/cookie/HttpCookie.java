package com.twozo.commons.cookie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.Cookie;

import java.util.Date;

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

    public Cookie toSeleniumCookie() {
        return new Cookie.Builder(name, value)
                .domain(domain)
                .path(path)
                .expiresOn(expiry)
                .isSecure(isSecure)
                .isHttpOnly(isHttpOnly)
                .build();
    }

    public static HttpCookie fromSeleniumCookie(final Cookie cookie) {
        return new HttpCookie(
                cookie.getName(),
                cookie.getValue(),
                cookie.getPath(),
                cookie.getDomain(),
                cookie.getExpiry(),
                cookie.isSecure(),
                cookie.isHttpOnly(),
                null
        );
    }
}