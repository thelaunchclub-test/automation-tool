package com.twozo.test.settings.data.fields;

import com.twozo.commons.json.JsonObject;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.deal.field.DealField;
import com.twozo.test.TestCase;
import com.twozo.test.TestDataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DealDataFieldTest extends DataFieldTest {

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(dealDataField.verifyDefaultSystemFields());
    }

    @Test(dataProvider = "dealSystemFields")
    public void addSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));

        Assert.assertTrue(dealDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(dealDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        final String append = input.getString("append");
        final String newFieldName = String.format("%s%s", name, append);

        dealDataField.editCustomField(name, append);
        dealDataField.isVisibleInDataFields(newFieldName);
        Assert.assertTrue(isVisibleInSummary(newFieldName));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        dealDataField.hideField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        dealDataField.deleteField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }

    @Test(dataProvider = "dealSystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(dealDataField.enableAddView(fieldStatus));
    }

    @Test(dataProvider = "dealSystemFields")
    public void enableRequired(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(dealDataField.enableRequired(fieldStatus));
    }
//
//    @Test(dataProvider = "dealSystemFields")
//    public void checkAddForm(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final FieldStatus fieldStatus = new FieldStatus();
//
//        fieldStatus.setName(input.getString("name"));
//        fieldStatus.setAddView(input.getBoolean("isAddView"));
//        dealDataField.addSystemField(fieldStatus);
//        dealDataField.checkAddView(fieldStatus);
//        final String name = fieldStatus.getName();
//
//        if (fieldStatus.isAddView()) {
//            Assert.assertTrue(isVisibleInAddForm(name));
//        } else {
//            Assert.assertFalse(isVisibleInAddForm(name));
//        }
//    }
//
//    @Test(dataProvider = "dealSystemFields")
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
//        if (dealDataField.enableRequired(fieldStatus)) {
//            if (dealDataField.getURL().equals("https://app.twozo.live/contacts")) {
//                Assert.assertTrue(dealDataField.isVisibleInAddFormAsRequired(name));
//            } else {
//                isVisibleInAddFormAsRequired(name);
//            }
//        } else {
//            Assert.assertFalse(isVisibleInAddFormAsRequired(name));
//        }
//    }

    @Test
    public void checkPipeline(){
        dealDataField.checkPipeline();
    }

    @Override
    public boolean isVisibleInSummary(String fieldName) {
        homePage.switchToDeal();
        dealDataField.switchToSummary();
        return dealDataField.isVisibleInSummary(fieldName);    }

    @Override
    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToDeal();
        dealDataField.switchToAddDealForm();
        Assert.assertTrue(dealDataField.isDefaultFieldsVisibleInAddView());
    }

    @Override
    public boolean isVisibleInAddForm(String fieldName) {
        homePage.switchToDeal();
        dealDataField.switchToAddDealForm();
        return dealDataField.isVisibleInAddForm(fieldName);    }

    @Override
    public boolean isVisibleInAddFormAsRequired(String fieldName) {
        homePage.switchToDeal();
        dealDataField.switchToAddDealForm();
        return dealDataField.isVisibleInAddFormAsRequired(fieldName);    }

    @Override
    public boolean isVisibleInColumnSettings(String fieldName) {
        homePage.switchToDeal().switchToColumnSettings();
        homePage.switchToDeal();
        return dealDataField.isVisibleInColumnSettings(fieldName);    }
}
