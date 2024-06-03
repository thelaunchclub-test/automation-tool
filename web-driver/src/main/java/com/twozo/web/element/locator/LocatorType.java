package com.twozo.web.element.locator;

/**
 * The {@code LocatorType} represents different types of locators for web elements.
 *
 * @author Petchimuthu
 * @version 1.0
 */
public enum LocatorType {

    /**
     * <p>
     * Finds the element by using id.
     * </p>
     */
    ID,

    /**
     * <p>
     * Finds the element by using name.
     * </p>
     */
    NAME,

    /**
     * <p>
     * Finds the element by using class name.
     * </p>
     */
    CLASS_NAME,

    /**
     * <p>
     * Finds the element by using xpath.
     * </p>
     */
    XPATH,

    /**
     * <p>
     * Finds element by using css selector.
     * </p>
     */
    CSS_SELECTOR,

    /**
     * <p>
     * Finds the element by using linked text.
     * </p>
     */
    LINKED_TEXT,

    /**
     * <p>
     * Finds the element by using partially linked text.
     * </p>
     */
    PARTIALLY_LINKED_TEXT,

    /**
     * <p>
     * Finds the element by using tag name.
     * </p>
     */
    TAG_NAME;
}

