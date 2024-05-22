package com.web.driver.element.finders;

import com.web.driver.element.service.WebPageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Provides common functionality for element finders.
 * <p>
 * The {@link AbstractElementFinder} Provides common functionality
 * for finding web elements and converting them to {@link WebPageElement}.
 * </p>
 *
 * <p>
 * Defines methods for converting {@link WebElement} to {@link WebPageElement}
 * and for finding web elements using different locator strategies specified by {@link By}.
 * </p>
 *
 * @author petchimuthu1520
 * @version 1.0
 * @see ElementFinder
 */
public abstract class AbstractElementFinder implements ElementFinder {

    /**
     * Retrieves a {@link Collection} of {@link WebPageElement} from the provided
     * {@link Collection} of {@link WebElement}.
     *
     * @param webElements The {@link Collection} of {@link WebElement} .
     * @return A {@link Collection} of {@link WebPageElement}.
     */
    protected Collection<WebPageElement> getCommonElements(final Collection<WebElement> webElements) {
        final Collection<WebPageElement> webPageElements = new ArrayList<>();

        for (final WebElement element : webElements) {
            webPageElements.add(WebPageElement.getInstance(element));
        }

        return webPageElements;
    }

    /**
     * {@inheritDoc}
     *
     * @param by The {@link By} locator used to find the element.
     * @return The {@link WebPageElement} representing the found element.
     */
    @Override
    public abstract WebPageElement findElement(final By by);

    /**
     * {@inheritDoc}
     *
     * @param by The {@link By} locator used to find elements.
     * @return A {@link Collection} of {@link WebPageElement} representing the found elements.
     */
    @Override
    public abstract Collection<WebPageElement> findElements(final By by);
}
