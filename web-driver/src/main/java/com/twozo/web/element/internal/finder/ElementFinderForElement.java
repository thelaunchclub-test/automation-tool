package com.twozo.web.element.internal.finder;

import com.twozo.web.element.model.Finder;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.element.internal.web.page.element.WebPageElementImpl;

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
     * @param finder The {@link Finder}  containing locator type and value.
     * @return a {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement getWebPageElement(@NonNull final Finder finder) {
        return new WebPageElementImpl(element.findElement(getByValue(finder.locatorType(), finder.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param finder The {@link Finder}  containing locator type and value.
     * @return a {@link Collection} of {@link WebPageElement} representing the located web page elements.
     */
    @Override
    public Collection<WebPageElement> getWebPageElements(@NonNull final Finder finder) {
        return getCommonElements(element.findElements(getByValue(finder.locatorType(), finder.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param finders A {@link Collection} of {@link Finder}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findBelowElement(@NonNull final Collection<Finder> finders) {
        final Map<Boolean, Finder> booleanFinderMap = get(finders);
        final Finder knownFinder = booleanFinderMap.get(true);
        final Finder unKnownFinder = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownFinder.locatorType(), unKnownFinder.value()).
                below(getByValue(knownFinder.locatorType(), knownFinder.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param finders A {@link Collection} of {@link Finder}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findAboveElement(@NonNull final Collection<Finder> finders) {
        final Map<Boolean, Finder> booleanFinderMap = get(finders);
        final Finder knownFinder = booleanFinderMap.get(true);
        final Finder unKnownFinder = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownFinder.locatorType(), unKnownFinder.value()).
                above(getByValue(knownFinder.locatorType(), knownFinder.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param finders A {@link Collection} of {@link Finder}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findLeftElement(@NonNull final Collection<Finder> finders) {
        final Map<Boolean, Finder> booleanFinderMap = get(finders);
        final Finder knownFinder = booleanFinderMap.get(true);
        final Finder unKnownFinder = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownFinder.locatorType(), unKnownFinder.value()).
                toLeftOf(getByValue(knownFinder.locatorType(), knownFinder.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param finders A {@link Collection} of {@link Finder}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findRightElement(@NonNull final Collection<Finder> finders) {
        final Map<Boolean, Finder> booleanFinderMap = get(finders);
        final Finder knownFinder = booleanFinderMap.get(true);
        final Finder unKnownFinder = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownFinder.locatorType(), unKnownFinder.value()).
                toRightOf(getByValue(knownFinder.locatorType(), knownFinder.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param finders A {@link Collection} of {@link Finder}.
     * @return A {@link WebPageElement} representing the located web page element.
     */
    @Override
    public WebPageElement findNearElement(@NonNull final Collection<Finder> finders) {
        final Map<Boolean, Finder> booleanFinderMap = get(finders);
        final Finder knownFinder = booleanFinderMap.get(true);
        final Finder unKnownFinder = booleanFinderMap.get(false);

        return new WebPageElementImpl(element.findElement(with(unKnownFinder.locatorType(), unKnownFinder.value()).
                near(getByValue(knownFinder.locatorType(), knownFinder.value()))));
    }

    /**
     * <p>
     * Converts a {@link Collection} of {@link Finder} into a {@link Map} where the key is a boolean indicating
     * whether the locator is known or not, and the value is the Finder object itself.
     * </p>
     *
     * @param finders A {@link Collection} of {@link Finder} into a {@link Map}.
     * @return A {@link Map}.
     */
    private Map<Boolean, Finder> get(@NonNull final Collection<Finder> finders) {
        return finders.stream().collect(Collectors.toMap(Finder::isKnown, Function.identity()));
    }
}
