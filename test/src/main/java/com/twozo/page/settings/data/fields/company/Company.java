package com.twozo.page.settings.data.fields.company;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.Settings;
import com.twozo.page.settings.data.fields.DataField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.url.settings.URL;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.List;

public class Company extends DataField {

    private static Company company;

    private WebPageElement activeCompanyTab;

    protected Company(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (getURL().equals(URL.CONTACT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    @Override
    protected Field[] getAllFields() {
        return null;
    }

    public static Company getInstance(final WebAutomationDriver webAutomationDriver) {
        company = new Company(webAutomationDriver);

        return company;
    }

    public WebPageElement getActiveCompanyTab() {
        activeCompanyTab = initializeElement(activeCompanyTab, () ->
                findByXpath("//*[@value='Company' and @aria-pressed='true']"));

        return activeCompanyTab;
    }

    public boolean verifyActiveCompanyTab() {
        return isDisplayed(getActiveCompanyTab());
    }

    public boolean addAllSystemFields() {
        click(getAddSystemFieldsButton());
//        final ContactSystemField[] values = ContactSystemField.values();
//
//        System.out.println(values.length);

        for (final Field specificField : getAllFields()) {

            String fieldName = specificField.getName();

            if ("fill: none;".equals(getAttribute(findByXpath(String.format("(%s//div//span//*)[2]", getMenuBlock(fieldName))), "style"))) {
                click(findByXpath(format(getMenuBlock(fieldName), "//*[@type='checkbox']")));
            }
        }
        click(getAddSelectedFieldsButton());

        return true;
    }
}
