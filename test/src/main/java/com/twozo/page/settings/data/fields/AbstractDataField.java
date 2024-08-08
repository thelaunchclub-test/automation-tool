package com.twozo.page.settings.data.fields;

import com.twozo.page.settings.Settings;
import com.twozo.page.settings.data.fields.contact.field.ContactField;
import com.twozo.page.settings.data.fields.field.DependableField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.FieldElement;
import com.twozo.page.settings.data.fields.field.SystemField;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import org.openqa.selenium.NoSuchElementException;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractDataField extends Settings {

    private static final String TWO_STRING_FORMAT = "%s%s";
    private static final String THREE_STRING_FORMAT = "%s%s%s";
    private static final String OPEN_PARENTHESIS = "(";

    protected AbstractDataField(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    private WebPageElement getActiveTab(final String tabName) {
        return findByXpath(String.format("//*[@value='%s' and @aria-pressed='true']", tabName));
    }

    protected WebPageElement getActiveContactTab() {
        return findByXpath("//*[@value='Contact' and @aria-pressed='true']");
    }

    protected WebPageElement getActiveCompanyTab() {
        return findByXpath("//*[@value='Company' and @aria-pressed='true']");
    }

    protected WebPageElement getActiveDealTab() {
        return findByXpath("//*[@value='Deal' and @aria-pressed='true']");
    }

    protected WebPageElement getActiveProductTab() {
        return findByXpath("//*[@value='Product' and @aria-pressed='true']");
    }

    protected String format(final String div, final String element) {
        return String.format(TWO_STRING_FORMAT, div, element);
    }

    protected String getPathOfSpecificCheckbox(final String div, final String element) {
        return String.format(THREE_STRING_FORMAT, OPEN_PARENTHESIS, div, element);
    }

    protected WebPageElement getAddSystemFieldsButton() {
        return findByText(Button.SYSTEM_FIELDS);
    }

    protected String getFieldBlock(final String field) {
        int rowNumber = 1;

        while (!field.contains(getText(findByXpath(String.format(FieldElement.SPECIFIC_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.FIELD_BLOCK, rowNumber);
    }

    protected String getDependableFieldBlock(final String field) {
        int rowNumber = 1;

        while (!field.equals(getText(findByXpath(String.format(FieldElement.SPECIFIC_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.DEPENDABLE_FIELD_BLOCK, rowNumber);
    }

    protected WebPageElement getAddSystemFieldToList(final String fieldName) {
        return findByXpath(format(getMenuBlock(fieldName), "//*[@type='checkbox']"));
    }

    protected String getFieldBlock(final Field field) {
        int rowNumber = 1;

        while (!field.getName().equals(getText(findByXpath(String.format(FieldElement.SPECIFIC_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.FIELD_BLOCK, rowNumber);
    }

    protected WebPageElement getAddSelectedFieldsButton() {
        return findByText(Button.ADD_SELECTED_FIELDS);
    }

    public WebPageElement getAddCustomFieldButton() {
        return findByText(Button.CUSTOM_FIELD);
    }

    protected WebPageElement getCustomFieldName() {
        return findByXpath(FieldElement.CUSTOM_FIELD_NAME);
    }

    protected WebPageElement getSelectCustomFieldType() {
        return findByXpath(Button.CUSTOM_FIELDS_FIELD_TYPE);
    }

    protected WebPageElement getCustomFieldAddButton() {
        return findByXpath(FieldElement.ADD_BUTTON);
    }

    protected WebPageElement getChoice() {
        return findByText(Button.CHOICE);
    }

    protected WebPageElement getAddChoice() {
        return findByText(Button.ADD_CHOICE);
    }

    protected WebPageElement getBreadCrumb() {
        return findRightElement(List.of(new Element(LocatorType.XPATH,
                buildXpathByText("Admin Settings"), true), new Element(LocatorType.TAG_NAME, "svg",
                false)));
    }

    protected WebPageElement getAddSystemFieldSearchBar() {
        return findByXpath("(//*[@placeholder='Search'])[2]");
    }

    protected Element getSystemFieldSearchResults() {
        return new Element(LocatorType.XPATH, FieldElement.SYSTEM_FIELD_SEARCH_RESULT, true);
    }

    protected String getMenuBlock(final String fieldName) {
        int rowNumber = 1;

        while (!fieldName.equals(getText(findByXpath(String.format(FieldElement.MENU_BLOCK, rowNumber))))) {
            rowNumber++;
        }

        return String.format(FieldElement.MENU_BLOCK, rowNumber);
    }

    protected void checkSpecificElement(final String fieldName, final String elementName) {
        isDisplayed(findByXpath(format(fieldName, elementName)));

    }

    protected boolean check(final Record record) {

        if (record instanceof SystemField systemField) {
            final List<WebPageElement> elementsToCheck = Arrays.asList(
                    systemField.dragAndDropIcon(),
                    systemField.fieldName(),
                    systemField.fieldType());

            for (final WebPageElement element : elementsToCheck) {
                if (!isDisplayed(element)) {
                    return false;
                }

                if (!systemField.addViewCheckbox() && systemField.requiredCheckbox()) {
                    return false;
                }
            }

            return true;

        } else if (record instanceof DependableField dependableField) {
            final List<WebPageElement> elementsToCheck = Arrays.asList(
                    dependableField.fieldName(),
                    dependableField.fieldType()
            );

            for (final WebPageElement element : elementsToCheck) {

                if (!isDisplayed(element)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public boolean addCustomField(final String customFieldName, final String fieldType) {
        final String path = "(((//*[@data-rbd-droppable-id='%s-choices']/div/div/div/div)[%d])/div/div)[2]/div/div/div/input";

        click(getAddCustomFieldButton());
        send(getCustomFieldName(), customFieldName);
        click(getSelectCustomFieldType());
        dropdown(fieldType);

        if (fieldType.equalsIgnoreCase(FieldType.DROPDOWN) || fieldType.equalsIgnoreCase(FieldType.MULTI_SELECT)) {

            click(getChoice());
            click(getAddChoice());

            if (fieldType.equalsIgnoreCase(FieldType.DROPDOWN)) {
                send(findByXpath(String.format(path, "dropdown", 1)), "afd");
                send(findByXpath(String.format(path, "dropdown", 2)), "ad");
            } else {
                click(findByXpath(String.format(path, FieldType.MULTI_SELECT, 1)));
                send(findByXpath(String.format(path, FieldType.MULTI_SELECT, 1)), "ad");
                click(findByXpath(String.format(path, FieldType.MULTI_SELECT, 2)));
                send(findByXpath(String.format(path, FieldType.MULTI_SELECT, 2)), "ado");
            }
        }

        waitTillVisible(FieldElement.ADD_BUTTON);
        click(getCustomFieldAddButton());
        refresh();

        return true;
    }

    public boolean verifySearchResult(final String systemFieldName) {
        click(getAddSystemFieldsButton());
        send(getAddSystemFieldSearchBar(), systemFieldName);

        for (final WebPageElement webPageElement : findElements(getSystemFieldSearchResults())) {

            if (!getText(webPageElement).equalsIgnoreCase(contains(systemFieldName))) {
                //System.out.println(getText(webPageElement));
                return false;
            } else {
                return !getText(findByXpath(FieldElement.SYSTEM_FIELD_SEARCH_RESULT)).equals("No Results");
            }
        }

        return true;
    }

    public boolean addSystemField(final Field field) {
        return addSystemField(field.getName());
    }


    public boolean addSystemField(final String fieldName) {
        click(getAddSystemFieldsButton());
        click(getAddSystemFieldToList(fieldName));
        click(getAddSelectedFieldsButton());

        final String fieldBlock = getFieldBlock(fieldName);

        try {
            return isDisplayed(findByXpath(fieldBlock));
        } catch (Exception exception) {
            return false;
        }
    }

    protected void verifySystemFieldNotEditable(final Field field) {
        final String name = field.getName();

        click(getAddSelectedFieldsButton());
        click(getAddSystemFieldToList(name));
        click(getAddSelectedFieldsButton());
        click(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(name), FieldElement.ADD_VIEW_CHECKBOX)));
        click(findByXpath(FieldElement.UPDATE_BUTTON));
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

    protected String getField(final Field systemField) {
        return XPathBuilder.getXPathByText(systemField.getName());
    }

    public void checkSystemFieldsFieldType() {
        for (final Field value : getAllFields()) {
            checkFieldType(getField(value), value.getFieldType());
        }
    }

    protected boolean checkFieldType(final String xpath, final String fieldType) {
        return fieldType.equals(getText(findRightElement(List.of(new Element(LocatorType.XPATH, xpath, true),
                new Element(LocatorType.TAG_NAME, "p", false)))));
    }

    public boolean checkIfDisplayed(final FieldStatus fieldStatus) {
        final boolean draggable = fieldStatus.isDraggable();
        final String fieldName = fieldStatus.getName();
        final String fieldType = fieldStatus.getFieldType();
        final boolean addView = fieldStatus.isAddView();
        final boolean required = fieldStatus.isRequired();
        final boolean editable = fieldStatus.isEditable();
        final boolean deletable = fieldStatus.isDeletable();
        final boolean hideable = fieldStatus.isHideable();
        String fieldBlock = null;

        try {
            fieldBlock = getFieldBlock(fieldName);

        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(fieldName);
            fieldBlock = getFieldBlock(fieldName);
        }

        final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKBOX));
        final WebPageElement requiredCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX));

        isDisplayed(findByXpath(format(fieldBlock, XPathBuilder.getXPathByText(fieldType))));

        final boolean isChecked = isSelected(addViewCheckbox);
        final boolean isRequired = isSelected(requiredCheckbox);

        if (draggable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.DRAGGABLE)));
        } else {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.NON_DRAGGABLE)));
        }

        if ((addView && !isChecked) || (!addView && isChecked)) {
            click(addViewCheckbox);
            click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
            refresh();
        }

        if ((required && !isRequired) || (!required && isRequired)) {
            click(requiredCheckbox);
            click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
            refresh();
        }

        hoverByXpath(fieldBlock);

        if (editable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.DELETE_ICON)));
        } else {
            try {
                if (isDisplayed(findByXpath(format(fieldBlock, FieldElement.DELETE_ICON)))) {
                    throw new AssertionError("Edit icon should not be displayed when editable is false.");
                }
            } catch (NoSuchElementException noSuchElementException) {

            }
        }

        if (deletable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.DELETE_ICON)));
        } else {
            try {
                if (isDisplayed(findByXpath(format(fieldBlock, FieldElement.DELETE_ICON)))) {
                    throw new AssertionError("Delete icon should not be displayed when Deletable is false.");
                }
            } catch (NoSuchElementException noSuchElementException) {


            }
        }

        if (hideable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.EYE_ICON)));
        } else {
            try {
                if (isDisplayed(findByXpath(format(fieldBlock, FieldElement.EYE_ICON)))) {
                    throw new AssertionError("Eye icon should not be displayed when hideable is false.");
                }
            } catch (NoSuchElementException noSuchElementException) {

            }
        }

        return true;
    }

    public void hideField(final String systemFieldName) {
        final String fieldBlock = getFieldBlock(systemFieldName);
        hoverByXpath(fieldBlock);
        click(findByXpath(format(fieldBlock, FieldElement.EYE_ICON)));
    }

    public void deleteField(final String systemFieldName) {
        final String fieldBlock = getFieldBlock(systemFieldName);
        hoverByXpath(fieldBlock);
        click(findByXpath(format(fieldBlock, FieldElement.DELETE_ICON)));
        click(findByText("Delete"));
    }

    public boolean verifyEyeIcon(final Field field) {
        final String name = field.getName();
        final String fieldBlock = getFieldBlock(name);

        hoverByXpath(fieldBlock);
        click(findByXpath(format(fieldBlock, FieldElement.EYE_ICON)));
//        click(findRightElement(List.of(new Element(LocatorType.XPATH, format(getFieldBlock(name), buildXpathByText("Required")),
//                true), new Element(LocatorType.TAG_NAME, "button", false))));
        click(getAddSystemFieldsButton());

        return !isSelected(findByXpath(getPathOfSpecificCheckbox(getMenuBlock(name), FieldElement.CHECKBOX)));
    }

    public boolean hideAutoGeneratingSystemField(final Field hideableSystemField) {
        final String name = hideableSystemField.getName();
        final String fieldBlock = getFieldBlock(name);

        hoverByXpath(fieldBlock);
        click(findByXpath(format(fieldBlock, FieldElement.EYE_ICON)));
//        click(findRightElement(List.of(new Element(LocatorType.XPATH, format(getFieldBlock(name), buildXpathByText("Required")),
//                true), new Element(LocatorType.TAG_NAME, "button", false))));
        click(getAddSystemFieldsButton());
        return !isSelected(findByXpath(getPathOfSpecificCheckbox(getMenuBlock(name), FieldElement.CHECKBOX)));
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

    public boolean removeSystemField(final Field field) {
        return removeSystemField(field.getName());
    }

    public boolean removeSystemField(final String fieldName) {
        click(getAddSystemFieldsButton());

        final WebPageElement checkbox = getAddSystemFieldToList(fieldName);

        if (isSelected(checkbox)) {
            click(checkbox);
        }
        click(getAddSelectedFieldsButton());

        return true;
    }

    public boolean verifySystemFieldTabsDoesNotHideOtherTabs() {
        click(getAddSystemFieldsButton());
        final boolean displayed = isDisplayed(getAddSystemFieldsButton());

        return displayed;
    }

    public boolean addAllSystemFields() {
        WebPageElement checkbox = null;
        click(getAddSystemFieldsButton());

        for (final Field specificField : getAllFields()) {
            final String fieldName = specificField.getName();
            System.out.println(fieldName);
            try {
                checkbox = findByXpath(format(getMenuBlock(fieldName), "//*[@type='checkbox']"));
            } catch (Exception exception) {
                continue;
            }

            //waitTillVisible(format(getMenuBlock(fieldName), "//*[@type='checkbox']"));
            if (!isSelected(checkbox)) {
                click(checkbox);
            }
            isDisplayed(findByXpath(getFieldBlock(fieldName)));
        }
        click(getAddSelectedFieldsButton());

        try {
            for (final Field specificField : getAllFields()) {
                isDisplayed(findByXpath(specificField.getName()));
            }
        } catch (Exception exception) {
            return false;
        }

        return true;
    }

    protected void unCheck(final String[] mandatoryFields) {
        for (final String specificDiv : mandatoryFields) {

            final WebPageElement path = findByXpath(getPathOfSpecificCheckbox(getFieldBlock(specificDiv), FieldElement.REQUIRED_CHECKBOX));

            if (isSelected(path)) {
                click(path);

                if (isDisplayed(findByXpath(format(getFieldBlock(specificDiv), FieldElement.UPDATE_BUTTON)))) {
                    click(findByXpath(format(getFieldBlock(specificDiv), FieldElement.UPDATE_BUTTON)));
                }
            }
        }
    }

    public boolean addAndRemoveSystemField(final Field fieldToBeAdded,
                                           final Field fieldToBeRemoved) {
        final String fieldToBeAddedToList = fieldToBeAdded.getName();
        final String fieldToBeRemovedFromList = fieldToBeRemoved.getName();

        click(getAddSystemFieldsButton());

        final WebPageElement systemFieldToBeAdded = findByXpath(getPathOfSpecificCheckbox(getMenuBlock(fieldToBeAddedToList),
                FieldElement.CHECKBOX));
        final WebPageElement systemFieldToBeRemoved = findByXpath(getPathOfSpecificCheckbox(getMenuBlock
                (fieldToBeRemovedFromList), FieldElement.CHECKBOX));

        if (!isSelected(systemFieldToBeAdded)) {
            click(getAddSystemFieldToList(fieldToBeAddedToList));
        }
        if (isSelected(systemFieldToBeRemoved)) {
            click(getAddSystemFieldToList(fieldToBeRemovedFromList));
        }
        return true;
    }

    public boolean isDefaultFieldsVisibleInAddView() {
        for (final Field field : getDefaultFields()) {

            if (!isDisplayed(findByXpath(format("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-1g8cfko']",
                    XPathBuilder.getXPathByText(field.getName()))))) {
                return false;
            }
        }
        return true;
    }

    public boolean isVisibleInSummary(final String fieldName) {
//        try {
//            return isDisplayed(findByXpath(format("//*[@class='css-itno5t']", XPathBuilder.getXPathByText(fieldName))));
//        } catch (Exception e) {
//            try {
//                click(findByXpath("//*[@class='css-1bv670y']//button"));
//                return isDisplayed(findByXpath(format("//*[@class='css-itno5t']", XPathBuilder.getXPathByText(fieldName))));
//
//            } catch (Exception exception) {
//                return false;
//            }
//        }
        while (true) {
            try {
                if (isDisplayed(findByXpath(format("//*[@class='css-itno5t']", XPathBuilder.getXPathByText(fieldName))))) {
                    return true;
                }
            } catch (Exception e) {
                try {
                    WebPageElement button = findByXpath("//*[@class='css-1bv670y']//button");
                    if (isDisplayed(button)) {
                        click(button);
                    } else {
                        return false;
                    }
                } catch (Exception exception) {
                    return false;
                }
            }
        }
    }

    public boolean isVisibleInAddForm(final String fieldName) {
        try {
            return isDisplayed(findByXpath(format("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-1g8cfko']",
                    XPathBuilder.getXPathByText(fieldName))));
        } catch (Exception exception) {
            refresh();
        }
        return false;
    }

    public boolean isVisibleInAddFormAsRequired(final String fieldName) {
        try {
            return isDisplayed(findByXpath(String.format(THREE_STRING_FORMAT, "//*[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 css-1g8cfko']",
                    XPathBuilder.getXPathByText(fieldName), XPathBuilder.getXPathByText("*"))));
        } catch (Exception exception) {
            refresh();
        }

        return false;
    }

    public boolean isDefaultFieldsVisibleInListColumnSettings() {
        for (final Field field : getDefaultFields()) {

            if (!isDisplayed(findByXpath(format("//*[@class='css-eawmf1']",
                    XPathBuilder.getXPathByText(field.getName()))))) {
                return false;
            }
        }

        return true;
    }

    public boolean isVisibleInColumnSettings(final String fieldName) {
        try {
            return isDisplayed(findByXpath(format("//*[@class='css-eawmf1']",
                    XPathBuilder.getXPathByText(fieldName))));
        } catch (Exception exception) {
            refresh();

            return false;
        }
    }

    public void addParticularFieldToList(final String fieldName) {
        click(findByXpath(String.format(FieldElement.SPECIFIC_FIELD_COLUMN_SETTINGS_CHECKBOX, fieldName)));
    }

    public boolean verifyDefaultSystemFields() {
        for (final Record field : getDefaultSystemFieldElements()) {

            if (!check(field)) {
                return false;
            }
        }

        return true;
    }

    public boolean verifyBreadCrumb() {
        return isDisplayed(getBreadCrumb());
    }

    public WebPageElement getAnUnExpectedErrorMessage() {
        return findByText("An unexpected error occurred. Please try again later.");
    }

    protected boolean isDisplayedInList(final ContactField contactDataField) {
        final String fieldBlock = getFieldBlock(contactDataField);

        return isDisplayed(findByText(fieldBlock));
    }

    protected boolean isNonDraggableIconDisplayed(String divBlockName) {
        return isDisplayed(findByXpath(format(divBlockName, FieldElement.NON_DRAGGABLE)));
    }

    public boolean verifyEyeIconIsNotVisibleForDefaultFields() {
        for (Field value : getDefaultFields()) {
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

    public boolean checkIfGivenFieldsAddViewIsChecked(final String fieldName) {
        return isSelected(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(fieldName), FieldElement.ADD_VIEW_CHECKBOX)));
    }

    public void switchToSummary() {
        final WebPageElement moveToSummary = findByXpath("//*[@class='MuiTableRow-root css-rm8p5t']/td[2]");

        click(moveToSummary);
    }

    public void switchToAddContactForm() {
        click(findByText("Contact"));
    }

    public boolean checkIfGivenFieldIsInList(final String contactSystemField) {
        return isDisplayed(findByXpath(getFieldBlock(contactSystemField)));
    }

    public boolean isAddViewCheckBoxEditableForMandatoryField() {
        for (final String fieldDiv : getMandatoryFields()) {
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

    public boolean enableAddViewForAllSystemFields() {
        WebPageElement addViewCheckbox = null;
        for (final Field field : getAllFields()) {
            System.out.println(field.getName());
            final String fieldBlock = getFieldBlock(field);

            try {
                findByXpath(fieldBlock);
            } catch (Exception exception) {
                addSystemField(field.getName());
            }

            try {
                addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKBOX));

                if (!isSelected(addViewCheckbox)) {
                    click(addViewCheckbox);
                    try {
                        click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
                    } catch (Exception exception) {
                        System.out.println(field.getName());
                    }
                    refresh();
                }
            } catch (Exception exception) {
            }
        }
        return true;
    }

    public void enableAddView(final String fieldName) {
        final String fieldBlock = getFieldBlock(fieldName);
        final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock,
                FieldElement.ADD_VIEW_CHECKBOX));

        if (!isSelected(addViewCheckbox)) {
            click(addViewCheckbox);
            try {
                click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
            } catch (Exception exception) {
                System.out.println(fieldName);
            }
            refresh();

        }
    }
