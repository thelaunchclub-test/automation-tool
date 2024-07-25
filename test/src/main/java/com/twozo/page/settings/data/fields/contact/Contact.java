package com.twozo.page.settings.data.fields.contact;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.data.fields.DataField;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.contact.field.ContactDataField;
import com.twozo.page.settings.data.fields.field.*;
import com.twozo.page.url.settings.URL;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;
import org.openqa.selenium.NoSuchElementException;

import java.util.*;

public class Contact extends DataField {

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
    private SystemField linkedInField;

    private WebPageElement activeContactTab;
    private WebPageElement activeCompanyTab;
    private WebPageElement activeDealTab;
    private WebPageElement activeProductTab;
    private WebPageElement columnSettingsButton;
    private Element systemFieldSearchResults;

    protected Contact(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (!getURL().equals(URL.CONTACT)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static Contact getInstance(final WebAutomationDriver webAutomationDriver) {
        contact = new Contact(webAutomationDriver);

        return contact;
    }

    public String getFirstNameDiv() {
        firstNameDiv = initializeElement(firstNameDiv, () -> getFieldBlock(ContactDataField.FIRST_NAME));

        return firstNameDiv;
    }

    public String getLastNameDiv() {
        lastNameDiv = initializeElement(lastNameDiv, () -> getFieldBlock(ContactDataField.LAST_NAME));

        return lastNameDiv;
    }

    public String getEmailDiv() {
        emailDiv = initializeElement(emailDiv, () -> getFieldBlock(ContactDataField.EMAILS));

        return emailDiv;
    }

    public String getPhonesDiv() {
        phonesDiv = initializeElement(phonesDiv, () -> getFieldBlock(ContactDataField.PHONES));

        return phonesDiv;
    }

    public String getCompanyDiv() {
        companyDiv = initializeElement(companyDiv, () -> getFieldBlock(ContactDataField.COMPANY));

        return companyDiv;
    }

    public String getDesignationDiv() {
        designationDiv = initializeElement(designationDiv, () -> getFieldBlock(ContactDataField.DESIGNATION));

        return designationDiv;
    }

    public String getSalesOwnerDiv() {
        salesOwnerDiv = initializeElement(salesOwnerDiv, () -> getFieldBlock(ContactDataField.SALES_OWNER));

        return salesOwnerDiv;
    }

    public String getFacebookDiv() {
        facebookDiv = initializeElement(facebookDiv, () -> getFieldBlock(ContactDataField.FACEBOOK));

        return facebookDiv;
    }

    public String getTwitterDiv() {
        twitterDiv = initializeElement(twitterDiv, () -> getFieldBlock(ContactDataField.TWITTER));
        return twitterDiv;
    }

    private SystemField getFirstNameField() {
        firstNameField = initializeElement(firstNameField, () -> new SystemField(
                findByXpath(format(getFirstNameDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getFirstNameDiv(), XPathBuilder.getXPathByText(ContactDataField.FIRST_NAME.getName()))),
                findByXpath(format(getFirstNameDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getFirstNameDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getFirstNameDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return firstNameField;
    }

    private SystemField getLastNameField() {
        lastNameField = initializeElement(lastNameField, () -> new SystemField(
                findByXpath(format(getLastNameDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getLastNameDiv(), XPathBuilder.getXPathByText(ContactDataField.LAST_NAME.getName()))),
                findByXpath(format(getLastNameDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getLastNameDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getLastNameDiv(), FieldElement.REQUIRED_UNCHECKED)), null));

        return lastNameField;
    }

    private SystemField getEmailsField() {
        emailsField = initializeElement(emailsField, () -> new SystemField(
                findByXpath(format(getEmailDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getEmailDiv(), XPathBuilder.getXPathByText(ContactDataField.EMAILS.getName()))),
                findByXpath(format(getEmailDiv(), FieldTypePath.EMAILS)),
                findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return emailsField;
    }

    private SystemField getPhonesField() {
        phonesField = initializeElement(phonesField, () -> new SystemField(
                findByXpath(format(getPhonesDiv(), FieldElement.NON_DRAGGABLE)),
                findByXpath(format(getPhonesDiv(), XPathBuilder.getXPathByText(ContactDataField.PHONES.getName()))),
                findByXpath(format(getPhonesDiv(), FieldTypePath.PHONES)),
                findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return phonesField;
    }

    private SystemField getCompanyField() {
        companyField = initializeElement(companyField, () -> new SystemField(
                findByXpath(format(getCompanyDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getCompanyDiv(), XPathBuilder.getXPathByText(ContactDataField.COMPANY.getName()))),
                findByXpath(format(getCompanyDiv(), FieldTypePath.COMPANY)),
                findByXpath(getPathOfSpecificCheckbox(getCompanyDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getCompanyDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return companyField;
    }

    private SystemField getDesignationField() {
        designationField = initializeElement(designationField, () -> new SystemField(
                findByXpath(format(getDesignationDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getDesignationDiv(), XPathBuilder.getXPathByText(ContactDataField.DESIGNATION.getName()))),
                findByXpath(format(getDesignationDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getDesignationDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getDesignationDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return designationField;
    }

    private SystemField getSalesOwnerField() {
        salesOwnerField = initializeElement(salesOwnerField, () -> new SystemField(
                findByXpath(format(getSalesOwnerDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getSalesOwnerDiv(), XPathBuilder.getXPathByText(ContactDataField.SALES_OWNER.getName()))),
                findByXpath(format(getSalesOwnerDiv(), FieldTypePath.OWNER)),
                findByXpath(getPathOfSpecificCheckbox(getSalesOwnerDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getSalesOwnerDiv(), FieldElement.REQUIRED_CHECKED)),
                null));

        return salesOwnerField;
    }

    private SystemField getFacebookField() {
        facebookField = initializeElement(facebookField, () -> new SystemField(
                findByXpath(format(getFacebookDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getFacebookDiv(), XPathBuilder.getXPathByText(ContactDataField.FACEBOOK.getName()))),
                findByXpath(format(getFacebookDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getFacebookDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getFacebookDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return facebookField;
    }

    private SystemField getLinkedInField() {
        linkedInField = initializeElement(linkedInField, () -> new SystemField(
                findByXpath(format(getTwitterDiv(), FieldElement.DRAGGABLE)),
                findByXpath(format(getTwitterDiv(), XPathBuilder.getXPathByText(ContactDataField.LINKED_IN.getName()))),
                findByXpath(format(getTwitterDiv(), FieldTypePath.TEXT)),
                findByXpath(getPathOfSpecificCheckbox(getTwitterDiv(), FieldElement.ADD_VIEW_CHECKED)),
                findByXpath(getPathOfSpecificCheckbox(getTwitterDiv(), FieldElement.REQUIRED_UNCHECKED)),
                null));

        return linkedInField;
    }


    public WebPageElement getActiveContactTab() {
        activeContactTab = initializeElement(activeContactTab, () ->
                findByXpath("//*[@value='Contact' and @aria-pressed='true']"));

        return activeContactTab;
    }

    public WebPageElement getActiveCompanyTab() {
        activeCompanyTab = initializeElement(activeCompanyTab, () ->
                findByXpath("//*[@value='Company' and @aria-pressed='true']"));

        return activeCompanyTab;
    }

    public WebPageElement getActiveDealTab() {
        activeDealTab = initializeElement(activeDealTab, () ->
                findByXpath("//*[@value='Deal' and @aria-pressed='true']"));

        return activeDealTab;
    }

    public WebPageElement getActiveProductTab() {
        activeProductTab = initializeElement(activeProductTab, () ->
                findByXpath("//*[@value='Product' and @aria-pressed='true']"));

        return activeProductTab;
    }

    public WebPageElement getColumnSettingsButton() {
        return findByXpath("//*[@class='css-181x7hd']");
    }

    public WebPageElement getAnUnExpectedErrorMessage() {
        return findByText("An unexpected error occurred. Please try again later.");
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

    private String getFieldBlock(final Field contactSystemFieldName) {
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

    private String getFieldBlock(final ContactDataField contactDataField) {
        int rowNumber = 1;

        while (!contactDataField.getName().equals(getText(findByXpath(String.format(FieldElement.SPECIFIC_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.FIELD_BLOCK, rowNumber);
    }


    private WebPageElement getAddSystemFieldToList(final String fieldName) {
        return findByXpath(format(getMenuBlock(fieldName), "//*[@type='checkbox']"));
    }


    private boolean checkFieldType(final String xpath, String fieldType) {
        return fieldType.equals(getText(findRightElement(List.of(new Element(LocatorType.XPATH, xpath, true),
                new Element(LocatorType.TAG_NAME, "p", false)))));
    }

    private String getField(final Field systemField) {
        return XPathBuilder.getXPathByText(systemField.getName());
    }

    private boolean isNonDraggableIconDisplayed(String divBlockName) {
        return isDisplayed(findByXpath(format(divBlockName, FieldElement.NON_DRAGGABLE)));
    }

//    private Element getElement(String systemField) {
//        return new Element(LocatorType.XPATH, buildXpathByText(systemField), true);
//        click(findRightElement(List.of(new Element(LocatorType.XPATH, format(getFieldBlock(systemField), buildXpathByText("Required")),
//                true), new Element(LocatorType.TAG_NAME, "button", false))));
//    }

    public boolean verifyBreadCrumb() {
        return isDisplayed(getBreadCrumb());
    }

    public boolean verifyActiveContactTab() {
        return isDisplayed(getActiveContactTab());
    }

    public boolean switchBetweenTabs() {
        click(getContact());

        if (!isDisplayed(getActiveContactTab())) {
            return false;
        }
        click(getCompany());

        if (!isDisplayed(getActiveCompanyTab())) {
            return false;
        }
        click(getProduct());

        if (!isDisplayed(getActiveProductTab())) {
            return false;
        }
        click(getDeal());

        return isDisplayed(getActiveDealTab());
    }

    public boolean verifyDefaultSystemFields() {
        final List<SystemField> fields = List.of(
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

        for (SystemField field : fields) {
            if (!check(field)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifySystemFieldTabsDoesNotHideOtherTabs() {
        click(getAddSystemFieldsButton());
        final boolean displayed = isDisplayed(getAddSystemFieldsButton());

        return displayed;
    }

    public boolean verifySearchResult(final String systemFieldName) {
        click(getAddSystemFieldsButton());
        send(getAddSystemFieldSearchBar(), systemFieldName);

        for (WebPageElement webPageElement : findElements(getSystemFieldSearchResults())) {

            if (getText(webPageElement).contains(systemFieldName)) {
                return true;
            } else {
                return getText(findByXpath(FieldElement.SYSTEM_FIELD_SEARCH_RESULT)).equals("No Results");
            }
        }

        return false;
    }

//    public boolean verifyNoSearchResult(final String invalidFieldName) {
//        click(getAddSystemFieldsButton());
//        send(getAddSystemFieldSearchBar(), invalidFieldName);
//
//        return getText(findByXpath(FieldElement.SYSTEM_FIELD_SEARCH_RESULT)).equals("No Results");
//    }

    public boolean addSystemField(final ContactDataField contactDataField) {
        click(getAddSystemFieldsButton());
        click(getAddSystemFieldToList(contactDataField.getName()));
        click(getAddSelectedFieldsButton());
        return true;
        //refresh();

        // return isDisplayed(findByXpath(getMenuBlock(contactSystemField.getName())));
    }

    public boolean addSystemField(final String contactDataField) {
        click(getAddSystemFieldsButton());
        click(getAddSystemFieldToList(contactDataField));
        click(getAddSelectedFieldsButton());
        return true;
        //refresh();

        // return isDisplayed(findByXpath(getMenuBlock(contactSystemField.getName())));
    }

    public boolean removeSystemField(final ContactDataField contactDataField) {
        click(getAddSystemFieldsButton());

        final String contactDataFieldName = contactDataField.getName();

        isDisplayed(findByXpath(format(getMenuBlock(contactDataFieldName), FieldElement.CHECKED)));
        click(getAddSystemFieldToList(contactDataField.getName()));
        click(getAddSelectedFieldsButton());

        return true;
    }

    public boolean addAndRemoveSystemField(final ContactDataField contactDataFieldToBeAdded,
                                           final ContactDataField contactDataFieldToBeRemoved) {
        final String fieldToBeAdded = contactDataFieldToBeAdded.getName();
        final String fieldToBeRemoved = contactDataFieldToBeRemoved.getName();

        click(getAddSystemFieldsButton());

        final WebPageElement systemFieldToBeAdded = findByXpath(format(getMenuBlock(fieldToBeAdded), FieldElement.UNCHECKED));
        final WebPageElement systemFieldToBeRemoved = findByXpath(format(getMenuBlock(fieldToBeRemoved), FieldElement.CHECKED));

        isDisplayed(systemFieldToBeAdded);
        click(getAddSystemFieldToList(fieldToBeAdded));
        isDisplayed(systemFieldToBeRemoved);
        click(getAddSystemFieldToList(fieldToBeRemoved));
        return true;
    }

    public boolean verifyNonDraggableFields() {
        return isNonDraggableIconDisplayed(getFirstNameDiv()) &&
                isNonDraggableIconDisplayed(getLastNameDiv()) &&
                isNonDraggableIconDisplayed(getPhonesDiv()) &&
                isNonDraggableIconDisplayed(getEmailDiv());
    }

    public boolean verifyEyeIconIsNotVisibleForDefaultFields() {
        List<ContactDataField> defaultSystemFields = ContactDataField.getDefaultContactSystemFields();
        for (ContactDataField value : defaultSystemFields) {
            final String name = value.getName();

            hover(new Element(LocatorType.XPATH, buildXpathByText(name), true));

            try {
                WebPageElement element = findRightElement(List.of(
                        new Element(LocatorType.XPATH, format(getFieldBlock(name), buildXpathByText("Required")), true),
                        new Element(LocatorType.TAG_NAME, "button", false)
                ));
                if (isDisplayed(element)) {
                    return false;
                }
            } catch (Exception e) {

            }
        }

        return true;
    }

    public boolean isAddViewCheckBoxEditableForMandatoryField() {
        click(getFirstNameField().addViewCheckbox());
        click(getLastNameField().addViewCheckbox());
        click(getEmailsField().addViewCheckbox());
        click(getPhonesField().addViewCheckbox());
        click(getSalesOwnerField().addViewCheckbox());

        return true;
    }

    public boolean emailOrPhoneShouldBeRequired() {
        return isDisplayed(findByXpath(getPathOfSpecificCheckbox(getEmailDiv(), FieldElement.REQUIRED_CHECKED))) ||
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(getPhonesDiv(), FieldElement.REQUIRED_CHECKED)));
    }

    public boolean uncheckMandatoryFields() {

        String[] divValues = new String[]{
                getFirstNameDiv(),
                getEmailDiv(),
                getPhonesDiv(),
                getSalesOwnerDiv()
        };

        for (final String specificDiv : divValues) {

            final WebPageElement path = findByXpath(getPathOfSpecificCheckbox(getFieldBlock(specificDiv), FieldElement.REQUIRED_CHECKED));

            if (isDisplayed(path)) {
                click(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(specificDiv), FieldElement.REQUIRED_CHECKBOX)));

                if (isDisplayed(findByXpath(format(getFieldBlock(specificDiv), FieldElement.UPDATE_BUTTON)))) {
                    click(findByXpath(format(getFieldBlock(specificDiv), FieldElement.UPDATE_BUTTON)));
                }
            }
        }
        return true;
    }

    public boolean addAutoGeneratingSystemField(final Field contactAutoGeneratingField) {
        click(getAddSystemFieldsButton());
        click(getAddSystemFieldToList(contactAutoGeneratingField.getName()));
        click(getAddSelectedFieldsButton());

        return isDisplayed(findByXpath(getMenuBlock(contactAutoGeneratingField.getName())));
    }

    public boolean verifyAutoGeneratingSystemFieldNotEditable(final Field field) {
        final String name = field.getName();

        click(getAddSelectedFieldsButton());
        click(getAddSystemFieldToList(name));
        click(getAddSelectedFieldsButton());
        click(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(name), FieldElement.ADD_VIEW_CHECKBOX)));
        click(findByXpath(FieldElement.UPDATE_BUTTON));
        click(findByXpath(FieldElement.CANCEL_BUTTON));
        click(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(name), FieldElement.REQUIRED_CHECKBOX)));
        click(findByXpath(FieldElement.UPDATE_BUTTON));
        click(findByXpath(FieldElement.CANCEL_BUTTON));

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

    public boolean hideAutoGeneratingSystemField(final ContactDataField contactDataField) {
        final String name = contactDataField.getName();

        hover(new Element(LocatorType.XPATH, buildXpathByText(name), true));
        click(findRightElement(List.of(new Element(LocatorType.XPATH, format(getFieldBlock(name), buildXpathByText("Required")),
                true), new Element(LocatorType.TAG_NAME, "button", false))));


        return isDisplayed(findByXpath(format(getMenuBlock(name), FieldElement.UNCHECKED)));
    }

    public boolean verifyEyeIcon(final ContactDataField contactDataField) {
        final String name = contactDataField.getName();

        hover(new Element(LocatorType.XPATH, buildXpathByText(name), true));
        click(findRightElement(List.of(new Element(LocatorType.XPATH, format(getFieldBlock(name), buildXpathByText("Required")),
                true), new Element(LocatorType.TAG_NAME, "button", false))));

        click(getAddSystemFieldsButton());
        isDisplayed(findByXpath(format(getMenuBlock(name), FieldElement.CHECKED)));

        return false;
    }

    public void verifySystemFieldNotEditable(final ContactDataField contactDataField) {
        final String name = contactDataField.getName();

        click(getAddSelectedFieldsButton());
        click(getAddSystemFieldToList(name));
        click(getAddSelectedFieldsButton());
        click(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(name), FieldElement.ADD_VIEW_CHECKBOX)));
        click(findByXpath(FieldElement.UPDATE_BUTTON));
    }

    @Override
    protected Field[] getAllFields() {

        return ContactDataField.values();
    }

    public void checkSystemFieldsFieldType() {
        for (final Field value : getAllFields()) {

            checkFieldType(getField(value), value.getFieldType());
        }

    }

    public boolean addAllSystemFields() {
        click(getAddSystemFieldsButton());

        for (final Field specificField : getAllFields()) {
            final String fieldName = specificField.getName();

            if ("fill: none;".equals(getAttribute(findByXpath(String.format("(%s//div//span//*)[2]", getMenuBlock(fieldName))), "style"))) {
                click(findByXpath(format(getMenuBlock(fieldName), "//*[@type='checkbox']")));
            }
        }
        click(getAddSelectedFieldsButton());

        return true;
    }

    public void cancel() {
        click(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(ContactDataField.DONE_ACTIVITIES.getName()), FieldElement.ADD_VIEW_CHECKBOX)));
        click(findByXpath(FieldElement.UPDATE_BUTTON));
        //click(findByXpath(FieldElement.CANCEL_BUTTON));
    }

    public void check() {
        hover(new Element(LocatorType.XPATH, "//*[text()='Facebook']", true));
    }

    public boolean isDefaultFieldsVisibleInSummary() {
        List<ContactDataField> defaultSystemFields = ContactDataField.getDefaultContactSystemFields();
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


    public boolean isVisibleInSummary(final String fieldName) {

        return isDisplayed(findByXpath(format("//*[@class='css-itno5t']", XPathBuilder.getXPathByText(fieldName))));
    }

    public boolean isDefaultFieldsVisibleInAddView() {
        final List<ContactDataField> defaultSystemFields = ContactDataField.getDefaultContactSystemFields();

        for (final Field field : defaultSystemFields) {

            if (!isDisplayed(findByXpath(format("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-1g8cfko']",
                    XPathBuilder.getXPathByText(field.getName()))))) {
                return false;
            }
        }
        return true;
    }

    public boolean isVisibleInAddForm(final String fieldName) {
        return isDisplayed(findByXpath(format("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-1g8cfko']",
                XPathBuilder.getXPathByText(fieldName))));
    }

    public boolean isDefaultFieldsVisibleInListColumnSettings() {
        final List<ContactDataField> defaultSystemFields = ContactDataField.getDefaultContactSystemFields();

        for (final Field field : defaultSystemFields) {

            if (!isDisplayed(findByXpath(format("//*[@class='css-eawmf1']",
                    XPathBuilder.getXPathByText(field.getName()))))) {
                return false;
            }
        }
        return true;
    }

    public boolean isVisibleInColumnSettings(final String fieldName) {
        return isDisplayed(findByXpath(format("//*[@class='css-eawmf1']",
                XPathBuilder.getXPathByText(fieldName))));
    }

    public void addParticularMethodToList(final String fieldName) {
        click(findByXpath(String.format(FieldElement.SPECIFIC_FIELD_COLUMN_SETTINGS_CHECKBOX, fieldName)));
    }

    public void switchToContactSummary() {
        WebPageElement moveToSummary = findByXpath("//*[@class='MuiTableRow-root css-rm8p5t']/td[2]");
        click(moveToSummary);
    }

    public void switchToAddContactForm() {
        click(findByText("Contact"));
    }

    public void switchToColumnSettings() {
        click(getColumnSettingsButton());
    }

    public boolean checkIfGivenFieldIsInList(final String contactSystemField) {
        //explicitWaitHandler.waitTillVisible(new Element(LocatorType.XPATH, getFieldBlock(contactSystemField), true));
        return isDisplayed(findByXpath(getFieldBlock(contactSystemField)));
    }

    public boolean checkIfGivenFieldsAddViewIsChecked(final String fieldName) {
        return isDisplayed(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(fieldName), FieldElement.ADD_VIEW_CHECKED)));
    }

    public boolean isDisplayedInList(final ContactDataField contactDataField) {
        final String fieldBlock = getFieldBlock(contactDataField);

        if (isDisplayed(findByText(fieldBlock))) {
            return isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKED)));
        }
        return false;
    }

//    public void addSystemFieldWithJsonData(final com.twozo.page.settings.data.fields.Field field){
//        click(getAddSystemFieldsButton());
//        click(getAddSystemFieldToList(field.getName()));
//        click(getAddSelectedFieldsButton());
//
//    }

    public boolean check(final FieldStatus fieldStatus) {
        final boolean draggable = fieldStatus.isDraggable();
        final String name = fieldStatus.getName();
        final String fieldType = fieldStatus.getFieldType();
        final boolean addView = fieldStatus.isAddView();
        final boolean required = fieldStatus.isRequired();
        final boolean editable = fieldStatus.isEditable();
        final boolean deletable = fieldStatus.isDeletable();
        final boolean hideable = fieldStatus.isHideable();
        final String fieldName = fieldStatus.getName();
        String fieldBlock = null;


        try {
            fieldBlock = getFieldBlock(fieldName);

        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(fieldName);
            fieldBlock = getFieldBlock(fieldName);
        }

        if (!draggable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.NON_DRAGGABLE)));
        }
        if (draggable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.DRAGGABLE)));
        }

        //check      isDisplayed(findByXpath(format(getEmailDiv(), XPathBuilder.getXPathByText(fieldStatus.getFieldType()))));

        if (addView) {
            try {
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKED)));
            } catch (NoSuchElementException noSuchElementException) {
                click(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKBOX)));
                click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
                refresh();
                //waitTillVisible(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKED));
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKED)));
            }
        }
        if (!addView) {
            try {
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_UNCHECKED)));
            } catch (NoSuchElementException noSuchElementException) {
                click(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKBOX)));
                click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
                refresh();
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_UNCHECKED)));
            }
        }

        if (required) {
            try {
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKED)));
            } catch (NoSuchElementException noSuchElementException) {
                click(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX)));
                click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
                refresh();
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKED)));

            }
        }
        if (!required) {
            try {
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_UNCHECKED)));
            } catch (NoSuchElementException noSuchElementException) {
                click(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX)));
                click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
                refresh();
                isDisplayed(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_UNCHECKED)));
            }
        }

