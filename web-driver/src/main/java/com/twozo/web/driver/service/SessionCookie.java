package com.twozo.web.driver.service;

import com.twozo.commons.cookie.HttpCookie;

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
 */
public interface SessionCookie {

    /**
     * <p>
     * Adds a cookie to the current session.
     * </p>
     *
     * @param httpCookie The cookie to be added.
     */
    void addCookie(final HttpCookie httpCookie);

    /**
     * <p>
     * Deletes a cookie by its name from the current session.
     * </p>
     *
     * @param name The name of the cookie to be deleted.
     */
    void deleteCookieNamed(final String name);

    /**
     * <p>
     * Deletes a specific cookie from the current session.
     * </p>
     *
     * @param httpCookie The cookie to be deleted.
     */
    void deleteCookie(final HttpCookie httpCookie);

    /**
     * <p>
     * Deletes all cookies from the current session.
     * </p>
     */
    void deleteAllCookies();

    /**
     * <p>
     * Retrieves all cookies present in the current session.
     * </p>
     *
     * @return A set of all cookies in the current session.
     */
    Set<HttpCookie> getCookies();

    /**
     * <p>
     * Retrieves a specific cookie by its name from the current session.
     * </p>
     *
     * @param name The name of the cookie to retrieve.
     * @return The cookie with the specified name, or {@code null} if not found.
     */
    HttpCookie getCookieNamed(final String name);
}