//
//    public void enableRequiredForAllSystemFields() {
//        for (final Field field : getAllFields()) {
//
//            final String fieldBlock = getFieldBlock(field);
//            final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX));
//
//            if (!isSelected(addViewCheckbox)) {
//                click(addViewCheckbox);
//                try {
//                    click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
//                } catch (Exception exception) {
//                    System.out.println(field.getName());
//                }
//                refresh();
//            }
//        }
//    }
//
//    public void enableAddViewForAllCustomField(final String fieldName) {
//        final String fieldBlock = getFieldBlock(fieldName);
//        final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKBOX));
//
//        if (!isSelected(addViewCheckbox)) {
//            click(addViewCheckbox);
//            try {
//                click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
//            } catch (Exception exception) {
//                System.out.println(fieldName);
//            }
//            refresh();
//        }
//    }
//
//    public void enableRequiredForAllCustomField(final String fieldName) {
//        final String fieldBlock = getFieldBlock(fieldName);
//        final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX));
//
//        if (!isSelected(addViewCheckbox)) {
//            click(addViewCheckbox);
//            try {
//                click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
//            } catch (Exception exception) {
//                System.out.println(fieldName);
//            }
//            refresh();
//        }
//    }
//
//    public void checkIfReflected(final String fieldName) {
//        if (checkIfGivenFieldIsInList(fieldName)) {
//            isVisibleInSummary(fieldName);
//        }
//
//        isVisibleInColumnSettings(fieldName);
//
//        if (isSelected(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(fieldName), FieldElement.CHECKBOX)))) {
//            isVisibleInAddForm(fieldName);
//        }
//
//    }

    public void editCustomField(final String actualName, final String newName) {
        final String fieldBlockXpath = getFieldBlock(actualName);
        try {
            findByXpath(fieldBlockXpath);
        } catch (Exception exception) {
            System.out.println("No such field found");
        }
        hoverByXpath(fieldBlockXpath);
        click(findByXpath(format(fieldBlockXpath, FieldElement.EDIT_ICON)));
        send(getCustomFieldName(), newName);
        click(findByXpath(format(fieldBlockXpath, FieldElement.UPDATE_BUTTON)));

    }

    public void enableRequiredForAllSystemFields() {
        for (final Field field : getAllFields()) {

            final String fieldBlock = getFieldBlock(field);
            final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.REQUIRED_CHECKBOX));

            if (!isSelected(addViewCheckbox)) {
                click(addViewCheckbox);
                try {
                    click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
                } catch (Exception exception) {
                    System.out.println(field.getName());
                }
                refresh();
            }
        }
    }

    public boolean checkIfAddViewIsChecked(final FieldStatus fieldStatus) {
        final boolean draggable = fieldStatus.isDraggable();
        final String fieldName = fieldStatus.getName();
        final boolean addView = fieldStatus.isAddView();
        String fieldBlock = null;

        try {
            fieldBlock = getFieldBlock(fieldName);

        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(fieldName);
            fieldBlock = getFieldBlock(fieldName);
        }

        final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKBOX));
        final boolean isChecked = isSelected(addViewCheckbox);

        if (draggable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.DRAGGABLE)));
        } else {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.NON_DRAGGABLE)));
        }

        if ((addView && !isChecked) || (!addView && isChecked)) {
            click(addViewCheckbox);
            click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
            try {
                findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON));
            } catch (Exception e) {
                System.out.println(fieldName);
            }
            refresh();
        }

        return addView;
    }
    //===========================================================================================

    public boolean checkFieldElements(final FieldStatus fieldStatus) {
        final boolean draggable = fieldStatus.isDraggable();
        final String fieldName = fieldStatus.getName();
        final String fieldType = fieldStatus.getFieldType();

        String fieldBlock = null;

        try {
            fieldBlock = getFieldBlock(fieldName);

        } catch (NoSuchElementException noSuchElementException) {
            addSystemField(fieldName);
            fieldBlock = getFieldBlock(fieldName);
        }
        isDisplayed(findByXpath(format(fieldBlock, XPathBuilder.getXPathByText(fieldType))));
        if (draggable) {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.DRAGGABLE)));
        } else {
            isDisplayed(findByXpath(format(fieldBlock, FieldElement.NON_DRAGGABLE)));
        }
        return true;
    }

    public void checkAddView(final FieldStatus fieldStatus) {
        final String fieldBlock = getFieldBlock(fieldStatus.getName());
        final boolean addView = fieldStatus.isAddView();

        final WebPageElement addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock,
                FieldElement.ADD_VIEW_CHECKBOX));
        final boolean updatedAddViewChecked = isSelected(addViewCheckbox);

        if ((addView && !updatedAddViewChecked) || (!addView && updatedAddViewChecked)) {
            click(addViewCheckbox);
            click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
            refresh();
        }

        if (addView && !updatedAddViewChecked) {
            throw new AssertionError("Expected 'Add View' to be checked but it is not.");
        } else if (!addView && updatedAddViewChecked) {
            throw new AssertionError("Expected 'Add View' to be unchecked but it is not.");
        }
    }

    public boolean checkRequired(final FieldStatus fieldStatus) {
        final String fieldBlock = getFieldBlock(fieldStatus.getName());
        final boolean required = fieldStatus.isRequired();

        //checkFieldElements(fieldStatus);
        final WebPageElement requiredCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock,
                FieldElement.REQUIRED_CHECKBOX));
        final boolean isRequired = isSelected(requiredCheckbox);

        if ((required && !isRequired) || (!required && isRequired)) {
            click(requiredCheckbox);
            click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
            refresh();
        }

        return true;
    }

