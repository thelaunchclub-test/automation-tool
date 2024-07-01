package com.twozo.web.element.finder;

import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;

/**
 * <p>
 * Contains the details required to locate a {@link WebPageElement}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public record Element(LocatorType locatorType, String value, boolean isKnown) {
}
