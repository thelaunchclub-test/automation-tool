package com.twozo.web.driver.internal.cookie;

import com.twozo.commons.cookie.BrowserCookie;
import com.twozo.web.driver.service.SessionCookie;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver.Options;

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
public final class SessionCookieImpl implements SessionCookie {

    private final Options options;

    /**
     * Converts a {@link BrowserCookie} to a Selenium {@link Cookie}.
     *
     * @param browserCookie The cookie to convert.
     * @return The corresponding Selenium {@link Cookie}.
     */
    private Cookie toSeleniumCookie(BrowserCookie browserCookie) {
        return new Cookie.Builder(browserCookie.name(), browserCookie.value())
                .domain(browserCookie.domain())
                .path(browserCookie.path())
                .expiresOn(browserCookie.expiry())
                .isSecure(browserCookie.secure())
                .isHttpOnly(browserCookie.httpOnly())
                .build();
    }

    /**
     * Converts a Selenium {@link Cookie} to a {@link BrowserCookie}.
     *
     * @param seleniumCookie The Selenium cookie to convert.
     * @return The corresponding {@link BrowserCookie}.
     */
    private BrowserCookie toBrowserCookie(Cookie seleniumCookie) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCookie(final BrowserCookie browserCookie) {
        options.addCookie(toSeleniumCookie(browserCookie));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCookieNamed(final String name) {
        options.deleteCookieNamed(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCookie(final BrowserCookie browserCookie) {
        options.deleteCookie(toSeleniumCookie(browserCookie));
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
        final Set<BrowserCookie> browserCookies = new HashSet<>();

        for (final Cookie seleniumCookie : options.getCookies()) {
            browserCookies.add(toBrowserCookie(seleniumCookie));
        }

        return browserCookies;
    }

    /**
     * {@inheritDoc}
     *
     * @return A set of all cookies in the current session.
     */
    @Override
    public BrowserCookie getCookieNamed(final String name) {
        final Cookie seleniumCookie = options.getCookieNamed(name);

        return seleniumCookie != null ? toBrowserCookie(seleniumCookie) : null;
    }
}
