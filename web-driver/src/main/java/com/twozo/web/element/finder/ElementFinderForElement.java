package com.twozo.web.element.finder;

import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.element.web.page.element.WebPageElementImpl;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * Provides methods to findElement {@link WebPageElement} from {@link WebPageElement}.
 * Locates both single and multiple elements.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see AbstractElementFinder
 */
@NonNull
@AllArgsConstructor
public final class ElementFinderForElement extends AbstractElementFinder {

    private final WebElement element;

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element}  containing locator type and value.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement getWebPageElement(final Element element) {
        return new WebPageElementImpl(this.element.findElement(getByValue(element.locatorType(), element.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element}  containing locator type and value.
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements.
     */
    @Override
    public Collection<WebPageElement> getWebPageElements(final Element element) {
        return getCommonElements(this.element.findElements(getByValue(element.locatorType(), element.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link Collection} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findBelowElement(final Collection<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                below(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link Collection} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findAboveElement(final Collection<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                above(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link Collection} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findLeftElement(final Collection<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                toLeftOf(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link Collection} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findRightElement(final Collection<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                toRightOf(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link Collection} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findNearElement(final Collection<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                near(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * <p>
     * Converts a {@link Collection} of {@link Element} into a {@link Map} where the key is a boolean indicating
     * whether the locator is known or not, and the value is the Finder object itself.
     * </p>
     *
     * @param elements A {@link Collection} of {@link Element} into a {@link Map}.
     * @return A {@link Map}.
     */
    private Map<Boolean, Element> get(final Collection<Element> elements) {
        return elements.stream().collect(Collectors.toMap(Element::isKnown, Function.identity()));
    }
}
