package com.twozo.web.driver.element.impl;

import com.twozo.web.driver.element.service.Interaction;
import com.twozo.web.driver.element.service.WebPageElement;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * The {@code InteractionImpl} interacts with {@link WebPageElement}s using Selenium WebDriver.
 * </p>
 *
 * <p>
 * Encapsulates common interactions with web page elements such as clicking,
 * submitting forms, and sending keys.
 * </p>
 *
 * @author petchimuthu
 * @version 1.0
 * @see Interaction
 */
public final class InteractionImpl implements Interaction {

    private final WebElement element;

    public InteractionImpl(final WebElement element) {
        this.element = element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void click() {
        element.click();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void submit() {
        element.submit();
    }

    /**
     * {@inheritDoc}
     *
     * @param keysToSend The character sequences to be sent.
     */
    @Override
    public void sendKeys(final CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }
}
