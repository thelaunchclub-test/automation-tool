package com.twozo.page.settings.data.fields.field;

import com.twozo.page.xpath.AttributeName;
import com.twozo.page.xpath.TagName;
import com.twozo.page.xpath.XPath;
import com.twozo.page.xpath.XPathBuilder;

public class FieldElement {

    public static final String NON_DRAGGABLE = XPathBuilder.getXPath(new XPath(TagName.ALL, AttributeName.OPACITY, "0.2", 0));
    public static final String DRAGGABLE = XPathBuilder.getXPath(new XPath(TagName.ALL, AttributeName.OPACITY, "1", 0));
    public static final String ADD_VIEW_UNCHECKED = "//*[@class='MuiBox-root css-w56oqh'])[1]//*[@style='fill: none;']";
    public static final String REQUIRED_UNCHECKED = "//*[@class='MuiBox-root css-w56oqh'])[2]//*[@style='fill: none;']";
    public static final String ADD_VIEW_CHECKED = "//*[@class='MuiBox-root css-w56oqh'])[1]//*[@checked]";
    public static final String REQUIRED_CHECKED = "//*[@class='MuiBox-root css-w56oqh'])[2]//*[@checked]";
    public static final String ADD_VIEW_CHECKBOX = "//*[@type='checkbox'])[1]";
    public static final String REQUIRED_CHECKBOX = "//*[@type='checkbox'])[2]";
    public static final String CANCEL_BUTTON = XPathBuilder.getXPathByText("Cancel");
    public static final String ADD_BUTTON = XPathBuilder.getXPathByText("Add");
    public static final String UPDATE_BUTTON = XPathBuilder.getXPathByText("Update");
    public static final String FIELD_BLOCK = "(//*[@class='css-11x1d9z'])[%d]";
    public static final String SPECIFIC_BLOCK = "((//*[@class='css-11x1d9z'])[%d]/div/div/div/p)[1]";
    public static final String MENU_BLOCK = "(//*[@class='css-u4p24i'])[%d]";
    public static final String CUSTOM_FIELD_NAME = "(//*[@type='text'])[2]";
    public static final String SYSTEM_FIELD_SEARCH_RESULT = "//*[@class='MuiBox-root css-2pd7af']/div";
    public static final String UNCHECKED = "//*[@style='fill: none;']";
    public static final String CHECKED = "//*[@checked]";
    public static final String CHECKBOX = "//*[@type='checkbox']";
    public static final String SPECIFIC_FIELD_COLUMN_SETTINGS_CHECKBOX = "//*[@class='css-eawmf1']//*[text()='%s']/../..//*[@type='checkbox']";
    public static final String EDIT_ICON = "//button[1]";
    public static final String DELETE_ICON = "//button[2]";
    public static final String EYE_ICON = "//button[1]";

}
