package com.twozo.test.settings.data.fields;

import com.twozo.commons.json.JsonObject;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.test.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDataFieldTest extends DataFieldTest {

//
//    @Test(dataProvider = "SystemField")
//    public void isDefaultFieldsVisibleInSummary(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        homePage.switchToContact();
//        contactDataField.switchToSummary();
//
//        if (input.containsKey("fieldToBeChecked")) {
//            Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInSummary());
//        }
//    }
//
//    @Test
//    public void isDefaultFieldsVisibleInColumnSettings() {
//        homePage.switchToContact();
//        homePage.switchToContact().switchToColumnSettings();
//        Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInListColumnSettings());
//    }
//
//    @Test(dataProvider = "testCase")
//    public void checkFields(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final FieldStatus fieldStatus = new FieldStatus();
//
//        fieldStatus.setDraggable(input.getBoolean("isDraggable"));
//        fieldStatus.setName(input.getString("name"));
//        fieldStatus.setFieldType(input.getString("fieldType"));
//        fieldStatus.setAddView(input.getBoolean("isAddView"));
//        fieldStatus.setRequired(input.getBoolean("isRequired"));
//        fieldStatus.setEditable(input.getBoolean("isEditable"));
//        fieldStatus.setHideable(input.getBoolean("isHideable"));
//
//        contactDataField.checkIfDisplayed(fieldStatus);
//        isVisibleInSummary(fieldStatus.getName());
//        isVisibleInColumnSettings(fieldStatus.getName());
//
//        if (fieldStatus.isAddView()) {
//            isVisibleInAddForm(fieldStatus.getName());
//        }
//    }
//    @Test(dataProvider = "addView")
//    public void checkAddView(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final FieldStatus fieldStatus = new FieldStatus();
//
//        fieldStatus.setDraggable(input.getBoolean("isDraggable"));
//        fieldStatus.setName(input.getString("name"));
//        fieldStatus.setFieldType(input.getString("fieldType"));
//        fieldStatus.setAddView(input.getBoolean("isAddView"));
//        boolean isChecked = contactDataField.checkAddView(fieldStatus);
//
//        if (isChecked) {
//            Assert.assertTrue(isVisibleInAddForm(fieldStatus.getName()));
//        } else {
//            Assert.assertFalse(isVisibleInAddForm(fieldStatus.getName()));
//        }
//    }

//    @AfterMethod
//    public void switchToContactDataFields() {
//        HomePage.getInstance(webAutomationDriver).switchToSettings().switchToContactDataFields();
//    }

//
//    @Test(dataProvider = "data")
//    public void checkAddViewCustomField(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final FieldStatus fieldStatus = new FieldStatus();
//
//        fieldStatus.setDraggable(input.getBoolean("isDraggable"));
//        fieldStatus.setName(input.getString("name"));
//        fieldStatus.setFieldType(input.getString("fieldType"));
//        fieldStatus.setAddView(input.getBoolean("isAddView"));
//        fieldStatus.setRequired(input.getBoolean("isRequired"));
//        contactDataField.checkFieldElements(fieldStatus);
//        contactDataField.checkAddView(fieldStatus);
//        contactDataField.checkRequired(fieldStatus);
//        final String name = fieldStatus.getName();
//
//        if (fieldStatus.isAddView()) {
//            Assert.assertTrue(isVisibleInAddForm(name));
//        } else {
//            Assert.assertFalse(isVisibleInAddForm(name));
//        }
//
//        if (fieldStatus.isRequired()) {
//            if (contactDataField.getURL().equals("https://app.twozo.live/contacts")) {
//                Assert.assertTrue(contactDataField.isVisibleInAddFormAsRequired(name));
//            } else {
//                isVisibleInAddFormAsRequired(name);
//            }
//        } else {
//            Assert.assertFalse(isVisibleInAddFormAsRequired(name));
//        }
//
//        isVisibleInSummary(name);
//        isVisibleInColumnSettings(name);
//    }

//    @Test(dataProvider = "hideField")
//    public void hideField(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final String name = input.getString("name");
//        contactDataField.hideField(name);
//        Assert.assertFalse(isVisibleInAddForm(name));
//        Assert.assertFalse(isVisibleInSummary(name));
//        Assert.assertFalse(isVisibleInColumnSettings(name));
//    }


//    @Test
//    public void dragAndDrop() {
//        contactDataField.fromTo("Company");
//    }


    //    @Test
//    public void check() {
//        contactDataField.isEnabled();
//    }
//======================================================================================================================

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(contactDataField.verifyDefaultSystemFields());
    }

    @Test(dataProvider = "contactSystemFields")
    public void addSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));

        Assert.assertTrue(contactDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(contactDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("fieldName");
        final String append = input.getString("append");
        final String newFieldName = String.format("%s%s", name, append);

        contactDataField.editCustomField(name, append);
       // Assert.assertTrue(contactDataField.isVisibleInDataFields(newFieldName));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertTrue(contactDataField.hideField(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        contactDataField.deleteField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }

    @Test(dataProvider = "contactSystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(contactDataField.enableAddView(fieldStatus));
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
//        contactDataField.addSystemField(fieldStatus);
//        contactDataField.checkAddView(fieldStatus);
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
//        if (contactDataField.enableRequired(fieldStatus)) {
//            if (contactDataField.getURL().equals(URL.CONTACTS)) {
//                Assert.assertTrue(contactDataField.isVisibleInAddFormAsRequired(name));
//            } else {
//                isVisibleInAddFormAsRequired(name);
//            }
//        } else {
//            Assert.assertFalse(isVisibleInAddFormAsRequired(name));
//        }
//    }
//

    @Test
    public void checkSubscriptionStatus() {
        contactDataField.checkSubscriptionStatus();
    }

    @Test
    public void checkLifecycleStage() {
        contactDataField.checkLifecycleStage();
    }

    @Test
    public void checkTimeZone() {
        contactDataField.checkTimezone();
    }

    @Override
    public boolean isVisibleInSummary(String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToSummary();
        return contactDataField.isVisibleInSummary(fieldName);
    }

    @Override
    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInAddView());
    }

    @Override
    public boolean isVisibleInAddForm(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        return contactDataField.isVisibleInAddForm(fieldName);
    }

    @Override
    public boolean isVisibleInAddFormAsRequired(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        return contactDataField.isVisibleInAddFormAsRequired(fieldName);
    }

    @Override
    public boolean isVisibleInColumnSettings(final String fieldName) {
        homePage.switchToContact().switchToColumnSettings();
        homePage.switchToContact();
        return contactDataField.isVisibleInColumnSettings(fieldName);
    }
}
