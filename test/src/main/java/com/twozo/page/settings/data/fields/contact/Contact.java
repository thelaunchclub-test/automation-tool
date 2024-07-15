package com.twozo.page.settings.data.fields.contact;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.Settings;
import com.twozo.page.settings.data.fields.Button;
import com.twozo.page.settings.data.fields.FieldType;
import com.twozo.page.settings.data.fields.field.*;
import com.twozo.page.url.settings.URL;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class Contact extends Settings {

    private static final String TWO_STRING_FORMAT = "%s%s";
    private static final String THREE_STRING_FORMAT = "%s%s%s";
    private static final String OPEN_PARENTHESIS = "(";

    private static Contact contact;

    private String firstNameDiv;
    private String lastNameDiv;
    private String emailDiv;
    private String phonesDiv;
    private String companyDiv;
    private String designationDiv;
    private String salesOwnerDiv;
    private String facebookDiv;
    private String twitterDiv;

    private SystemField firstNameField;
    private SystemField lastNameField;
    private SystemField emailsField;
    private SystemField phonesField;
    private SystemField companyField;
    private SystemField designationField;
    private SystemField salesOwnerField;
    private SystemField facebookField;
    private SystemField twitterField;

    private WebPageElement addSystemFieldsButton;
    private WebPageElement addSelectedFieldsButton;
    private WebPageElement addCustomFieldButton;
    private WebPageElement customFieldName;
    private WebPageElement selectCustomFieldType;
    private WebPageElement customFieldAddButton;
    private WebPageElement choice;
    private WebPageElement addChoice;

    private WebPageElement breadCrumb;

    protected Contact(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
        if (getURL().equals(URL.CONTACT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static Contact getInstance(final WebAutomationDriver webAutomationDriver) {
        contact = new Contact(webAutomationDriver);

        return contact;
    }

    public String getFirstNameDiv() {
        firstNameDiv = initializeElement(firstNameDiv, () -> getFieldBlock(ContactSystemField.FIRST_NAME));

        return firstNameDiv;
    }

    public String getLastNameDiv() {
        lastNameDiv = initializeElement(lastNameDiv, () -> getFieldBlock(ContactSystemField.LAST_NAME));

        return lastNameDiv;
    }

    public String getEmailDiv() {
        emailDiv = initializeElement(emailDiv, () -> getFieldBlock(ContactSystemField.EMAILS));

        return emailDiv;
    }

    public String getPhonesDiv() {
        phonesDiv = initializeElement(phonesDiv, () -> getFieldBlock(ContactSystemField.PHONES));

        return phonesDiv;
    }

    public String getCompanyDiv() {
        companyDiv = initializeElement(companyDiv, () -> getFieldBlock(ContactSystemField.COMPANY));

        return companyDiv;
    }

    public String getDesignationDiv() {
        designationDiv = initializeElement(designationDiv, () -> getFieldBlock(ContactSystemField.DESIGNATION));

        return designationDiv;
    }

    public String getSalesOwnerDiv() {
        salesOwnerDiv = initializeElement(salesOwnerDiv, () -> getFieldBlock(ContactSystemField.SALES_OWNER));

        return salesOwnerDiv;
    }

    public String getFacebookDiv() {
        facebookDiv = initializeElement(facebookDiv, () -> getFieldBlock(ContactSystemField.FACEBOOK));

        return facebookDiv;
    }

    public String getTwitterDiv() {
        twitterDiv = initializeElement(twitterDiv, () -> getFieldBlock(ContactSystemField.TWITTER));
        return twitterDiv;
    }

    private String format(final String div, final String element) {

        return String.format(TWO_STRING_FORMAT, div, element);
    }

    private String getPathOfSpecificCheckbox(final String div, final String element) {

        return String.format(THREE_STRING_FORMAT, OPEN_PARENTHESIS, div, element);
    }

    private SystemField getFirstNameField() {
        firstNameField = initializeElement(firstNameField, () -> new SystemField(
                findByXpath(format(getFirstNameDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getFirstNameDiv(), XPathBuilder.getXPathByText(ContactSystemField.FIRST_NAME.getName()))),
                findByXpath(format(getFirstNameDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getFirstNameDiv(), FieldElement.REQUIRED_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getFirstNameDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return firstNameField;
    }

    private SystemField getLastNameField() {
        lastNameField = initializeElement(lastNameField, () -> new SystemField(
                findByXpath(format(getLastNameDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getLastNameDiv(), XPathBuilder.getXPathByText(ContactSystemField.LAST_NAME.getName()))),
                findByXpath(format(getLastNameDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getLastNameDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getLastNameDiv(), FieldElement.REQUIRED_UNCHECKED)), null));

        return lastNameField;
    }

    private SystemField getEmailsField() {
        emailsField = initializeElement(emailsField, () -> new SystemField(
                findByXpath(format(getEmailDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getEmailDiv(), XPathBuilder.getXPathByText(ContactSystemField.EMAILS.getName()))),
                findByXpath(format(getEmailDiv(), FieldTypePath.EMAILS)),
                findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return emailsField;
    }

    private SystemField getPhonesField() {
        phonesField = initializeElement(phonesField, () -> new SystemField(
                findByXpath(format(getPhonesDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getPhonesDiv(), XPathBuilder.getXPathByText(ContactSystemField.PHONES.getName()))),
                findByXpath(format(getPhonesDiv(), FieldTypePath.PHONES)),
                findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return phonesField;
    }

    private SystemField getCompanyField() {
        companyField = initializeElement(companyField, () -> new SystemField(
                findByXpath(format(getCompanyDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getCompanyDiv(), XPathBuilder.getXPathByText(ContactSystemField.COMPANY.getName()))),
                findByXpath(format(getCompanyDiv(), FieldTypePath.COMPANY)),
                findByXpath(getPathOfSpecificCheckbox(getCompanyDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getCompanyDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return companyField;
    }

    private SystemField getDesignationField() {
        designationField = initializeElement(designationField, () -> new SystemField(
                findByXpath(format(getDesignationDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getDesignationDiv(), XPathBuilder.getXPathByText(ContactSystemField.DESIGNATION.getName()))),
                findByXpath(format(getDesignationDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getDesignationDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getDesignationDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return designationField;
    }

    private SystemField getSalesOwnerField() {
        salesOwnerField = initializeElement(salesOwnerField, () -> new SystemField(
                findByXpath(format(getSalesOwnerDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getSalesOwnerDiv(), XPathBuilder.getXPathByText(ContactSystemField.SALES_OWNER.getName()))),
                findByXpath(format(getSalesOwnerDiv(), FieldTypePath.OWNER)),
                findByXpath(getPathOfSpecificCheckbox(getSalesOwnerDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getSalesOwnerDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return salesOwnerField;
    }

    private SystemField getFacebookField() {
        facebookField = initializeElement(facebookField, () -> new SystemField(
                findByXpath(format(getFacebookDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getFacebookDiv(), XPathBuilder.getXPathByText(ContactSystemField.FACEBOOK.getName()))),
                findByXpath(format(getFacebookDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getFacebookDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getFacebookDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return facebookField;
    }

    private SystemField getTwitterField() {
        twitterField = initializeElement(twitterField, () -> new SystemField(
                findByXpath(format(getTwitterDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getTwitterDiv(), XPathBuilder.getXPathByText(ContactSystemField.TWITTER.getName()))),
                findByXpath(format(getTwitterDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getTwitterDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getTwitterDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return twitterField;
    }

    public WebPageElement getAddSystemFieldsButton() {
        addSystemFieldsButton = initializeElement(addSystemFieldsButton, () -> findByText(Button.SYSTEM_FIELDS));

        return addSystemFieldsButton;
    }

    public WebPageElement getAddSelectedFieldsButton() {
        addSelectedFieldsButton = initializeElement(addSelectedFieldsButton, () -> findByText(Button.ADD_SELECTED_FIELDS));

        return addSelectedFieldsButton;
    }

    public WebPageElement getAddCustomFieldButton() {
        addCustomFieldButton = initializeElement(addCustomFieldButton, () -> findByText(Button.CUSTOM_FIELD));

        return addCustomFieldButton;
    }

    public WebPageElement getCustomFieldName() {
        customFieldName = initializeElement(customFieldName, () -> findByXpath(FieldElement.CUSTOM_FIELD_NAME));

        return customFieldName;
    }

    public WebPageElement getSelectCustomFieldType() {
        selectCustomFieldType = initializeElement(selectCustomFieldType, () -> findByXpath(Button.CUSTOM_FIELDS_FIELD_TYPE));

        return selectCustomFieldType;
    }

    public WebPageElement getCustomFieldAddButton() {
        customFieldAddButton = initializeElement(customFieldAddButton, () -> findByXpath(FieldElement.ADD_BUTTON));

        return customFieldAddButton;
    }

    public WebPageElement getChoice() {
        choice = initializeElement(choice, () -> findByText(Button.CHOICE));

        return choice;
    }

    public WebPageElement getAddChoice() {
        addChoice = initializeElement(addChoice, () -> findByText(Button.ADD_CHOICE));

        return addChoice;
    }

    public WebPageElement getBreadCrumb() {
        breadCrumb = initializeElement(breadCrumb, () -> findRightElement(List.of(new Element(LocatorType.XPATH,
                buildXpathByText("Admin Settings"), true), new Element(LocatorType.TAG_NAME, "svg",
                false))));

        return breadCrumb;
    }

    private <T> T initializeElement(T element, Supplier<T> initializer) {
        return Objects.isNull(element) ? initializer.get() : element;
    }

    private boolean check(final SystemField systemField) {

        final List<WebPageElement> elementsToCheck = Arrays.asList(
                systemField.dragAndDropIcon(),
                systemField.fieldName(),
                systemField.fieldType(),
                systemField.addViewCheckbox(),
                systemField.requiredCheckbox());

        for (final WebPageElement element : elementsToCheck) {

            if (!isDisplayed(element)) {
                return false;
            }
        }

        return true;
    }

    private String getFieldBlock(final ContactSystemField contactSystemFieldName) {
        int rowNumber = 1;

        while (!contactSystemFieldName.getName().equals(getText(findByXpath(String.format(FieldElement.SPECIFIC_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.FIELD_BLOCK, rowNumber);
    }

    private String getFieldBlock(final String field) {
        int rowNumber = 1;

        while (!field.equals(getText(findByXpath(String.format(FieldElement.SPECIFIC_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.FIELD_BLOCK, rowNumber);
    }

    private String getFieldBlock(final DefaultContactDataFields defaultContactDataFields) {
        int rowNumber = 1;

        while (!defaultContactDataFields.getName().equals(getText(findByXpath(String.format(FieldElement.SPECIFIC_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.FIELD_BLOCK, rowNumber);
    }

    public String getMenuBlock(final String fieldName) {
        int rowNumber = 1;

        while (!fieldName.equals(getText(findByXpath(String.format(FieldElement.MENU_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.MENU_BLOCK, rowNumber);
    }

    public void checkSystemFields() {
        check(getFirstNameField());
        check(getLastNameField());
        check(getEmailsField());
        check(getPhonesField());
        check(getCompanyField());
        check(getDesignationField());
        check(getSalesOwnerField());
        check(getFacebookField());
        check(getTwitterField());
    }

    public void addSystemField(String contactSystemField) {
        click(getAddSystemFieldsButton());
        click(getAddSystemFieldToList(contactSystemField));
        click(getAddSelectedFieldsButton());
    }

    public void addCustomField(final String customFieldName, final String fieldType) {
        String path = "(((//*[@data-rbd-droppable-id='%s-choices']/div/div/div/div)[%d])/div/div)[2]/div/div/div/input";

        click(getAddCustomFieldButton());
        send(getCustomFieldName(), customFieldName);
        click(getSelectCustomFieldType());
        dropdown(fieldType);

        if (fieldType.equalsIgnoreCase(FieldType.DROPDOWN) || fieldType.equalsIgnoreCase(FieldType.MULTI_SELECT)) {

            click(getChoice());
            click(getAddChoice());

            if (fieldType.equalsIgnoreCase(FieldType.DROPDOWN)) {
                send(findByXpath(String.format(path, FieldType.DROPDOWN, 1)), "afd");
            } else {
                click(findByXpath(String.format(path, FieldType.MULTI_SELECT, 1)));
                send(findByXpath(String.format(path, FieldType.MULTI_SELECT, 1)), "ad");
                click(findByXpath(String.format(path, FieldType.MULTI_SELECT, 2)));
                send(findByXpath(String.format(path, FieldType.MULTI_SELECT, 2)), "ado");
            }
        }

        click(getCustomFieldAddButton());
    }

    public void check() {
        hover(new Element(LocatorType.XPATH, "//*[text()='Facebook']", true));
    }

    private WebPageElement getAddSystemFieldToList(final String fieldName) {
        return findByXpath(format(getMenuBlock(fieldName), "//*[@type='checkbox']"));
    }

    public void addAllSystemFields() {
        click(getAddSystemFieldsButton());
        final ContactSystemField[] values = ContactSystemField.values();

        System.out.println(values.length);

        for (final ContactSystemField specificField : values) {

            if ("fill: none;".equals(getAttribute(findByXpath(String.format("(%s//div//span//*)[2]", getMenuBlock(specificField.getName()))), "style"))) {
                click(findByXpath(format(getMenuBlock(specificField.getName()), "//*[@type='checkbox']")));
            }
        }
        click(getAddSelectedFieldsButton());
    }

    public String buildXpathByText(final String text) {
        return XPathBuilder.getXPathByText(text);
    }

    private boolean checkFieldType(final String xpath, String fieldType) {
        return fieldType.equals(getText(findRightElement(List.of(new Element(LocatorType.XPATH, xpath, true),
                new Element(LocatorType.TAG_NAME, "p", false)))));
    }

    private String getField(final Field systemField) {
        return XPathBuilder.getXPathByText(systemField.getName());
    }

    public void checkSystemFieldsFieldType() {
//        boolean p = "Text".equals(getText(findRightElement(List.of(new Element(LocatorType.XPATH, "//*[text()='First Name']", true),
//                new Element(LocatorType.TAG_NAME, "p", false)))));
//
//        System.out.println(getText(findRightElement(List.of(new Element(LocatorType.XPATH, "//*[text()='First Name']", true),
//                new Element(LocatorType.TAG_NAME, "p", false)))));
//        checkFieldType("//*[text()='First Name']","Text");
//        checkFieldType("//*[text()='Last Name']","Text");

        checkFieldType(getField(ContactSystemField.FIRST_NAME), FieldType.TEXT);
//        checkFieldType(getField(ContactSystemField.LAST_NAME), FieldType.TEXT);
//        checkFieldType(getField(ContactSystemField.EMAILS), FieldType.EMAIL);
//        checkFieldType(getField(ContactSystemField.PHONES), FieldType.PHONE);
//        checkFieldType(getField(ContactSystemField.COMPANY), FieldType.COMPANY);
//        checkFieldType(getField(ContactSystemField.DESIGNATION), FieldType.TEXT);
//        checkFieldType(getField(ContactSystemField.SALES_OWNER), FieldType.OWNER);
//        checkFieldType(getField(ContactSystemField.LIFECYCLE_STAGE), FieldType.DROPDOWN);
//        checkFieldType(getField(ContactSystemField.SOURCE), FieldType.DROPDOWN);
//        checkFieldType(getField(ContactSystemField.TERRITORY), FieldType.DROPDOWN);
//        checkFieldType(getField(ContactSystemField.TAGS), FieldType.MULTI_SELECT);
//        checkFieldType(getField(ContactSystemField.DATE_OF_BIRTH), FieldType.DATE);
//        checkFieldType(getField(ContactSystemField.DEPARTMENT), FieldType.TEXT);
//        checkFieldType(getField(ContactSystemField.ADDRESS), FieldType.ADDRESS);
//        checkFieldType(getField(ContactSystemField.FACEBOOK), FieldType.TEXT);
//        checkFieldType(getField(ContactSystemField.TWITTER), FieldType.TEXT);
//        checkFieldType(getField(ContactSystemField.LINKED_IN), FieldType.TEXT);
//        checkFieldType(getField(ContactSystemField.SUBSCRIPTION_STATUS), FieldType.DROPDOWN);
//        checkFieldType(getField(ContactSystemField.SUBSCRIPTION_TYPES), FieldType.MULTI_SELECT);
//        checkFieldType(getField(ContactSystemField.UNSUBSCRIBE_REASON), FieldType.DROPDOWN);
//        checkFieldType(getField(ContactSystemField.OTHER_UNSUBSCRIBE_REASON), FieldType.DROPDOWN);
//        checkFieldType(getField(CommonAutoGeneratingFields.CREATED_BY), FieldType.OWNER);
//        checkFieldType(getField(CommonAutoGeneratingFields.CREATED_AT), FieldType.DATE);
//        checkFieldType(getField(CommonAutoGeneratingFields.UPDATED_BY), FieldType.OWNER);
//        checkFieldType(getField(CommonAutoGeneratingFields.UPDATED_AT), FieldType.DATE);
//        checkFieldType(getField(CommonAutoGeneratingFields.LAST_ASSIGNED_AT), FieldType.DATE);
//        checkFieldType(getField(CommonAutoGeneratingFields.ID), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.TIME_ZONE), FieldType.DROPDOWN);
//        checkFieldType(getField(ContactSystemField.WEB_FORM), FieldType.TEXT);
//        checkFieldType(getField(CommonAutoGeneratingFields.RECENT_NOTE), FieldType.LARGE_TEXT);
//        checkFieldType(getField(CommonAutoGeneratingFields.OPEN_DEALS), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.CLOSED_DEALS), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.WON_DEALS), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.LOST_DEALS), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.LAST_ACTIVITY_DATE), FieldType.DATE);
//        checkFieldType(getField(CommonAutoGeneratingFields.NEXT_ACTIVITY_DATE), FieldType.DATE);
//        checkFieldType(getField(CommonAutoGeneratingFields.LAST_ACTIVITY_TYPE), FieldType.TEXT);
//        checkFieldType(getField(CommonAutoGeneratingFields.DONE_ACTIVITIES), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.UPCOMING_ACTIVITIES), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.TOTAL_ACTIVITIES), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.EMAIL_MESSAGES_COUNT), FieldType.NUMBER);
//        checkFieldType(getField(CommonAutoGeneratingFields.LAST_EMAIL_RECEIVED), FieldType.DATE);
//        checkFieldType(getField(CommonAutoGeneratingFields.LAST_EMAIL_SENT), FieldType.DATE);
    }

    public void verifyDataFieldElements(){
        isDisplayed(getBreadCrumb());

    }
    public void checkEyeIcon(DefaultContactDataFields[] defaultContactDataFields) {

        // for (DefaultContactDataFields defaultContactDataField : defaultContactDataFields) {

        hover(new Element(LocatorType.XPATH, buildXpathByText(ContactSystemField.LIFECYCLE_STAGE.getName()), true));
//            System.out.println(isDisplayed(findRightElement(List.of(new Element(LocatorType.XPATH, format(getFieldBlock(defaultContactDataField),buildXpath("Required")),
//                    true), new Element(LocatorType.TAG_NAME, "button", false)))));

        click(findRightElement(List.of(new Element(LocatorType.XPATH, format(getFieldBlock(ContactSystemField.LIFECYCLE_STAGE.getName()), buildXpathByText("Required")),
                true), new Element(LocatorType.TAG_NAME, "button", false))));
        //  }

    }

    public void cancel() {
        click(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(CommonAutoGeneratingFields.DONE_ACTIVITIES.getName()), FieldElement.ADD_VIEW_CHECKBOX)));
        click(findByXpath(FieldElement.UPDATE_BUTTON));
        //click(findByXpath(FieldElement.CANCEL_BUTTON));
    }



}

