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

}