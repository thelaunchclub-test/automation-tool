package com.twozo.test.settings.data.fields;

import com.twozo.commons.json.JsonObject;
import com.twozo.page.contact.Contact;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.contact.field.ContactField;
import com.twozo.test.TestCase;
import com.twozo.test.TestDataProvider;
import com.twozo.test.settings.SettingsTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactDataFieldTest extends SettingsTest {




    //private Contact contact;

    //    @BeforeMethod
//    public void initialize() {
//        contact = settings.switchToContactDataFields();
//    }
//    @AfterMethod
//    public void clear(){
//        contact.switchToContactDataFields();
//    }

    @Test
    public void verifyBreadCrumb() {
        Assert.assertTrue(contactDataField.verifyBreadCrumb());
    }

    @Test
    public void verifySelectedTabIsActive() {
        Assert.assertTrue(contactDataField.verifyActiveContactTab());
    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(contactDataField.verifyDefaultSystemFields());
    }

    @Test
    public void verifyNavigateBackAndForthBetweenDifferentModule() {
        Assert.assertTrue(contactDataField.switchBetweenTabs());
    }

//    @Test
//    public void verifySystemFieldTabsDoesNotHideOtherTabs() {
//        Assert.assertTrue(contact.verifySystemFieldTabsDoesNotHideOtherTabs());
//    }

    @DataProvider(name = "SearchData")
    public static Object[][] getSearchData() {
        return new TestDataProvider().getTestCases("SearchData.json");
    }

    @Test(dataProvider = "SearchData")
    public void verifySearchBarsResult(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("searchData")) {
            Assert.assertTrue(contactDataField.verifySearchResult(input.getString("searchData")));
        }
    }

    @DataProvider(name = "SystemField")
    public static Object[][] getSystemField() {
        return new TestDataProvider().getTestCases("SystemField.json");
    }

    @Test(dataProvider = "SystemField")
    public void addSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeAdded")) {
            Assert.assertTrue(contactDataField.addSystemField(ContactField.valueOf(input.getString("fieldNameToBeAdded"))));
        }
    }


    @Test(dataProvider = "SystemField")
    public void removeSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(contactDataField.removeSystemField(ContactField.valueOf(input.
                    getString("fieldNameToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addAndRemoveSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(contactDataField.addAndRemoveSystemField(ContactField.valueOf(input.getString
                    ("fieldToBeAdded")), ContactField.valueOf(input.getString("fieldToBeRemoved"))));
        }
    }

    @Test
    public void verifyNonDraggableFields() {
        Assert.assertTrue(contactDataField.verifyNonDraggableFields());
    }

    @Test
    public void verifyEyeIconIsNotVisibleForDefaultFields() {
        Assert.assertTrue(contactDataField.verifyEyeIconIsNotVisibleForDefaultFields());
    }

    @Test
    public void isAddViewCheckBoxEditableForMandatoryField() {
        Assert.assertTrue(contactDataField.isAddViewCheckBoxEditableForMandatoryField());
    }

    @Test
    public void emailOrPhoneShouldBeRequired() {
        Assert.assertTrue(contactDataField.emailOrPhoneShouldBeRequired());
    }

    @Test
    public void uncheckMandatoryFields() {
        Assert.assertTrue(contactDataField.uncheckMandatoryFields());
    }

    @Test(dataProvider = "SystemField")
    public void addAutoGeneratingSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(contactDataField.addSystemField(ContactField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyAutoGeneratingSystemFieldNotEditable(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(contactDataField.verifyAutoGeneratingSystemFieldNotEditable(ContactField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void hideAutoGeneratingSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeRemoved")) {
            Assert.assertTrue(contactDataField.hideAutoGeneratingSystemField(ContactField.valueOf(input.
                    getString("autoGeneratingFieldToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyEyeIcon(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("eyeIconFor")) {
            Assert.assertTrue(contactDataField.verifyEyeIcon(ContactField.valueOf(input.
                    getString("eyeIconFor"))));
        }
    }

    @Test
    public void verifyAllSystemFieldsType() {
        contactDataField.addAllSystemFields();
        contactDataField.checkSystemFieldsFieldType();
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
            Assert.assertTrue(contactDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }

        // contact.addCustomField("a", FieldType.TEXT);
        //contact.addCustomField("b", FieldType.LARGE_TEXT);
//        contact.addCustomField("c", FieldType.NUMBER);
//        contact.addCustomField("f", FieldType.OWNER);
//        contact.addCustomField("g", FieldType.COMPANY);
//        contact.addCustomField("h", FieldType.CONTACT);
//        contact.addCustomField("i", FieldType.PHONE);
//        contact.addCustomField("j", FieldType.EMAIL);
//        contact.addCustomField("k", FieldType.MONETARY);
//        contact.addCustomField("l", FieldType.TIME);
//        contact.addCustomField("m", FieldType.TIME_RANGE);
//        contact.addCustomField("n", FieldType.DATE);
//        contact.addCustomField("o", FieldType.DATE_RANGE);
//        contact.addCustomField("p", FieldType.DATE_TIME_RANGE);
//        contact.addCustomField("q", FieldType.ADDRESS);
        //contact.addCustomField("d", FieldType.DROPDOWN);
        //contact.addCustomField("e", FieldType.MULTI_SELECT);
    }

    //    @Test
//    public void verifyEyeIcon(){
//        Assert.assertTrue(contact.hideAutoGeneratingSystemField(ContactAutoGeneratingField.DONE_ACTIVITIES));
//    }
    @Test(dataProvider = "SystemField")
    public void isDefaultFieldsVisibleInSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        homePage.switchToContact();
        contactDataField.switchToContactSummary();

        if (input.containsKey("fieldToBeChecked")) {
            Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInSummary());
        }
    }

    //    @Test(dataProvider = "SystemField")
    public void isVisibleInSummary(final String fieldName) {

        // Assert.assertTrue(contact.checkIfGivenFieldIsInList(fieldName);

        homePage.switchToContact();
        contactDataField.switchToContactSummary();
        Assert.assertTrue(contactDataField.isVisibleInSummary(fieldName));
    }

    @Test
    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        //contact.isDefaultFieldsVisibleInAddView();
        Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInAddView());
    }

    //  @Test(dataProvider = "SystemField")
    public void isVisibleInAddForm(final String fieldName) {
//        Assert.assertTrue(contact.checkIfGivenFieldsAddViewIsChecked("iio"));
//        homePage.switchToContact();
//        contact.switchToAddContactForm();
//        Assert.assertTrue(contact.isVisibleInAddForm("iio"));
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//
//        if (input.containsKey("fieldToBeChecked")) {
        //  Assert.assertTrue(contact.checkIfGivenFieldsAddViewIsChecked(fieldName));
        //}
        homePage.switchToContact();
        contactDataField.switchToContactSummary();
        //Assert.assertTrue(contact.isVisibleInSummary());
        //  if (input.containsKey("fieldToBeChecked")) {
        Assert.assertTrue(contactDataField.isVisibleInAddForm(fieldName));
        // }
    }

    @Test
    public void isDefaultFieldsVisibleInColumnSettings() {
        homePage.switchToContact();
        homePage.switchToContact().switchToColumnSettings();
        Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInListColumnSettings());
    }

    public void isVisibleInColumnSettings(final String fieldName) {
        homePage.switchToContact().switchToColumnSettings();
        Assert.assertTrue(contactDataField.isVisibleInColumnSettings(fieldName));
    }

    @DataProvider(name = "testCase")
    public static Object[][] getData() {
        return new TestDataProvider().getTestCases("TestCase.json");
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

        contactDataField.check(fieldStatus);
        isVisibleInSummary(fieldStatus.getName());
        isVisibleInColumnSettings(fieldStatus.getName());

        if (fieldStatus.isAddView()) {
            isVisibleInAddForm(fieldStatus.getName());
        }

    }




}