//    public void fromTo(final String fieldName) {
//        mouseActions.moveToElement(new Element(LocatorType.XPATH, format(getFieldBlock(fieldName), FieldElement.DRAG_ICON),true));
//        mouseActions.clickAndHold(new Element(LocatorType.XPATH, format(getFieldBlock(fieldName), FieldElement.DRAG_ICON), true))
//                .moveToLocation(getLocationOfX(findByXpath(getFieldBlock("Designation"))),getLocationOfY(findByXpath(getFieldBlock("Sales Owner")))).release().perform();
//    }

//    public void fromTo(final String fieldName) {
//        mouseActions.clickAndHold(new Element(LocatorType.XPATH, format(getFieldBlock(fieldName), FieldElement.DRAG_ICON), true))
//                .moveToLocation(0,100).perform();
//    }

//    public void fromTo(final String fieldName) {
//        mouseActions.dragAndDropBy(new Element(LocatorType.XPATH, format(getFieldBlock(fieldName),
//                FieldElement.DRAG_ICON), true),0,100).perform();
//    }

//    public void moveToLocation(final String fieldName){
//        mouseActions.moveToElement()
//    }

//    public void dragAndDropByXpath(final String fieldName) {
//        mouseActions.dragAndDropBy(new Element(LocatorType.XPATH, format(getFieldBlock(fieldName), FieldElement.DRAG_ICON)
//                , true), 0, 100).perform();
//    }
//
//    public final void dragAndDropByElement(final String element, final String target) {
//        final String xpath = format(getFieldBlock(target), FieldElement.DRAG_ICON);
//        final WebPageElement designation = findByXpath(format(getFieldBlock(target), FieldElement.DRAG_ICON));
//
//        mouseActions.moveToElement(getElementByXpath(xpath), getLocationOfX(designation), getLocationOfY(designation)).perform();
//    }
//
//    public final void dragAndDropByElement(final String element) {
//        final String xpath = format(getFieldBlock(element), FieldElement.DRAG_ICON);
//      //  final WebPageElement designation = findByXpath(format(getFieldBlock(target), FieldElement.DRAG_ICON));
//
//        mouseActions.moveToElement(getElementByXpath(xpath), 0,100).perform();
//    }

    // public abstract void checkDependableFields(final String fieldName);

    protected abstract List<Field> getDefaultFields();

    protected abstract Field[] getAllFields();

    protected abstract List<String> getMandatoryFields();

    protected abstract boolean verifyNonDraggableFields();

    protected abstract List<Record> getDefaultSystemFieldElements();

    public abstract boolean isDefaultFieldsVisibleInSummary();

    protected abstract boolean uncheckMandatoryFields();


    public boolean addSystemField(final FieldStatus fieldStatus) {
        final String fieldName = fieldStatus.getName();
        final String fieldType = fieldStatus.getFieldType();
        System.out.println(fieldName);

        click(getAddSystemFieldsButton());

        if (!isSelected(getAddSystemFieldToList(fieldName))) {
            click(getAddSystemFieldToList(fieldName));
            click(getAddSelectedFieldsButton());
        }
        refresh();
        final String fieldBlock = getFieldBlock(fieldName);

        try {
            return isDisplayed(findByXpath(fieldBlock)) && isDisplayed(findByXpath(format(fieldBlock,
                    XPathBuilder.getXPathByText(fieldType))));
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean enableAddView(final FieldStatus fieldStatus) {
        final String fieldName = fieldStatus.getName();
        WebPageElement addViewCheckbox = null;

        System.out.println(fieldName);
        String fieldBlock = null;

        try {
            fieldBlock = getFieldBlock(fieldName);
            findByXpath(fieldBlock);
        } catch (Exception exception) {
            addSystemField(fieldStatus);
        }

        try {
            addViewCheckbox = findByXpath(getPathOfSpecificCheckbox(fieldBlock, FieldElement.ADD_VIEW_CHECKBOX));

            if (!isSelected(addViewCheckbox)) {
                click(addViewCheckbox);
                try {
                    click(findByXpath(format(fieldBlock, FieldElement.UPDATE_BUTTON)));
                } catch (Exception exception) {
                    System.out.println(fieldName);
                }
                refresh();
            }
        } catch (Exception exception) {
        }

        return isSelected(findByXpath(getPathOfSpecificCheckbox(getFieldBlock(fieldName), FieldElement.ADD_VIEW_CHECKBOX)));
    }
}