//        if (fieldStatus.isEditable()) {
//            click(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX)));
//            click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
//        }
//
//        if (!fieldStatus.isEditable()){
//            click(findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX)));
//            click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
//            isDisplayed(getAnUnExpectedErrorMessage());
//        }

        if (editable) {
            hoverByXpath(fieldBlock);
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.EDIT_ICON)));
        }

        if (!editable) {
            hoverByXpath(fieldBlock);
            try {
                isDisplayed(findByXpath(format(fieldBlock, FieldElement.EDIT_ICON)));
            } catch (NoSuchElementException noSuchElementException) {

            }
        }

        if (deletable) {
            hoverByXpath(fieldBlock);
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.DELETE_ICON)));
        }

        if (!deletable) {
            hoverByXpath(fieldBlock);
            try {
                isDisplayed(findByXpath(format(fieldBlock, FieldElement.DELETE_ICON)));
            } catch (NoSuchElementException noSuchElementException) {

            }
        }

        if (hideable) {
            hoverByXpath(fieldBlock);
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.EYE_ICON)));
        }

        if (!hideable) {
            hoverByXpath(fieldBlock);
            try {
                isDisplayed(findByXpath(format(fieldBlock, FieldElement.EYE_ICON)));
            } catch (NoSuchElementException noSuchElementException) {

            }
        }

        return true;
    }


}

