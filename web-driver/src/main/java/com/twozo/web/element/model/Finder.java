package com.twozo.web.element.model;

import com.twozo.web.element.service.WebPageElement;

/**
 * <p>
 * Contains the details required to locate a {@link WebPageElement}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public record Finder(LocatorType locatorType, String value, boolean isKnown) {
}
