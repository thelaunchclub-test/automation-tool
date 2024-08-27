package com.twozo.web.driver.internal.session.cookie;

import com.twozo.commons.cookie.HttpCookie;
import com.twozo.web.driver.service.SessionCookie;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.Cookie;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Implementation of the {@link SessionCookie} interface that wraps Selenium's {@link Cookie}
 * with a custom {@link HttpCookie} class.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
@NonNull
@AllArgsConstructor
public class SessionCookieImpl implements SessionCookie {

    private final Options options;

    /**
     * {@inheritDoc}
     *
     * @param httpCookie The cookie to be added.
     */
    @Override
    public void addCookie(final HttpCookie httpCookie) {
        Cookie seleniumCookie = new Cookie.Builder(httpCookie.getName(), httpCookie.getValue())
                .domain(httpCookie.getDomain())
                .path(httpCookie.getPath())
                .expiresOn(httpCookie.getExpiry())
                .isSecure(httpCookie.isSecure())
                .isHttpOnly(httpCookie.isHttpOnly())
                .build();
        options.addCookie(seleniumCookie);
    }

    /**
     * {@inheritDoc}
     *
     * @param name The name of the cookie to be deleted.
     */
    @Override
    public void deleteCookieNamed(final String name) {
        options.deleteCookieNamed(name);
    }

    /**
     * {@inheritDoc}
     *
     * @param httpCookie The cookie to be deleted.
     */
    @Override
    public void deleteCookie(final HttpCookie httpCookie) {
        Cookie seleniumCookie = new Cookie.Builder(httpCookie.getName(), httpCookie.getValue())
                .domain(httpCookie.getDomain())
                .path(httpCookie.getPath())
                .expiresOn(httpCookie.getExpiry())
                .isSecure(httpCookie.isSecure())
                .isHttpOnly(httpCookie.isHttpOnly())
                .build();
        options.deleteCookie(seleniumCookie);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllCookies() {
        options.deleteAllCookies();
    }

    /**
     * {@inheritDoc}
     *
     * @return A set of all cookies in the current session.
     */
    @Override
    public Set<HttpCookie> getCookies() {
        Set<HttpCookie> httpCookies = new HashSet<>();
        for (Cookie seleniumCookie : options.getCookies()) {
            HttpCookie httpCookie = new HttpCookie(
                    seleniumCookie.getName(),
                    seleniumCookie.getValue(),
                    seleniumCookie.getPath(),
                    seleniumCookie.getDomain(),
                    seleniumCookie.getExpiry(),
                    seleniumCookie.isSecure(),
                    seleniumCookie.isHttpOnly(),
                    null
            );
            httpCookies.add(httpCookie);
        }
        return httpCookies;
    }

    /**
     * {@inheritDoc}
     *
     * @param name The name of the cookie to retrieve.
     * @return The cookie with the specified name, or {@code null} if not found.
     */
    @Override
    public HttpCookie getCookieNamed(final String name) {
        Cookie seleniumCookie = options.getCookieNamed(name);
        if (seleniumCookie != null) {
            return new HttpCookie(
                    seleniumCookie.getName(),
                    seleniumCookie.getValue(),
                    seleniumCookie.getPath(),
                    seleniumCookie.getDomain(),
                    seleniumCookie.getExpiry(),
                    seleniumCookie.isSecure(),
                    seleniumCookie.isHttpOnly(),
                    null
            );
        }
        return null;
    }
}
