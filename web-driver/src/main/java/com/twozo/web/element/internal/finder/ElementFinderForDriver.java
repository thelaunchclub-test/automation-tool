package com.twozo.web.element.internal.finder;

import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.internal.web.page.element.WebPageElementImpl;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.service.WebPageElement;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * Provides methods to findElement {@link WebPageElement} from {@link WebAutomationDriver}.
 * Locates both single and multiple elements.
 * </p>
 *
 * @author Petchimuthu
 * @version 1.0
 * @see AbstractElementFinder
 */
@NonNull
@AllArgsConstructor
public final class ElementFinderForDriver extends AbstractElementFinder {

    private final WebDriver webDriver;

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element}  containing locator type and value.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement getWebPageElement(@NonNull final Element element) {
        return new WebPageElementImpl(webDriver.findElement(getByValue(element.locatorType(), element.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element}  containing locator type and value.
     * @return A {@link List} of {@link WebPageElement} representing the located web page elements.
     */
    @Override
    public List<WebPageElement> getWebPageElements(@NonNull final Element element) {
        return getCommonElements(webDriver.findElements(getByValue(element.locatorType(), element.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link List} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findBelowElement(@NonNull final List<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(webDriver.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                below(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link List} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findAboveElement(@NonNull final List<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(webDriver.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                above(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link List} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findLeftElement(@NonNull final List<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(webDriver.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                toLeftOf(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link List} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findRightElement(@NonNull final List<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(webDriver.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                toRightOf(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param elements A {@link List} of {@link Element}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findNearElement(@NonNull final List<Element> elements) {
        final Map<Boolean, Element> booleanFinderMap = get(elements);
        final Element knownElement = booleanFinderMap.get(true);
        final Element unKnownElement = booleanFinderMap.get(false);

        return new WebPageElementImpl(webDriver.findElement(with(unKnownElement.locatorType(), unKnownElement.value()).
                near(getByValue(knownElement.locatorType(), knownElement.value()))));
    }

    /**
     * <p>
     * Converts a {@link List} of {@link Element} into a {@link Map} where the key is a boolean indicating
     * whether the locator is known or not, and the value is the Element object itself.
     * </p>
     *
     * @param elements A {@link List} of {@link Element} into a {@link Map}.
     * @return A {@link Map}.
     */
    private Map<Boolean, Element> get(@NonNull final List<Element> elements) {
        return elements.stream().collect(Collectors.toMap(Element::isKnown, Function.identity()));
    }
}

