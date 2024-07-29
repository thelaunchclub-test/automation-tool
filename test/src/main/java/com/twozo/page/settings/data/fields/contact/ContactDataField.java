package com.twozo.page.settings.data.fields.contact;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.data.fields.AbstractDataField;
import com.twozo.page.settings.data.fields.contact.field.ContactField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.FieldElement;
import com.twozo.page.settings.data.fields.field.FieldTypePath;
import com.twozo.page.settings.data.fields.field.SystemField;
import com.twozo.page.url.settings.URL;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.status.WebDriverErrorCode;
import org.openqa.selenium.NoSuchElementException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ContactDataField extends AbstractDataField {

    private static ContactDataField contactDataField;

    protected ContactDataField(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (!getURL().equals(URL.CONTACT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static ContactDataField getInstance(final WebAutomationDriver webAutomationDriver) {
        contactDataField = new ContactDataField(webAutomationDriver);

        return contactDataField;
    }

    public String getFirstNameDiv() {
        return getFieldBlock(ContactField.FIRST_NAME);
    }

    public String getLastNameDiv() {
        return getFieldBlock(ContactField.LAST_NAME);
    }

    public String getEmailDiv() {
        return getFieldBlock(ContactField.EMAILS);
    }

    public String getPhonesDiv() {
        return getFieldBlock(ContactField.PHONES);
    }

    public String getCompanyDiv() {
        return getFieldBlock(ContactField.COMPANY);
    }

    public String getDesignationDiv() {
        return getFieldBlock(ContactField.DESIGNATION);
    }

    public String getSalesOwnerDiv() {
        return getFieldBlock(ContactField.SALES_OWNER);
    }

    public String getFacebookDiv() {
        return getFieldBlock(ContactField.FACEBOOK);
    }

    public String getTwitterDiv() {
        return getFieldBlock(ContactField.LINKED_IN);
    }

    private SystemField getFirstNameField() {
        final String firstNameDiv = getFirstNameDiv();
        return new SystemField(
                findByXpath(format(firstNameDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(firstNameDiv, XPathBuilder.getXPathByText(ContactField.FIRST_NAME.getName()))),
                findByXpath(format(firstNameDiv, FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(firstNameDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(firstNameDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getLastNameField() {
        final String lastNameDiv = getLastNameDiv();

        return new SystemField(
                findByXpath(format(lastNameDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(lastNameDiv, XPathBuilder.getXPathByText(ContactField.LAST_NAME.getName()))),
                findByXpath(format(lastNameDiv, FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(lastNameDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(lastNameDiv, FieldElement.REQUIRED_CHECKBOX))), null);
    }

    private SystemField getEmailsField() {
        final String emailDiv = getEmailDiv();

        return new SystemField(
                findByXpath(format(emailDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(emailDiv, XPathBuilder.getXPathByText(ContactField.EMAILS.getName()))),
                findByXpath(format(emailDiv, FieldTypePath.EMAILS)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(emailDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(emailDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getPhonesField() {
        final String phonesDiv = getPhonesDiv();

        return new SystemField(
                findByXpath(format(phonesDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(phonesDiv, XPathBuilder.getXPathByText(ContactField.PHONES.getName()))),
                findByXpath(format(phonesDiv, FieldTypePath.PHONES)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(phonesDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(phonesDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getCompanyField() {
        final String companyDiv = getCompanyDiv();

        return new SystemField(
                findByXpath(format(companyDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(companyDiv, XPathBuilder.getXPathByText(ContactField.COMPANY.getName()))),
                findByXpath(format(companyDiv, FieldTypePath.COMPANY)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(companyDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(companyDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getDesignationField() {
        final String designationDiv = getDesignationDiv();

        return new SystemField(
                findByXpath(format(designationDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(designationDiv, XPathBuilder.getXPathByText(ContactField.DESIGNATION.getName()))),
                findByXpath(format(designationDiv, FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(designationDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(designationDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getSalesOwnerField() {
        final String salesOwnerDiv = getSalesOwnerDiv();

        return new SystemField(
                findByXpath(format(salesOwnerDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(salesOwnerDiv, XPathBuilder.getXPathByText(ContactField.SALES_OWNER.getName()))),
                findByXpath(format(salesOwnerDiv, FieldTypePath.OWNER)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getFacebookField() {
        final String facebookDiv = getFacebookDiv();
        return new SystemField(
                findByXpath(format(facebookDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(facebookDiv, XPathBuilder.getXPathByText(ContactField.FACEBOOK.getName()))),
                findByXpath(format(facebookDiv, FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(facebookDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(facebookDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getLinkedInField() {
        final String twitterDiv = getTwitterDiv();
        return new SystemField(
                findByXpath(format(twitterDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(twitterDiv, XPathBuilder.getXPathByText(ContactField.LINKED_IN.getName()))),
                findByXpath(format(twitterDiv, FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(twitterDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(twitterDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    public boolean isAddViewCheckBoxEditableForMandatoryField() {
        final List<String> mandatoryFields = Arrays.asList(
                getFirstNameDiv(),
                getLastNameDiv(),
                getEmailDiv(),
                getPhonesDiv(),
                getSalesOwnerDiv()
        );

        for (final String fieldDiv : mandatoryFields) {
            click(findByXpath(format(fieldDiv, FieldElement.ADD_VIEW_CHECKBOX)));

            try {
                if (isDisplayed(findByXpath(format(fieldDiv, FieldElement.UPDATE_BUTTON)))) {
                    throw new RuntimeException("Update button should not be visible after clicking the checkbox");
                }
            } catch (NoSuchElementException noSuchElementException) {

            }
        }
        return true;
    }

    public boolean emailOrPhoneShouldBeRequired() {
        return isSelected(findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.REQUIRED_CHECKBOX))) ||
                isSelected(findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.REQUIRED_CHECKBOX)));
    }

    @Override
    protected List<Field> getDefaultFields() {
        return ContactField.getDefaultFields();
    }

    @Override
    protected Field[] getAllFields() {
        return ContactField.values();
    }

    @Override
    public boolean verifyNonDraggableFields() {
        return isNonDraggableIconDisplayed(getFirstNameDiv()) &&
                isNonDraggableIconDisplayed(getLastNameDiv()) &&
                isNonDraggableIconDisplayed(getPhonesDiv()) &&
                isNonDraggableIconDisplayed(getEmailDiv());
    }

    @Override
    protected List<SystemField> getDefaultSystemFieldElements() {
        return List.of(
                getFirstNameField(),
                getLastNameField(),
                getEmailsField(),
                getPhonesField(),
                getCompanyField(),
                getDesignationField(),
                getSalesOwnerField(),
                getFacebookField(),
                getLinkedInField()
        );
    }

    @Override
    public boolean isDefaultFieldsVisibleInSummary() {
        final List<Field> defaultSystemFields = ContactField.getDefaultFields();
        final Set<String> fieldsShouldNotBeChecked = Set.of(defaultSystemFields.get(1).getName(),
                defaultSystemFields.get(2).getName(), defaultSystemFields.get(3).getName(),
                defaultSystemFields.get(4).getName(), defaultSystemFields.get(5).getName());

        for (final Field field : defaultSystemFields) {
            final String name = field.getName();

            if (fieldsShouldNotBeChecked.contains(name)) {
                continue;
            }

            if (!isDisplayed(findByXpath(format("//*[@class='css-itno5t']", XPathBuilder.getXPathByText(name))))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean uncheckMandatoryFields() {
        final String[] mandatoryFields = new String[]{
                getFirstNameDiv(),
                getEmailDiv(),
                getPhonesDiv(),
                getSalesOwnerDiv()
        };
        unCheck(mandatoryFields);

        return true;
    }
}

