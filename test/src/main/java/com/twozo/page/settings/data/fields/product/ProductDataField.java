package com.twozo.page.settings.data.fields.product;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.settings.data.fields.AbstractDataField;
import com.twozo.page.settings.data.fields.field.Field;
import com.twozo.page.settings.data.fields.field.FieldElement;
import com.twozo.page.settings.data.fields.field.FieldTypePath;
import com.twozo.page.settings.data.fields.field.SystemField;
import com.twozo.page.settings.data.fields.product.field.ProductField;
import com.twozo.page.url.settings.SettingsURL;
import com.twozo.page.xpath.XPathBuilder;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.error.code.WebDriverErrorCode;

import java.util.Arrays;
import java.util.List;

public class ProductDataField extends AbstractDataField {

    private static ProductDataField product;

    protected ProductDataField() {
        super();

        if (!getURL().equals(SettingsURL.PRODUCT_DATA_FIELDS)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
        enableProduct();
    }

    public static ProductDataField getInstance() {
        product = new ProductDataField();

        return product;
    }

    public void enableProduct() {
        try{
        if (isDisplayed(findByXpath("//*[contains(text(),'Enables')]"))) {
            click(findByXpath("//*[@class='MuiSwitch-root MuiSwitch-sizeMedium css-1v2eis']"));
            refresh();
        }}catch (Exception exception){

        }

    }

    public boolean verifyActiveContactTab() {
        return isDisplayed(getActiveContactTab());
    }

    public String getNameDiv() {
        return getFieldBlock(ProductField.NAME);
    }

    public String getSalesOwnerDiv() {
        return getFieldBlock(ProductField.SALES_OWNER);
    }

    public String getProductCodeDiv() {
        return getFieldBlock(ProductField.PRODUCT_CODE);
    }

    public String getCategoryDiv() {
        return getFieldBlock(ProductField.CATEGORY);
    }

    public String getUnitPriceDiv() {
        return getFieldBlock(ProductField.UNIT_PRICE);
    }

    private SystemField getNameField() {
        final String NameDiv = getNameDiv();

        return new SystemField(
                findByXpath(format(NameDiv, FieldElement.NON_DRAGGABLE)),
                findByXpath(format(NameDiv, XPathBuilder.getXPathByText(ProductField.NAME.getName()))),
                findByXpath(format(NameDiv, XPathBuilder.getXPathByText(ProductField.NAME.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(NameDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(NameDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getSalesOwnerField() {
        final String salesOwnerDiv = getSalesOwnerDiv();

        return new SystemField(
                findByXpath(format(salesOwnerDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(salesOwnerDiv, XPathBuilder.getXPathByText(ProductField.SALES_OWNER.getName()))),
                findByXpath(format(salesOwnerDiv, XPathBuilder.getXPathByText(ProductField.SALES_OWNER.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(salesOwnerDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getProductCodeField() {
        final String productDiv = getProductCodeDiv();

        return new SystemField(
                findByXpath(format(productDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(productDiv, XPathBuilder.getXPathByText(ProductField.PRODUCT_CODE.getName()))),
                findByXpath(format(productDiv, XPathBuilder.getXPathByText(ProductField.PRODUCT_CODE.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(productDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(productDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getCategoryField() {
        final String categoryDiv = getCategoryDiv();

        return new SystemField(
                findByXpath(format(categoryDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(categoryDiv, XPathBuilder.getXPathByText(ProductField.CATEGORY.getName()))),
                findByXpath(format(categoryDiv, XPathBuilder.getXPathByText(ProductField.CATEGORY.getFieldType()))),
                isSelected(findByXpath(getPathOfSpecificCheckbox(categoryDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(categoryDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    private SystemField getUnitPriceField() {
        final String unitPriceDiv = getUnitPriceDiv();

        return new SystemField(
                findByXpath(format(unitPriceDiv, FieldElement.DRAGGABLE)),
                findByXpath(format(unitPriceDiv, XPathBuilder.getXPathByText(ProductField.UNIT_PRICE.getName()))),
                findByXpath(format(unitPriceDiv, XPathBuilder.getXPathByText(ProductField.UNIT_PRICE.getFieldType()))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(unitPriceDiv, FieldElement.ADD_VIEW_CHECKBOX))),
                !isSelected(findByXpath(getPathOfSpecificCheckbox(unitPriceDiv, FieldElement.REQUIRED_CHECKBOX))),
                null);
    }

    public boolean verifyActiveProductTab() {
        return isDisplayed(getActiveProductTab());
    }

    public void choicesForActiveAndTaxable() {
        String[] choices = {
                "Yes",
                "No"
        };

        for (final String choice : choices) {
            isDisplayed(findByXpath(XPathBuilder.getXPathByText(choice)));
        }
    }

    public void checkCategory() {
        final String category = "Category";
        final String twoChoices = XPathBuilder.getXPathByText("2");
        final String categoryBlock = getFieldBlock(category);

        try {
            isDisplayed(findByXpath(categoryBlock));
        } catch (Exception exception) {
            addSystemField(category);
            isDisplayed(findByXpath(categoryBlock));
        }

        checkSpecificElement(categoryBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(categoryBlock, FieldTypePath.DROPDOWN);
        click(findByXpath(format(categoryBlock, twoChoices)));
        isDisplayed(findByXpath(XPathBuilder.getXPathByText("Hardware")));
        isDisplayed(findByXpath(XPathBuilder.getXPathByText("Software")));
        refresh();
    }

    public void checkActive() {
        final String active = "Active";
        final String twoChoices = XPathBuilder.getXPathByText("2");
        final String activeBlock = getFieldBlock(active);

        try {
            isDisplayed(findByXpath(activeBlock));
        } catch (Exception exception) {
            addSystemField(active);
            isDisplayed(findByXpath(activeBlock));
        }

        checkSpecificElement(activeBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(activeBlock, FieldTypePath.DROPDOWN);
        click(findByXpath(format(activeBlock, twoChoices)));
        choicesForActiveAndTaxable();
        refresh();
    }

    public void checkTaxable() {
        final String taxable = "Taxable";
        final String twoChoices = XPathBuilder.getXPathByText("2");
        final String taxableBlock = getFieldBlock(taxable);

        try {
            isDisplayed(findByXpath(taxableBlock));
        } catch (Exception exception) {
            addSystemField(taxable);
            isDisplayed(findByXpath(taxableBlock));
        }

        checkSpecificElement(taxableBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(taxableBlock, FieldTypePath.DROPDOWN);
        click(findByXpath(format(taxableBlock, twoChoices)));
        choicesForActiveAndTaxable();
        refresh();
    }

    public void checkType() {
        final String type = "Type";
        final String twoChoices = XPathBuilder.getXPathByText("2");
        final String typeBlock = getFieldBlock(type);

        try {
            isDisplayed(findByXpath(typeBlock));
        } catch (Exception exception) {
            addSystemField(type);
            isDisplayed(findByXpath(typeBlock));
        }

        checkSpecificElement(typeBlock, FieldElement.DRAGGABLE);
        checkSpecificElement(typeBlock, FieldTypePath.DROPDOWN);
        click(findByXpath(format(typeBlock, twoChoices)));
        isDisplayed(findByXpath(XPathBuilder.getXPathByText("Unit")));
        isDisplayed(findByXpath(XPathBuilder.getXPathByText("Subscription")));
        refresh();
    }


    @Override
    protected List<Field> getDefaultFields() {
        return ProductField.getDefaultFields();
    }

    @Override
    protected Field[] getAllFields() {
        return ProductField.values();
    }

    @Override
    protected List<String> getMandatoryFields() {
        return Arrays.asList(getNameDiv(), getSalesOwnerDiv());
    }

    @Override
    public boolean verifyNonDraggableFields() {
        return isNonDraggableIconDisplayed(getNameDiv());
    }

    @Override
    protected List<Record> getDefaultSystemFieldElements() {
        return List.of(getNameField(), getSalesOwnerField(), getProductCodeField(), getCategoryField(), getUnitPriceField());
    }

    @Override
    public boolean isDefaultFieldsVisibleInSummary() {
        final List<Field> summaryDefaultFields = List.of(ProductField.SALES_OWNER, ProductField.UNIT_PRICE,
                ProductField.PRODUCT_CODE, ProductField.CATEGORY);

        for (final Field summaryDefaultField : summaryDefaultFields) {

            if (!isDisplayed(findByXpath(format("//*[@class='css-itno5t']",
                    XPathBuilder.getXPathByText(summaryDefaultField.getName()))))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean uncheckMandatoryFields() {
        final String[] mandatoryFields = new String[]{
                getNameDiv(),
        };
        unCheck(mandatoryFields);

        return true;
    }

}
