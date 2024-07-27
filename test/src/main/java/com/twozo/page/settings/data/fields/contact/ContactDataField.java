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
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.List;
import java.util.Set;

public class ContactDataField extends AbstractDataField {

    private static ContactDataField contactDataField;

    private WebPageElement columnSettingsButton;
    private Element systemFieldSearchResults;

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
        return new SystemField(
                findByXpath(format(getFirstNameDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getFirstNameDiv(), XPathBuilder.getXPathByText(ContactField.FIRST_NAME.getName()))),
                findByXpath(format(getFirstNameDiv(), FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getFirstNameDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getFirstNameDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getLastNameField() {
        return new SystemField(
                findByXpath(format(getLastNameDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getLastNameDiv(), XPathBuilder.getXPathByText(ContactField.LAST_NAME.getName()))),
                findByXpath(format(getLastNameDiv(), FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getLastNameDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(getLastNameDiv(), FieldElement.REQUIRED_CHECKBOX))), null);
    }

    private SystemField getEmailsField() {
        return new SystemField(
                findByXpath(format(getEmailDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getEmailDiv(), XPathBuilder.getXPathByText(ContactField.EMAILS.getName()))),
                findByXpath(format(getEmailDiv(), FieldTypePath.EMAILS)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getPhonesField() {
        return new SystemField(
                findByXpath(format(getPhonesDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getPhonesDiv(), XPathBuilder.getXPathByText(ContactField.PHONES.getName()))),
                findByXpath(format(getPhonesDiv(), FieldTypePath.PHONES)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getCompanyField() {
        return new SystemField(
                findByXpath(format(getCompanyDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getCompanyDiv(), XPathBuilder.getXPathByText(ContactField.COMPANY.getName()))),
                findByXpath(format(getCompanyDiv(), FieldTypePath.COMPANY)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getCompanyDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(getCompanyDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getDesignationField() {
        return new SystemField(
                findByXpath(format(getDesignationDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getDesignationDiv(), XPathBuilder.getXPathByText(ContactField.DESIGNATION.getName()))),
                findByXpath(format(getDesignationDiv(), FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getDesignationDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(getDesignationDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getSalesOwnerField() {
        return new SystemField(
                findByXpath(format(getSalesOwnerDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getSalesOwnerDiv(), XPathBuilder.getXPathByText(ContactField.SALES_OWNER.getName()))),
                findByXpath(format(getSalesOwnerDiv(), FieldTypePath.OWNER)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getSalesOwnerDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getSalesOwnerDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getFacebookField() {
        return new SystemField(
                findByXpath(format(getFacebookDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getFacebookDiv(), XPathBuilder.getXPathByText(ContactField.FACEBOOK.getName()))),
                findByXpath(format(getFacebookDiv(), FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getFacebookDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(getFacebookDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getLinkedInField() {
        return new SystemField(
                findByXpath(format(getTwitterDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getTwitterDiv(), XPathBuilder.getXPathByText(ContactField.LINKED_IN.getName()))),
                findByXpath(format(getTwitterDiv(), FieldTypePath.TEXT)),
                isSelected(findByXpath(getPathOfSpecificCheckbox(getTwitterDiv(), FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(getTwitterDiv(), FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    public WebPageElement getAnUnExpectedErrorMessage() {
        return findByText("An unexpected error occurred. Please try again later.");
    }

    public boolean verifyBreadCrumb() {
        return isDisplayed(getBreadCrumb());
    }

    public boolean verifyActiveContactTab() {
        return isDisplayed(getActiveContactTab());
    }

    @Override
    protected List<SystemField> getDefaultSystemFieldElements(){
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
    public boolean verifyNonDraggableFields() {
        return isNonDraggableIconDisplayed(getFirstNameDiv()) &&
                isNonDraggableIconDisplayed(getLastNameDiv()) &&
                isNonDraggableIconDisplayed(getPhonesDiv()) &&
                isNonDraggableIconDisplayed(getEmailDiv());
    }

    public boolean isAddViewCheckBoxEditableForMandatoryField() {
//        click(getFirstNameField().addViewCheckbox());
//        click(getLastNameField().addViewCheckbox());
//        click(getEmailsField().addViewCheckbox());
//        click(getPhonesField().addViewCheckbox());
//        click(getSalesOwnerField().addViewCheckbox());

        return true;
    }

    public boolean emailOrPhoneShouldBeRequired() {
        return isSelected(findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.REQUIRED_CHECKBOX))) ||
                isSelected(findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.REQUIRED_CHECKBOX)));
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


//    public void verifyAutoGeneratingFieldNotVisibleInAddContactForm() {
//
//        List<String> autoGeneratingFields = new ArrayList<>();
//        autoGeneratingFields.addAll(Arrays.asList(ContactAutoGeneratingField.values()))
//
//        ContactAutoGeneratingField[] values = ContactAutoGeneratingField.values();
//        CommonAutoGeneratingFields[] values1 = CommonAutoGeneratingFields.values();
//
//
//    }

    @Override
    protected Field[] getAllFields() {
        return ContactField.values();
    }

    @Override
    protected List<Field> getDefaultFields(){
        return ContactField.getDefaultContactSystemFields();
    }

    public void checkSystemFieldsFieldType() {
        for (final Field value : getAllFields()) {

            checkFieldType(getField(value), value.getFieldType());
        }
    }
    public void check() {
        hover(new Element(LocatorType.XPATH, "//*[text()='Facebook']", true));
    }

    @Override
    public boolean isDefaultFieldsVisibleInSummary() {
        final List<Field> defaultSystemFields = ContactField.getDefaultContactSystemFields();
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

    public void switchToContactSummary() {
        final WebPageElement moveToSummary = findByXpath("//*[@class='MuiTableRow-root css-rm8p5t']/td[2]");
        click(moveToSummary);
    }

    public void switchToAddContactForm() {
        click(findByText("Contact"));
    }

    public boolean checkIfGivenFieldIsInList(final String contactSystemField) {
        //explicitWaitHandler.waitTillVisible(new Element(LocatorType.XPATH, getFieldBlock(contactSystemField), true));
        return isDisplayed(findByXpath(getFieldBlock(contactSystemField)));
    }

    public boolean checkIfGivenFieldsAddViewIsChecked(final String fieldName) {
        return isSelected(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(fieldName), FieldElement.ADD_VIEW_CHECKBOX)));
    }



//    public void addSystemFieldWithJsonData(final com.twozo.page.settings.data.fields.Field field){
//        click(getAddSystemFieldsButton());
//        click(getAddSystemFieldToList(field.getName()));
//        click(getAddSelectedFieldsButton());
//
//    }

}

