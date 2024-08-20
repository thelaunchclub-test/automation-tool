package com.twozo.web.driver.internal.session.cookie;

import com.twozo.commons.cookie.HttpCookie;
import com.twozo.web.driver.service.SessionCookie;


import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebDriver.Options;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * Implementation of the {@link SessionCookie} interface that wraps Selenium's {@link HttpCookie}
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
        options.addCookie(httpCookie.toSeleniumCookie());
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
        options.deleteCookie(httpCookie.toSeleniumCookie());
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
        return options.getCookies().stream()
                .map(HttpCookie::fromSeleniumCookie)
                .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     *
     * @param name The name of the cookie to retrieve.
     * @return The cookie with the specified name, or {@code null} if not found.
     */
    @Override
    public HttpCookie getCookieNamed(final String name) {
        return options.getCookieNamed(name) != null ?
                HttpCookie.fromSeleniumCookie(options.getCookieNamed(name)) :
                null;
    }
}
