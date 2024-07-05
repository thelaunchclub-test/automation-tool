package com.twozo.web.mouse.internal.actions;

import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.mouse.service.action.MouseAction;
import com.twozo.web.mouse.internal.action.MouseActionImpl;
import com.twozo.web.mouse.service.actions.MouseActions;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * <p>
 * Implementation of {@link MouseActions} providing concrete implementations for mouse actions using {@link Actions}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see MouseAction
 */
@NonNull
@AllArgsConstructor
public class MouseActionsImpl implements MouseActions {

    private final WebDriver webDriver;
    private final Actions actions;

    /**
     * {@inheritDoc}
     *
     * @param key The key to press.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions keyDown(@NonNull final CharSequence key) {
        return new MouseActionsImpl(webDriver, actions.keyDown(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to focus on.
     * @param key The key to press.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions keyDown(@NonNull final Element element, @NonNull final CharSequence key) {
        return new MouseActionsImpl(webDriver, actions.keyDown(webDriver.findElement(getByValue(element)), key));
    }

    /**
     * {@inheritDoc}
     *
     * @param key The key to release.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions keyUp(@NonNull final CharSequence key) {
        return new MouseActionsImpl(webDriver, actions.keyUp(key));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to focus on.
     * @param key The key to release.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions keyUp(@NonNull final Element element, @NonNull final CharSequence key) {
        return new MouseActionsImpl(webDriver, actions.keyUp(webDriver.findElement(getByValue(element)), key));
    }

    /**
     * {@inheritDoc}
     *
     * @param keys The sequence of keys to send.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions sendKeys(@NonNull final CharSequence... keys) {
        return new MouseActionsImpl(webDriver, actions.sendKeys(keys));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to send the keys to.
     * @param keys The sequence of keys to send.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions sendKeys(@NonNull final Element element, @NonNull final CharSequence... keys) {
        return new MouseActionsImpl(webDriver, actions.sendKeys(webDriver.findElement(getByValue(element)), keys));
    }

    /**
     * {@inheritDoc}
     *
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions clickAndHold() {
        return new MouseActionsImpl(webDriver, actions.clickAndHold());
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to click and hold on.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions clickAndHold(@NonNull final Element element) {
        return new MouseActionsImpl(webDriver, actions.clickAndHold(webDriver.findElement(getByValue(element))));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to release the button on.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions release(@NonNull final Element element) {
        return new MouseActionsImpl(webDriver, actions.release(webDriver.findElement(getByValue(element))));
    }

    /**
     * {@inheritDoc}
     *
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions release() {
        return new MouseActionsImpl(webDriver, actions.release());
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to scroll to.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions scrollToElement(@NonNull final Element element) {
        return new MouseActionsImpl(webDriver, actions.scrollToElement(webDriver.findElement(getByValue(element))));
    }

    /**
     * {@inheritDoc}
     *
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions click() {
        return new MouseActionsImpl(webDriver, actions.click());
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to click on.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions click(@NonNull final Element element) {
        return new MouseActionsImpl(webDriver, actions.click(webDriver.findElement(getByValue(element))));
    }

    /**
     * {@inheritDoc}
     *
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions doubleClick() {
        return new MouseActionsImpl(webDriver, actions.doubleClick());
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to double-click on.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions doubleClick(@NonNull final Element element) {
        return new MouseActionsImpl(webDriver, actions.doubleClick(webDriver.findElement(getByValue(element))));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to move the mouse to.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions moveToElement(@NonNull final Element element) {
        return new MouseActionsImpl(webDriver, actions.moveToElement(webDriver.findElement(getByValue(element))));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to move the mouse to.
     * @param xOffset The horizontal offset.
     * @param yOffset The vertical offset.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions moveToElement(@NonNull final Element element, final int xOffset, final int yOffset) {
        return new MouseActionsImpl(webDriver, actions.moveToElement(webDriver.findElement(getByValue(element)), xOffset, yOffset));
    }

    /**
     * {@inheritDoc}
     *
     * @param xCoordinate The X coordinate.
     * @param yCoordinate The Y coordinate.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions moveToLocation(final int xCoordinate, final int yCoordinate) {
        return new MouseActionsImpl(webDriver, actions.moveByOffset(xCoordinate, yCoordinate));
    }

    /**
     * {@inheritDoc}
     *
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions rightClick() {
        return new MouseActionsImpl(webDriver, actions.contextClick());
    }

    /**
     * {@inheritDoc}
     *
     * @param element The element to right-click on.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions rightClick(@NonNull final Element element) {
        return new MouseActionsImpl(webDriver, actions.contextClick(webDriver.findElement(getByValue(element))));
    }

    /**
     * {@inheritDoc}
     *
     * @param source The element to drag.
     * @param destination The element to drop onto.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions dragAndDrop(@NonNull final Element source, @NonNull final Element destination) {
        return new MouseActionsImpl(webDriver, actions.dragAndDrop(webDriver.findElement(getByValue(source)), webDriver.findElement(getByValue(destination))));
    }

    /**
     * {@inheritDoc}
     *
     * @param source The element to drag.
     * @param xOffset The horizontal offset to drop by.
     * @param yOffset The vertical offset to drop by.
     * @return The current {@code MouseActionsImpl} instance for chaining.
     */
    @Override
    public MouseActions dragAndDropBy(@NonNull final Element source, final int xOffset, final int yOffset) {
        return new MouseActionsImpl(webDriver, actions.dragAndDropBy(webDriver.findElement(getByValue(source)), xOffset, yOffset));
    }

    /**
     * {@inheritDoc}
     *
     * @return A {@link MouseAction} representing the built sequence of actions.
     */
    @Override
    public MouseAction build() {
        return new MouseActionImpl(actions.build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void perform() {
        actions.perform();
    }

    /**
     * <p>
     * Retrieves a {@link By} based on the specified {@link LocatorType} and value.
     * </p>
     *
     * @return A {@link By} representing the locator.
     */
    private By getByValue(@NonNull final Element element) {
        return switch (element.locatorType()) {
            case ID -> By.id(element.value());
            case NAME -> By.name(element.value());
            case CLASS_NAME -> By.className(element.value());
            case XPATH -> By.xpath(element.value());
            case CSS_SELECTOR -> By.cssSelector(element.value());
            case LINKED_TEXT -> By.linkText(element.value());
            case PARTIALLY_LINKED_TEXT -> By.partialLinkText(element.value());
            case TAG_NAME -> By.tagName(element.value());
        };
    }
}
