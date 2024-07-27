package com.twozo.page.settings.data.fields.company;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.data.fields.AbstractDataField;
import com.twozo.page.settings.data.fields.company.field.CompanyField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.SystemField;
import com.twozo.page.url.settings.URL;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.List;

public class CompanyDataField extends AbstractDataField {

    private static CompanyDataField company;

    protected CompanyDataField(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (getURL().equals(URL.CONTACT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    @Override
    protected boolean verifyNonDraggableFields() {
        return false;
    }

    public static CompanyDataField getInstance(final WebAutomationDriver webAutomationDriver) {
        company = new CompanyDataField(webAutomationDriver);

        return company;
    }

    @Override
    protected Field[] getAllFields() {
        return CompanyField.values();
    }

    @Override
    protected List<Field> getDefaultFields() {
        return null;
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
    public boolean verifyEyeIconIsNotVisibleForDefaultFields() {
        return false;
    }

    @Override
    protected boolean uncheckMandatoryFields() {
        return false;
    }

    @Override
    public boolean verifyDefaultSystemFields() {
        return false;
    }

    public boolean verifyActiveCompanyTab() {
        return isDisplayed(getActiveCompanyTab());
    }

}
