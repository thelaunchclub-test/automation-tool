package com.twozo.web.driver.service;

import org.openqa.selenium.Cookie;

import java.util.Set;

public interface Cookies {

    void addCookie(final Cookie cookie);

    void deleteCookieNamed(final String name);

    void deleteCookie(final Cookie cookie);

    void deleteAllCookies();

    Set<Cookie> getCookies();

    Cookie getCookieNamed(final String name);

}
