package com.twozo.page.settings.data.fields.company;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.data.fields.AbstractDataField;
import com.twozo.page.settings.data.fields.company.field.CompanyField;
import com.twozo.page.settings.data.fields.contact.field.ContactField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.FieldElement;
import com.twozo.page.settings.data.fields.field.FieldTypePath;
import com.twozo.page.settings.data.fields.field.SystemField;
import com.twozo.page.url.settings.URL;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.Arrays;
import java.util.List;

public class CompanyDataField extends AbstractDataField {

    private static CompanyDataField company;

    protected CompanyDataField(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (getURL().equals(URL.CONTACT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static CompanyDataField getInstance(final WebAutomationDriver webAutomationDriver) {
        company = new CompanyDataField(webAutomationDriver);

        return company;
    }

    public String getNameDiv() {
        return getFieldBlock(CompanyField.NAME);
    }

    public String getWebsiteDiv() {
        return getFieldBlock(CompanyField.WEBSITE);
    }

    public String getSalesOwnerDiv() {
        return getFieldBlock(CompanyField.SALES_OWNER);
    }

    public String getAddressDiv() {
        return getFieldBlock(CompanyField.ADDRESS);
    }

    private SystemField getNameField() {
        final String nameDiv = getNameDiv();

        return new SystemField(findByXpath(format(nameDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(nameDiv, XPathBuilder.getXPathByText(CompanyField.NAME.getName()))),
                findByXpath(format(nameDiv, XPathBuilder.getXPathByText(CompanyField.NAME.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(nameDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(nameDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getWebsiteField() {
        final String websiteDiv = getWebsiteDiv();

        return new SystemField(findByXpath(format(websiteDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(websiteDiv, XPathBuilder.getXPathByText(CompanyField.WEBSITE.getName()))),
                findByXpath(format(websiteDiv, XPathBuilder.getXPathByText(CompanyField.WEBSITE.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(websiteDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(websiteDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getSalesOwnerField() {
        final String salesOwnerDiv = getSalesOwnerDiv();

        return new SystemField(findByXpath(format(salesOwnerDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(salesOwnerDiv, XPathBuilder.getXPathByText(CompanyField.SALES_OWNER.getName()))),
                findByXpath(format(salesOwnerDiv, XPathBuilder.getXPathByText(CompanyField.SALES_OWNER.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getAddressField() {
        final String addressDiv = getAddressDiv();

        return new SystemField(findByXpath(format(addressDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(addressDiv, XPathBuilder.getXPathByText(CompanyField.ADDRESS.getName()))),
                findByXpath(format(addressDiv, XPathBuilder.getXPathByText(CompanyField.ADDRESS.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(addressDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(addressDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    public boolean verifyActiveCompanyTab() {
        return isDisplayed(getActiveCompanyTab());
    }

    @Override
    protected List<Field> getDefaultFields() {
        return CompanyField.getDefaultFields();
    }

    @Override
    protected Field[] getAllFields() {
        return CompanyField.values();
    }

    @Override
    protected List<String> getMandatoryFields() {
        return Arrays.asList(
                getNameDiv(),
                getSalesOwnerDiv()
        );
    }

    @Override
    public boolean verifyNonDraggableFields() {
        return isNonDraggableIconDisplayed(getNameDiv());
    }

    @Override
    protected List<Record> getDefaultSystemFieldElements() {
        return List.of(getNameField(), getWebsiteField(), getSalesOwnerField(), getAddressField());
    }

    @Override
    public boolean isDefaultFieldsVisibleInSummary() {
        return isDisplayed(findByXpath(format("//*[@class='css-itno5t']",
                XPathBuilder.getXPathByText(ContactField.SALES_OWNER.getName()))));
    }

    @Override
    public boolean uncheckMandatoryFields() {
        final String[] mandatoryFields = new String[]{
                getNameDiv(),
                getSalesOwnerDiv(),
        };
        unCheck(mandatoryFields);

        return true;
    }
}
