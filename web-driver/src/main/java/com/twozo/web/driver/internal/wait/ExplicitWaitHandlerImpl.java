package com.twozo.web.driver.internal.wait;

import com.twozo.web.driver.service.ExplicitWaitHandler;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;

import lombok.NonNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NonNull
public class ExplicitWaitHandlerImpl implements ExplicitWaitHandler {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public ExplicitWaitHandlerImpl(@NonNull final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Override
    public void waitTillVisible(@NonNull final Element element) {
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(getByValue(element.locatorType(), element.value()))));
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
