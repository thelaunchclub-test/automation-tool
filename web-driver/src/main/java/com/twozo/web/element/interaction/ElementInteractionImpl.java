package com.twozo.web.element.interaction;

import com.twozo.web.element.web.page.element.WebPageElement;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * The {@code ElementInteractionImpl} interacts with {@link WebPageElement}.
 * </p>
 *
 * <p>
 * Interactions with web page elements such as clicking,
 * submitting forms, and sending keys.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see ElementInteraction
 */
@NonNull
@AllArgsConstructor
public final class ElementInteractionImpl implements ElementInteraction {

    private final WebElement element;

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
