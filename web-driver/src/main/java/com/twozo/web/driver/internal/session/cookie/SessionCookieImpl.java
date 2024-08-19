package com.twozo.web.driver.internal.session.cookie;

import com.twozo.web.driver.service.SessionCookie;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver.Options;

import java.util.Set;

/**
 * <p>
 * Defines a contract for components capable of managing browser session cookies.
 * Provides methods to add, delete, and retrieve cookies within a session.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * sessionCookie.addCookie(new Cookie("name", "value"));
 * Set<Cookie> cookies = sessionCookie.getCookies();
 * sessionCookie.deleteAllCookies();
 * }</pre>
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see SessionCookie
 */
@NonNull
@AllArgsConstructor
public class SessionCookieImpl implements SessionCookie {

    private final Options options;

    /**
     * {@inheritDoc}
     *
     * @param cookie The cookie to be added.
     */
    @Override
    public void addCookie(final Cookie cookie) {
        options.addCookie(cookie);
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
     * @param cookie The cookie to be deleted.
     */
    @Override
    public void deleteCookie(final Cookie cookie) {
        options.deleteCookie(cookie);
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
    public Set<Cookie> getCookies() {
        return options.getCookies();
    }

    /**
     * {@inheritDoc}
     *
     * @param name The name of the cookie to retrieve.
     * @return The cookie with the specified name, or {@code null} if not found.
     */
    @Override
    public Cookie getCookieNamed(final String name) {
        return options.getCookieNamed(name);
    }
}
