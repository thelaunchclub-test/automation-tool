package com.twozo.web.element.model;

import com.twozo.web.element.service.WebPageElement;

import lombok.NonNull;

/**
 * <p>
 * Contains the details required to locate a {@link WebPageElement}.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 */
public record Finder(@NonNull LocatorType locatorType, @NonNull String value, @NonNull boolean isKnown) {
}
