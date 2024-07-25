package com.twozo.page.settings.data.fields;

import com.twozo.page.settings.Settings;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.FieldElement;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.element.service.WebPageElement;

import java.util.List;

public abstract class DataField extends Settings {
    private static final String TWO_STRING_FORMAT = "%s%s";
    private static final String THREE_STRING_FORMAT = "%s%s%s";
    private static final String OPEN_PARENTHESIS = "(";

    private WebPageElement addSystemFieldsButton;
    private WebPageElement addSelectedFieldsButton;
    private WebPageElement addCustomFieldButton;
    private WebPageElement customFieldName;
    private WebPageElement selectCustomFieldType;
    private WebPageElement customFieldAddButton;
    private WebPageElement choice;
    private WebPageElement addChoice;
    private WebPageElement addSystemFieldSearchBar;
    private WebPageElement breadCrumb;

    protected DataField(WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
    }

    protected String format(final String div, final String element) {

        return String.format(TWO_STRING_FORMAT, div, element);
    }

    protected String getPathOfSpecificCheckbox(final String div, final String element) {
        return String.format(THREE_STRING_FORMAT, OPEN_PARENTHESIS, div, element);
    }

    protected WebPageElement getAddSystemFieldsButton() {
        addSystemFieldsButton = initializeElement(addSystemFieldsButton, () -> findByText(Button.SYSTEM_FIELDS));

        return addSystemFieldsButton;
    }

    protected WebPageElement getAddSelectedFieldsButton() {
        addSelectedFieldsButton = initializeElement(addSelectedFieldsButton, () -> findByText(Button.ADD_SELECTED_FIELDS));

        return addSelectedFieldsButton;
    }

    public WebPageElement getAddCustomFieldButton() {
        //addCustomFieldButton = initializeElement(addCustomFieldButton, () -> findByText(Button.CUSTOM_FIELD));
        addCustomFieldButton = findByText(Button.CUSTOM_FIELD);

        return findByText(Button.CUSTOM_FIELD);
    }

    protected WebPageElement getCustomFieldName() {
        // customFieldName = initializeElement(customFieldName, () -> findByXpath(FieldElement.CUSTOM_FIELD_NAME));
        customFieldName = findByXpath(FieldElement.CUSTOM_FIELD_NAME);

        return customFieldName;
    }

    protected WebPageElement getSelectCustomFieldType() {
        //selectCustomFieldType = initializeElement(selectCustomFieldType, () -> findByXpath(Button.CUSTOM_FIELDS_FIELD_TYPE));
        selectCustomFieldType = findByXpath(Button.CUSTOM_FIELDS_FIELD_TYPE);

        return selectCustomFieldType;
    }

    protected WebPageElement getCustomFieldAddButton() {
//        customFieldAddButton = initializeElement(customFieldAddButton, () -> findByXpath(FieldElement.ADD_BUTTON));
        customFieldAddButton = findByXpath(FieldElement.ADD_BUTTON);

        return customFieldAddButton;
    }

    protected WebPageElement getChoice() {
//        choice = initializeElement(choice, () -> findByText(Button.CHOICE));
        choice = findByText(Button.CHOICE);

        return choice;
    }

    protected WebPageElement getAddChoice() {
        //addChoice = initializeElement(addChoice, () -> findByText(Button.ADD_CHOICE));
        addChoice = findByText(Button.ADD_CHOICE);

        return addChoice;
    }

    protected WebPageElement getBreadCrumb() {
        breadCrumb = initializeElement(breadCrumb, () -> findRightElement(List.of(new Element(LocatorType.XPATH,
                buildXpathByText("Admin Settings"), true), new Element(LocatorType.TAG_NAME, "svg",
                false))));

        return breadCrumb;
    }

    protected WebPageElement getAddSystemFieldSearchBar() {
        addSystemFieldSearchBar = initializeElement(addSystemFieldSearchBar, () ->
                findByXpath("(//*[@placeholder='Search'])[2]"));

        return addSystemFieldSearchBar;
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

        click(findByXpath(FieldElement.CANCEL_BUTTON));
        click(getCustomFieldAddButton());
        refresh();
        return true;
    }

    protected abstract Field[] getAllFields();

}
