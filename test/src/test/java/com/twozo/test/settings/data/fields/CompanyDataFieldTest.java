package com.twozo.test.settings.data.fields;

import com.twozo.commons.json.JsonObject;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.company.field.CompanyField;
import com.twozo.test.TestCase;
import com.twozo.test.TestDataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompanyDataFieldTest extends DataFieldTest {


    @Test
    public void verifyBreadCrumb() {
        Assert.assertTrue(companyDataField.verifyBreadCrumb());
    }

    @Test
    public void verifySelectedTabIsActive() {
        Assert.assertTrue(companyDataField.verifyActiveCompanyTab());
    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(companyDataField.verifyDefaultSystemFields());
    }

    @Test
    public void verifyNavigateBackAndForthBetweenDifferentModule() {
        Assert.assertTrue(companyDataField.switchBetweenTabs());
    }

    @Test(dataProvider = "SearchData")
    public void verifySearchBarsResult(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("searchData")) {
            Assert.assertTrue(companyDataField.verifySearchResult(input.getString("searchData")));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeAdded")) {
            Assert.assertTrue(companyDataField.addSystemField(CompanyField.valueOf(input.getString("fieldNameToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void removeSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(companyDataField.removeSystemField(CompanyField.valueOf(input.
                    getString("fieldNameToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addAndRemoveSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(companyDataField.addAndRemoveSystemField(CompanyField.valueOf(input.getString
                    ("fieldToBeAdded")), CompanyField.valueOf(input.getString("fieldToBeRemoved"))));
        }
    }

    @Test
    public void verifyNonDraggableFields() {
        Assert.assertTrue(companyDataField.verifyNonDraggableFields());
    }

    @Test
    public void verifyEyeIconIsNotVisibleForDefaultFields() {
        Assert.assertTrue(companyDataField.verifyEyeIconIsNotVisibleForDefaultFields());
    }

    @Test
    public void isAddViewCheckBoxEditableForMandatoryField() {
        Assert.assertTrue(companyDataField.isAddViewCheckBoxEditableForMandatoryField());
    }

    @Test
    public void uncheckMandatoryFields() {
        Assert.assertTrue(companyDataField.uncheckMandatoryFields());
    }

    @Test(dataProvider = "SystemField")
    public void addAutoGeneratingSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(companyDataField.addSystemField(CompanyField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyAutoGeneratingSystemFieldNotEditable(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(companyDataField.verifyAutoGeneratingSystemFieldNotEditable(CompanyField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void hideAutoGeneratingSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeRemoved")) {
            Assert.assertTrue(companyDataField.hideAutoGeneratingSystemField(CompanyField.valueOf(input.
                    getString("autoGeneratingFieldToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyEyeIcon(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("eyeIconFor")) {
            Assert.assertTrue(companyDataField.verifyEyeIcon(CompanyField.valueOf(input.
                    getString("eyeIconFor"))));
        }
    }

    @Test
    public void verifyAllSystemFieldsType() {
        companyDataField.addAllSystemFields();
        companyDataField.checkSystemFieldsFieldType();
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
            Assert.assertTrue(companyDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "SystemField")
    public void isDefaultFieldsVisibleInSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        homePage.switchToCompany();
        companyDataField.switchToSummary();

        if (input.containsKey("fieldToBeChecked")) {
            Assert.assertTrue(companyDataField.isDefaultFieldsVisibleInSummary());
        }
    }

    @Test
    public void isDefaultFieldsVisibleInColumnSettings() {
        homePage.switchToCompany().switchToColumnSettings();
        Assert.assertTrue(companyDataField.isDefaultFieldsVisibleInListColumnSettings());
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

        companyDataField.checkIfDisplayed(fieldStatus);
        isVisibleInSummary(fieldStatus.getName());
        isVisibleInColumnSettings(fieldStatus.getName());

        if (fieldStatus.isAddView()) {
            isVisibleInAddForm(fieldStatus.getName());
        }
    }

    @Test
    public void dragAndDrop() {
        contactDataField.dragAndDropByXpath("Designation");
    }
}
