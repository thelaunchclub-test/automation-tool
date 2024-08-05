package com.twozo.test.settings.data.fields;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.twozo.commons.json.JsonObject;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.contact.ContactDataField;
import com.twozo.page.settings.data.fields.contact.field.ContactField;
import com.twozo.test.TestCase;
import com.twozo.test.TestDataProvider;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactDataFieldTest extends DataFieldTest {

    //    @BeforeMethod
//    public void switchToContact() {
//        contactDataField = homePage.switchToSettings().switchToContactDataFields();
//    }
//
//    @Test
//    public void verifyBreadCrumb() {
//        Assert.assertTrue(contactDataField.verifyBreadCrumb());
//    }
//
//    @Test
//    public void verifySelectedTabIsActive() {
//        Assert.assertTrue(contactDataField.verifyActiveContactTab());
//    }
//
//    @Test
//    public void verifyDefaultSystemFields() {
//        Assert.assertTrue(contactDataField.verifyDefaultSystemFields());
//    }
//
//    @Test
//    public void verifyNavigateBackAndForthBetweenDifferentModule() {
//        Assert.assertTrue(contactDataField.switchBetweenTabs());
//    }
//
//    @Test(dataProvider = "searchData")
//    public void verifySearchBarsResult(final Object object) {
//
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("searchData")) {
//            Assert.assertTrue(contactDataField.verifySearchResult(input.getString("searchData")));
//        }
//    }
//
//    @Test(dataProvider = "SystemField")
//    public void addSystemField(final Object object) {
//
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("fieldNameToBeAdded")) {
//            Assert.assertTrue(contactDataField.addSystemField(ContactField.valueOf(input.getString("fieldNameToBeAdded"))));
//        }
//    }
//
//    @Test(dataProvider = "SystemField")
//    public void removeSystemField(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("fieldNameToBeRemoved")) {
//            Assert.assertTrue(contactDataField.removeSystemField(ContactField.valueOf(input.
//                    getString("fieldNameToBeRemoved"))));
//        }
//    }
//
//    @Test(dataProvider = "SystemField")
//    public void addAndRemoveSystemFields(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("fieldNameToBeRemoved")) {
//            Assert.assertTrue(contactDataField.addAndRemoveSystemField(ContactField.valueOf(input.getString
//                    ("fieldToBeAdded")), ContactField.valueOf(input.getString("fieldToBeRemoved"))));
//        }
//    }
//
//    @Test
//    public void verifyNonDraggableFields() {
//        Assert.assertTrue(contactDataField.verifyNonDraggableFields());
//    }
//
//    @Test
//    public void verifyEyeIconIsNotVisibleForDefaultFields() {
//        Assert.assertTrue(contactDataField.verifyEyeIconIsNotVisibleForDefaultFields());
//    }
//
//    @Test
//    public void isAddViewCheckBoxEditableForMandatoryField() {
//        Assert.assertTrue(contactDataField.isAddViewCheckBoxEditableForMandatoryField());
//    }
//
//    @Test
//    public void emailOrPhoneShouldBeRequired() {
//        Assert.assertTrue(contactDataField.emailOrPhoneShouldBeRequired());
//    }
//
//    @Test
//    public void uncheckMandatoryFields() {
//        Assert.assertTrue(contactDataField.uncheckMandatoryFields());
//    }
//
//    @Test(dataProvider = "SystemField")
//    public void addAutoGeneratingSystemField(final Object object) {
//
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
//            Assert.assertTrue(contactDataField.addSystemField(ContactField.valueOf(input.
//                    getString("autoGeneratingFieldToBeAdded"))));
//        }
//    }
//
//    @Test(dataProvider = "SystemField")
//    public void verifyAutoGeneratingSystemFieldNotEditable(final Object object) {
//
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
//            Assert.assertTrue(contactDataField.verifyAutoGeneratingSystemFieldNotEditable(ContactField.valueOf(input.
//                    getString("autoGeneratingFieldToBeAdded"))));
//        }
//    }
//
//    @Test(dataProvider = "SystemField")
//    public void hideAutoGeneratingSystemField(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("autoGeneratingFieldToBeRemoved")) {
//            Assert.assertTrue(contactDataField.hideAutoGeneratingSystemField(ContactField.valueOf(input.
//                    getString("autoGeneratingFieldToBeRemoved"))));
//        }
//    }
//
//    @Test(dataProvider = "SystemField")
//    public void verifyEyeIcon(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("eyeIconFor")) {
//            Assert.assertTrue(contactDataField.verifyEyeIcon(ContactField.valueOf(input.
//                    getString("eyeIconFor"))));
//        }
//    }
//
//    @Test
//    public void verifyAllSystemFieldsType() {
//        contactDataField.addAllSystemFields();
//        contactDataField.checkSystemFieldsFieldType();
//    }
//
//    @DataProvider(name = "CustomField")
//    public static Object[][] getCustomField() {
//        return new TestDataProvider().getTestCases("CustomField.json");
//    }
//
//    @Test(dataProvider = "CustomField")
//    public void addCustomFieldsWithAllFieldType(final Object object) {
//
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
//            Assert.assertTrue(contactDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
//        }
//    }
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

    @Test
    public void addAllSystemFields() {
        contactDataField.addAllSystemFields();
    }

    @Test
    public void enableAllSystemFields() {
        contactDataField.enableAddViewForAllSystemFields();
    }

    @Test(dataProvider = "data")
    public void checkAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setDraggable(input.getBoolean("isDraggable"));
        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        fieldStatus.setAddView(input.getBoolean("isAddView"));
        fieldStatus.setRequired(input.getBoolean("isRequired"));
        contactDataField.checkFieldElements(fieldStatus);
        contactDataField.checkAddView(fieldStatus);
        contactDataField.checkRequired(fieldStatus);
        final String name = fieldStatus.getName();

        if (fieldStatus.isAddView()) {
            Assert.assertTrue(isVisibleInAddForm(name));
        } else {
            Assert.assertFalse(isVisibleInAddForm(name));
        }

        if (fieldStatus.isRequired()) {
            if (contactDataField.getURL().equals("https://app.twozo.live/contacts")) {
                Assert.assertTrue(contactDataField.isVisibleInAddFormAsRequired(name));
            } else {
                isVisibleInAddFormAsRequired(name);
            }
        } else {
            Assert.assertFalse(isVisibleInAddFormAsRequired(name));
        }

        isVisibleInSummary(name);
        isVisibleInColumnSettings(name);
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        final String append = input.getString("append");
        final String newFieldName = String.format("%s%s", name, append);

        // contactDataField.editCustomField(name, append);
        //contactDataField.enableAddView(newFieldName);
        // isVisibleInAddForm(newFieldName);
        Assert.assertTrue(isVisibleInSummary("b"));
        //isVisibleInColumnSettings(newFieldName);
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        contactDataField.hideField(name);
        Assert.assertFalse(isVisibleInAddForm(name));
        Assert.assertFalse(isVisibleInSummary(name));
        Assert.assertFalse(isVisibleInColumnSettings(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        contactDataField.deleteField(name);
        Assert.assertFalse(isVisibleInAddForm(name));
        Assert.assertFalse(isVisibleInSummary(name));
        Assert.assertFalse(isVisibleInColumnSettings(name));
    }

}
