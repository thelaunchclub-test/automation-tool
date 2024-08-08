package com.twozo.test.settings.data.fields;

import com.twozo.commons.json.JsonObject;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.product.field.ProductField;
import com.twozo.test.TestCase;
import com.twozo.test.TestDataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductDataFieldTest extends DataFieldTest {

    @Test
    public void verifyBreadCrumb() {
        Assert.assertTrue(productDataField.verifyBreadCrumb());
    }

    @Test
    public void verifySelectedTabIsActive() {
        Assert.assertTrue(productDataField.verifyActiveContactTab());
    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(productDataField.verifyDefaultSystemFields());
    }

    @Test
    public void verifyNavigateBackAndForthBetweenDifferentModule() {
        Assert.assertTrue(productDataField.switchBetweenTabs());
    }

    @Test(dataProvider = "SearchData")
    public void verifySearchBarsResult(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("searchData")) {
            Assert.assertTrue(productDataField.verifySearchResult(input.getString("searchData")));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeAdded")) {
            Assert.assertTrue(productDataField.addSystemField(ProductField.valueOf(input.getString("fieldNameToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void removeSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(productDataField.removeSystemField(ProductField.valueOf(input.
                    getString("fieldNameToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addAndRemoveSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(productDataField.addAndRemoveSystemField(ProductField.valueOf(input.getString
                    ("fieldToBeAdded")), ProductField.valueOf(input.getString("fieldToBeRemoved"))));
        }
    }

    @Test
    public void verifyNonDraggableFields() {
        Assert.assertTrue(productDataField.verifyNonDraggableFields());
    }

    @Test
    public void verifyEyeIconIsNotVisibleForDefaultFields() {
        Assert.assertTrue(productDataField.verifyEyeIconIsNotVisibleForDefaultFields());
    }

    @Test
    public void isAddViewCheckBoxEditableForMandatoryField() {
        Assert.assertTrue(productDataField.isAddViewCheckBoxEditableForMandatoryField());
    }

    @Test
    public void uncheckMandatoryFields() {
        Assert.assertTrue(productDataField.uncheckMandatoryFields());
    }

    @Test(dataProvider = "SystemField")
    public void addAutoGeneratingSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(productDataField.addSystemField(ProductField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyAutoGeneratingSystemFieldNotEditable(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(productDataField.verifyAutoGeneratingSystemFieldNotEditable(ProductField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void hideAutoGeneratingSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeRemoved")) {
            Assert.assertTrue(productDataField.hideAutoGeneratingSystemField(ProductField.valueOf(input.
                    getString("autoGeneratingFieldToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyEyeIcon(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("eyeIconFor")) {
            Assert.assertTrue(productDataField.verifyEyeIcon(ProductField.valueOf(input.
                    getString("eyeIconFor"))));
        }
    }

    @Test
    public void verifyAllSystemFieldsType() {
        productDataField.addAllSystemFields();
        productDataField.checkSystemFieldsFieldType();
    }

    @DataProvider(name = "CustomField")
    public static Object[][] getCustomField() {
        return new TestDataProvider().getTestCases("CustomField.json");
    }

    @Test(dataProvider = "CustomField")
    public void addCustomFieldsWithAllFieldType(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(productDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "SystemField")
    public void isDefaultFieldsVisibleInSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        homePage.switchToProduct();
        productDataField.switchToSummary();

        if (input.containsKey("fieldToBeChecked")) {
            Assert.assertTrue(productDataField.isDefaultFieldsVisibleInSummary());
        }
    }

    @Test
    public void isDefaultFieldsVisibleInColumnSettings() {
        homePage.switchToContact();
        homePage.switchToContact().switchToColumnSettings();
        Assert.assertTrue(productDataField.isDefaultFieldsVisibleInListColumnSettings());
    }

    @Test(dataProvider = "testCase")
    public void checkFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setDraggable(input.getBoolean("isDraggable"));
        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        fieldStatus.setAddView(input.getBoolean("isAddView"));
        fieldStatus.setRequired(input.getBoolean("isRequired"));
        fieldStatus.setEditable(input.getBoolean("isEditable"));
        fieldStatus.setHideable(input.getBoolean("isHideable"));

        productDataField.checkIfDisplayed(fieldStatus);
        isVisibleInSummary(fieldStatus.getName());
        isVisibleInColumnSettings(fieldStatus.getName());

        if (fieldStatus.isAddView()) {
            isVisibleInAddForm(fieldStatus.getName());
        }
    }

    @Test(dataProvider = "productSystemFields")
    public void addAllSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));

        Assert.assertTrue(productDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "productSystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));

        Assert.assertTrue(productDataField.enableAddView(fieldStatus));
    }

    @Test(dataProvider = "productSystemFields")
    public void checkAddForm(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setAddView(input.getBoolean("isAddView"));
        productDataField.addSystemField(fieldStatus);
        productDataField.checkAddView(fieldStatus);
        final String name = fieldStatus.getName();

        if (fieldStatus.isAddView()) {
            Assert.assertTrue(isVisibleInAddForm(name));
        } else {
            Assert.assertFalse(isVisibleInAddForm(name));
        }
    }
}
