package com.twozo.web.mouse.service.actions;

import com.twozo.web.element.model.Element;
import com.twozo.web.mouse.service.action.MouseAction;

/**
 * <p>
 * Provides methods to perform various mouse actions on web elements.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * actions.moveToElement(element).click().perform();
 * }</pre>
 * </p>
 *
 * @version 1.0
 * @see MouseAction
 */
public interface MouseActions {

    /**
     * <p>
     * Presses a key on the keyboard.
     * </p>
     *
     * @param key The key to press.
     * @return The {@code MouseActions}.
     */
    MouseActions keyDown(final CharSequence key);

    /**
     * <p>
     * Presses a key on the keyboard while focusing on a specific element.
     * </p>
     *
     * @param element The element to focus on.
     * @param key     The key to press.
     * @return The {@code MouseActions}.
     */
    MouseActions keyDown(final Element element, final CharSequence key);

    /**
     * <p>
     * Releases a pressed key on the keyboard.
     * </p>
     *
     * @param key The key to release.
     * @return The {@code MouseActions}.
     */
    MouseActions keyUp(final CharSequence key);

    /**
     * <p>
     * Releases a pressed key on the keyboard while focusing on a specific element.
     * </p>
     *
     * @param element The element to focus on.
     * @param key     The key to release.
     * @return The {@code MouseActions}.
     */
    MouseActions keyUp(final Element element, final CharSequence key);

    /**
     * <p>
     * Sends a sequence of keys to the web browser.
     * </p>
     *
     * @param keys The sequence of keys to send.
     * @return The {@code MouseActions}.
     */
    MouseActions sendKeys(final CharSequence... keys);

    /**
     * <p>
     * Sends a sequence of keys to a specific element.
     * </p>
     *
     * @param element The element to send the keys to.
     * @param keys    The sequence of keys to send.
     * @return The {@code MouseActions}.
     */
    MouseActions sendKeys(final Element element, final CharSequence... keys);

    /**
     * <p>
     * Clicks and holds the left mouse button.
     * </p>
     *
     * @return The {@code MouseActions}.
     */
    MouseActions clickAndHold();

    /**
     * <p>
     * Clicks and holds the left mouse button on a specific element.
     * </p>
     *
     * @param element The element to click and hold on.
     * @return The {@code MouseActions}.
     */
    MouseActions clickAndHold(final Element element);

    /**
     * <p>
     * Releases the left mouse button on a specific element.
     * </p>
     *
     * @param element The element to release the button on.
     * @return The {@code MouseActions}.
     */
    MouseActions release(final Element element);

    /**
     * <p>
     * Releases the left mouse button.
     * </p>
     *
     * @return The {@code MouseActions}.
     */
    MouseActions release();

    /**
     * <p>
     * Scrolls to a specific element.
     * </p>
     *
     * @param element The element to scroll to.
     * @return The {@code MouseActions}.
     */
    MouseActions scrollToElement(final Element element);

    /**
     * <p>
     * Clicks the left mouse button.
     * </p>
     *
     * @return The {@code MouseActions}.
     */
    MouseActions click();

    /**
     * <p>
     * Clicks the left mouse button on a specific element.
     * </p>
     *
     * @param element The element to click on.
     * @return The {@code MouseActions}.
     */
    MouseActions click(final Element element);

    /**
     * <p>
     * Double-clicks the left mouse button.
     * </p>
     *
     * @return The {@code MouseActions}.
     */
    MouseActions doubleClick();

    /**
     * <p>
     * Double-clicks the left mouse button on a specific element.
     * </p>
     *
     * @param element The element to double-click on.
     * @return The {@code MouseActions}.
     */
    MouseActions doubleClick(final Element element);

    /**
     * <p>
     * Moves the mouse to a specific element.
     * </p>
     *
     * @param element The element to move the mouse to.
     * @return The {@code MouseActions}.
     */
    MouseActions moveToElement(final Element element);

    /**
     * <p>
     * Moves the mouse to a specific element with an offset.
     * </p>
     *
     * @param element The element to move the mouse to.
     * @param xOffset The horizontal offset.
     * @param yOffset The vertical offset.
     * @return The {@code MouseActions}.
     */
    MouseActions moveToElement(final Element element, final int xOffset, final int yOffset);

    /**
     * <p>
     * Moves the mouse to a specific location on the screen.
     * </p>
     *
     * @param xCoordinate The X coordinate.
     * @param yCoordinate The Y coordinate.
     * @return The {@code MouseActions}.
     */
    MouseActions moveToLocation(final int xCoordinate, final int yCoordinate);

    /**
     * <p>
     * Right-clicks the mouse.
     * </p>
     *
     * @return The {@code MouseActions}.
     */
    MouseActions rightClick();

    /**
     * <p>
     * Right-clicks the mouse on a specific element.
     * </p>
     *
     * @param element The element to right-click on.
     * @return The {@code MouseActions}.
     */
    MouseActions rightClick(final Element element);

    /**
     * <p>
     * Drags an element and drops it onto another element.
     * </p>
     *
     * @param source      The element to drag.
     * @param destination The element to drop onto.
     * @return The {@code MouseActions}.
     */
    MouseActions dragAndDrop(final Element source, final Element destination);

    /**
     * <p>
     * Drags an element and drops it by an offset.
     * </p>
     *
     * @param source  The element to drag.
     * @param xOffset The horizontal offset to drop by.
     * @param yOffset The vertical offset to drop by.
     * @return The {@code MouseActions}.
     */
    MouseActions dragAndDropBy(final Element source, final int xOffset, final int yOffset);

    /**
     * <p>
     * Builds the sequence of mouse actions.
     * </p>
     *
     * @return A {@link MouseAction} representing the built sequence of actions.
     */
    MouseAction build();

    /**
     * <p>
     * Performs the sequence of mouse actions.
     * </p>
     */
    void perform();
}
