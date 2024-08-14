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
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(productDataField.verifyDefaultSystemFields());
    }

    @Test(dataProvider = "contactSystemFields")
    public void addSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));

        Assert.assertTrue(productDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(productDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        final String append = input.getString("append");
        final String newFieldName = String.format("%s%s", name, append);

        productDataField.editCustomField(name, append);
        productDataField.isVisibleInDataFields(newFieldName);
        Assert.assertTrue(isVisibleInSummary(newFieldName));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        productDataField.hideField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        productDataField.deleteField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }

    @Test(dataProvider = "contactSystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(productDataField.enableAddView(fieldStatus));
    }

    @Test(dataProvider = "contactSystemFields")
    public void enableRequired(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(contactDataField.enableRequired(fieldStatus));
    }
//
//    @Test(dataProvider = "contactSystemFields")
//    public void checkAddForm(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final FieldStatus fieldStatus = new FieldStatus();
//
//        fieldStatus.setName(input.getString("name"));
//        fieldStatus.setAddView(input.getBoolean("isAddView"));
//        productDataField.addSystemField(fieldStatus);
//        productDataField.checkAddView(fieldStatus);
//        final String name = fieldStatus.getName();
//
//        if (fieldStatus.isAddView()) {
//            Assert.assertTrue(isVisibleInAddForm(name));
//        } else {
//            Assert.assertFalse(isVisibleInAddForm(name));
//        }
//    }
//
//    @Test(dataProvider = "contactSystemFields")
//    public void checkInAddForm(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final FieldStatus fieldStatus = new FieldStatus();
//
//        fieldStatus.setName(input.getString("name"));
//        fieldStatus.setFieldType(input.getString("fieldType"));
//
//        final String name = fieldStatus.getName();
//
//        if (productDataField.enableRequired(fieldStatus)) {
//            if (productDataField.getURL().equals("https://app.twozo.live/contacts")) {
//                Assert.assertTrue(productDataField.isVisibleInAddFormAsRequired(name));
//            } else {
//                isVisibleInAddFormAsRequired(name);
//            }
//        } else {
//            Assert.assertFalse(isVisibleInAddFormAsRequired(name));
//        }
//    }

    @Override
    public boolean isVisibleInSummary(String fieldName) {
        homePage.switchToProduct();
        productDataField.switchToSummary();
        return productDataField.isVisibleInSummary(fieldName);
    }

    @Override
    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToProduct();
        productDataField.switchToAddProductForm();
        Assert.assertTrue(productDataField.isDefaultFieldsVisibleInAddView());
    }

    @Override
    public boolean isVisibleInAddForm(String fieldName) {
        homePage.switchToProduct();
        productDataField.switchToAddProductForm();
        return productDataField.isVisibleInAddForm(fieldName);
    }

    @Override
    public boolean isVisibleInAddFormAsRequired(String fieldName) {
        homePage.switchToProduct();
        contactDataField.switchToAddProductForm();
        return productDataField.isVisibleInAddFormAsRequired(fieldName);    }

    @Override
    public boolean isVisibleInColumnSettings(String fieldName) {
        homePage.switchToProduct().switchToColumnSettings();
        homePage.switchToContact();
        return productDataField.isVisibleInColumnSettings(fieldName);    }
}
