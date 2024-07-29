package com.twozo.page.settings.data.fields.product;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.Settings;
import com.twozo.page.settings.data.fields.AbstractDataField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.SystemField;
import com.twozo.page.url.settings.URL;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.List;

public class ProductDataField extends AbstractDataField {

    private static ProductDataField product;

    private WebPageElement activeProductTab;

    protected ProductDataField(WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (getURL().equals(URL.PRODUCT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static ProductDataField getInstance(final WebAutomationDriver webAutomationDriver) {
        product = new ProductDataField(webAutomationDriver);

        return product;
    }

    public WebPageElement getActiveProductTab() {
        activeProductTab = initializeElement(activeProductTab, () ->
                findByXpath("//*[@value='Company' and @aria-pressed='true']"));

        return activeProductTab;
    }

    @Override
    protected boolean verifyNonDraggableFields() {
        return false;
    }

    @Override
    protected Field[] getAllFields() {
        return ProductField.values();
    }

    @Override
    protected List<Field> getDefaultFields() {
        return ProductField.getDefaultFields();
    }

    @Override
    protected List<SystemField> getDefaultSystemFieldElements() {
        return null;
    }

    @Override
    public boolean isDefaultFieldsVisibleInSummary() {
        return false;
    }

    @Override
    protected boolean uncheckMandatoryFields() {
        return false;
    }

    public boolean verifyActiveProductTab() {
        return isDisplayed(getActiveProductTab());
    }

}
