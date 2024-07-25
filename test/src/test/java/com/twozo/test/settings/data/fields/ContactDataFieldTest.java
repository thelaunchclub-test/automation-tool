package com.twozo.test.settings.data.fields;

import com.twozo.commons.json.JsonObject;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.contact.field.ContactDataField;
import com.twozo.test.TestCase;
import com.twozo.test.TestDataProvider;
import com.twozo.test.settings.SettingsTest;

import org.testng.Assert;
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
        Assert.assertTrue(contact.verifyBreadCrumb());
    }

    @Test
    public void verifySelectedTabIsActive() {
        Assert.assertTrue(contact.verifyActiveContactTab());
    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(contact.verifyDefaultSystemFields());
    }

    @Test
    public void verifyNavigateBackAndForthBetweenDifferentModule() {
        Assert.assertTrue(contact.switchBetweenTabs());
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
            Assert.assertTrue(contact.verifySearchResult(input.getString("searchData")));
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
            Assert.assertTrue(contact.addSystemField(ContactDataField.valueOf(input.getString("fieldNameToBeAdded"))));
        }
    }


    @Test(dataProvider = "SystemField")
    public void removeSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(contact.removeSystemField(ContactDataField.valueOf(input.
                    getString("fieldNameToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addAndRemoveSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(contact.addAndRemoveSystemField(ContactDataField.valueOf(input.getString
                    ("fieldToBeAdded")), ContactDataField.valueOf(input.getString("fieldToBeRemoved"))));
        }
    }

    @Test
    public void verifyNonDraggableFields() {
        Assert.assertTrue(contact.verifyNonDraggableFields());
    }

    @Test
    public void verifyEyeIconIsNotVisibleForDefaultFields() {
        Assert.assertTrue(contact.verifyEyeIconIsNotVisibleForDefaultFields());
    }

    @Test
    public void isAddViewCheckBoxEditableForMandatoryField() {
        Assert.assertTrue(contact.isAddViewCheckBoxEditableForMandatoryField());
    }

    @Test
    public void emailOrPhoneShouldBeRequired() {
        Assert.assertTrue(contact.emailOrPhoneShouldBeRequired());
    }

    @Test
    public void uncheckMandatoryFields() {
        Assert.assertTrue(contact.uncheckMandatoryFields());
    }

    @Test(dataProvider = "SystemField")
    public void addAutoGeneratingSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(contact.addAutoGeneratingSystemField(ContactDataField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyAutoGeneratingSystemFieldNotEditable(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(contact.verifyAutoGeneratingSystemFieldNotEditable(ContactDataField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void hideAutoGeneratingSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeRemoved")) {
            Assert.assertTrue(contact.hideAutoGeneratingSystemField(ContactDataField.valueOf(input.
                    getString("autoGeneratingFieldToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyEyeIcon(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("eyeIconFor")) {
            Assert.assertTrue(contact.verifyEyeIcon(ContactDataField.valueOf(input.
                    getString("eyeIconFor"))));
        }
    }

    @Test
    public void verifyAllSystemFieldsType() {
        contact.addAllSystemFields();
        contact.checkSystemFieldsFieldType();
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
            Assert.assertTrue(contact.addCustomField(input.getString("fieldName"), input.getString("fieldName")));
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
        contact.switchToContactSummary();

        if (input.containsKey("fieldToBeChecked")) {
            Assert.assertTrue(contact.isDefaultFieldsVisibleInSummary());
        }
    }

    //    @Test(dataProvider = "SystemField")
    public void isVisibleInSummary(final String fieldName) {

       // Assert.assertTrue(contact.checkIfGivenFieldIsInList(fieldName);

        homePage.switchToContact();
        contact.switchToContactSummary();
        Assert.assertTrue(contact.isVisibleInSummary(fieldName));
    }

    @Test
    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToContact();
        contact.switchToAddContactForm();
        //contact.isDefaultFieldsVisibleInAddView();
        Assert.assertTrue(contact.isDefaultFieldsVisibleInAddView());
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
        contact.switchToContactSummary();
        //Assert.assertTrue(contact.isVisibleInSummary());
        //  if (input.containsKey("fieldToBeChecked")) {
        Assert.assertTrue(contact.isVisibleInAddForm(fieldName));
        // }
    }

    @Test
    public void isDefaultFieldsVisibleInColumnSettings() {
        homePage.switchToContact();
        contact.switchToColumnSettings();
        Assert.assertTrue(contact.isDefaultFieldsVisibleInListColumnSettings());
    }

   // @Test(dataProvider = "SystemField")
    public void isVisibleInColumnSettings(final String fieldName) {
   //     ContactDataField fieldToBeChecked = null;
//        contact.addSystemField(ContactDataField.CREATED_BY);
//        Assert.assertTrue(contact.checkIfGivenFieldIsInList(ContactDataField.CREATED_BY.getName()));
//        homePage.switchToContact();
//        contact.switchToColumnSettings();
//        Assert.assertTrue(contact.isVisibleInColumnSettings(ContactDataField.CREATED_BY.getName()));

     //   final TestCase testCase = (TestCase) object;
       // final JsonObject input = testCase.input;

       // if (input.containsKey("fieldToBeChecked")) {
//            fieldToBeChecked = ContactDataField.valueOf(input.getString("fieldToBeChecked"));
//            contact.addSystemField(fieldToBeChecked);
//        }
       // Assert.assertTrue(contact.checkIfGivenFieldIsInList(fieldName));
        homePage.switchToContact();
        contact.switchToColumnSettings();
        Assert.assertTrue(contact.isVisibleInColumnSettings(fieldName));

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
        contact.check(fieldStatus);
        isVisibleInSummary(fieldStatus.getName());
        isVisibleInColumnSettings(fieldStatus.getName());

        if (fieldStatus.isAddView()) {
            isVisibleInAddForm(fieldStatus.getName());
        }

    }
}
