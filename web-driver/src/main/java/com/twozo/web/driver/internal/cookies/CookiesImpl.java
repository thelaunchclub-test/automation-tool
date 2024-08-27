package com.twozo.web.driver.internal.cookies;

import com.twozo.web.driver.service.Cookies;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver.Options;

import java.util.Set;

@NonNull
@AllArgsConstructor
public class CookiesImpl implements Cookies {

    private final Options options;

    @Override
    public void addCookie(final Cookie cookie) {
        options.addCookie(cookie);
    }

    @Override
    public void deleteCookieNamed(final String name) {
        options.deleteCookieNamed(name);
    }

    @Override
    public void deleteCookie(final Cookie cookie) {
        options.deleteCookie(cookie);
    }

    @Override
    public void deleteAllCookies() {
        options.deleteAllCookies();
    }

    @Override
    public Set<Cookie> getCookies() {
        return options.getCookies();
    }

    @Override
    public Cookie getCookieNamed(final String name) {
        return options.getCookieNamed(name);
    }
}