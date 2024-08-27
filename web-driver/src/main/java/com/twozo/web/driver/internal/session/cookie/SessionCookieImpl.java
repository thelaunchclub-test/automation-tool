package com.twozo.web.driver.internal.session.cookie;

import com.twozo.commons.cookie.BrowserCookie;
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
 * with a custom {@link BrowserCookie} class.
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
     * @param browserCookie The cookie to be added.
     */
    @Override
    public void addCookie(final BrowserCookie browserCookie) {
        Cookie seleniumCookie = new Cookie.Builder(browserCookie.name(), browserCookie.value())
                .domain(browserCookie.domain())
                .path(browserCookie.path())
                .expiresOn(browserCookie.expiry())
                .isSecure(browserCookie.secure())
                .isHttpOnly(browserCookie.httpOnly())
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
     * @param browserCookie The cookie to be deleted.
     */
    @Override
    public void deleteCookie(final BrowserCookie browserCookie) {
        Cookie seleniumCookie = new Cookie.Builder(browserCookie.name(), browserCookie.value())
                .domain(browserCookie.domain())
                .path(browserCookie.path())
                .expiresOn(browserCookie.expiry())
                .isSecure(browserCookie.secure())
                .isHttpOnly(browserCookie.httpOnly())
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
    public Set<BrowserCookie> getCookies() {
        Set<BrowserCookie> browserCookies = new HashSet<>();
        for (Cookie seleniumCookie : options.getCookies()) {
            BrowserCookie browserCookie = new BrowserCookie(
                    seleniumCookie.getName(),
                    seleniumCookie.getValue(),
                    seleniumCookie.getPath(),
                    seleniumCookie.getDomain(),
                    seleniumCookie.getExpiry(),
                    seleniumCookie.isSecure(),
                    seleniumCookie.isHttpOnly(),
                    null
            );
            browserCookies.add(browserCookie);
        }
        return browserCookies;
    }

    /**
     * {@inheritDoc}
     *
     * @param name The name of the cookie to retrieve.
     * @return The cookie with the specified name, or {@code null} if not found.
     */
    @Override
    public BrowserCookie getCookieNamed(final String name) {
        Cookie seleniumCookie = options.getCookieNamed(name);
        if (seleniumCookie != null) {
            return new BrowserCookie(
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
