package com.twozo.web.driver.internal.wait;

import com.twozo.web.driver.service.ExplicitWaitHandler;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;

import lombok.NonNull;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NonNull
public class ExplicitWaitHandlerImpl implements ExplicitWaitHandler {

    private final WebDriver webDriver;
    private final WebDriverWait wait;
    private final WebDriverWait shortWait;

    public ExplicitWaitHandlerImpl(@NonNull final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        this.shortWait = new WebDriverWait(webDriver,Duration.ofSeconds(1));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element} to wait for visibility.
     */
    @Override
    public void waitTillVisible(@NonNull final Element element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByValue(element.locatorType(),
                element.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element} to be clickable.
     */
    @Override
    public void WaitTillClickable(@NonNull final Element element) {
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(getByValue(element.locatorType(),
                element.value()))));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element} to wait for visibility.
     */
    @Override
    public void shortWaitTillVisible(@NonNull final Element element) {
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(getByValue(element.locatorType(),
                element.value())));
    }

    /**
     * {@inheritDoc}
     *
     * @param element The {@link Element} to be clickable.
     */
    @Override
    public void shortWaitTillClickable(@NonNull final Element element) {
        shortWait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(getByValue(element.locatorType(),
                element.value()))));
    }

    private By getByValue(@NonNull final LocatorType locatorType, @NonNull final String value) {
        return switch (locatorType) {
            case ID -> By.id(value);
            case NAME -> By.name(value);
            case CLASS_NAME -> By.className(value);
            case XPATH -> By.xpath(value);
            case CSS_SELECTOR -> By.cssSelector(value);
            case LINKED_TEXT -> By.linkText(value);
            case PARTIALLY_LINKED_TEXT -> By.partialLinkText(value);
            case TAG_NAME -> By.tagName(value);
        };
    }
}
