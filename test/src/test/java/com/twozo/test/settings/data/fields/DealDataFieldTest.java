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
    public void verifyBreadCrumb() {
        Assert.assertTrue(dealDataField.verifyBreadCrumb());
    }

    @Test
    public void verifySelectedTabIsActive() {
        Assert.assertTrue(dealDataField.verifyActiveDealTab());
    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(dealDataField.verifyDefaultSystemFields());
    }

    @Test
    public void verifyNavigateBackAndForthBetweenDifferentModule() {
        Assert.assertTrue(dealDataField.switchBetweenTabs());
    }

    @Test(dataProvider = "SearchData")
    public void verifySearchBarsResult(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("searchData")) {
            Assert.assertTrue(dealDataField.verifySearchResult(input.getString("searchData")));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeAdded")) {
            Assert.assertTrue(dealDataField.addSystemField(DealField.valueOf(input.getString("fieldNameToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void removeSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(dealDataField.removeSystemField(DealField.valueOf(input.
                    getString("fieldNameToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void addAndRemoveSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldNameToBeRemoved")) {
            Assert.assertTrue(dealDataField.addAndRemoveSystemField(DealField.valueOf(input.getString
                    ("fieldToBeAdded")), DealField.valueOf(input.getString("fieldToBeRemoved"))));
        }
    }

    @Test
    public void verifyNonDraggableFields() {
        Assert.assertTrue(dealDataField.verifyNonDraggableFields());
    }

    @Test
    public void verifyEyeIconIsNotVisibleForDefaultFields() {
        Assert.assertTrue(dealDataField.verifyEyeIconIsNotVisibleForDefaultFields());
    }

    @Test
    public void isAddViewCheckBoxEditableForMandatoryField() {
        Assert.assertTrue(dealDataField.isAddViewCheckBoxEditableForMandatoryField());
    }

    @Test
    public void uncheckMandatoryFields() {
        Assert.assertTrue(dealDataField.uncheckMandatoryFields());
    }

    @Test(dataProvider = "SystemField")
    public void addAutoGeneratingSystemField(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(dealDataField.addSystemField(DealField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyAutoGeneratingSystemFieldNotEditable(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeAdded")) {
            Assert.assertTrue(dealDataField.verifyAutoGeneratingSystemFieldNotEditable(DealField.valueOf(input.
                    getString("autoGeneratingFieldToBeAdded"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void hideAutoGeneratingSystemField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("autoGeneratingFieldToBeRemoved")) {
            Assert.assertTrue(dealDataField.hideAutoGeneratingSystemField(DealField.valueOf(input.
                    getString("autoGeneratingFieldToBeRemoved"))));
        }
    }

    @Test(dataProvider = "SystemField")
    public void verifyEyeIcon(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("eyeIconFor")) {
            Assert.assertTrue(dealDataField.verifyEyeIcon(DealField.valueOf(input.
                    getString("eyeIconFor"))));
        }
    }

    @Test
    public void verifyAllSystemFieldsType() {
        dealDataField.addAllSystemFields();
        dealDataField.checkSystemFieldsFieldType();
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
            Assert.assertTrue(dealDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "SystemField")
    public void isDefaultFieldsVisibleInSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        homePage.switchToDeal();
        dealDataField.switchToSummary();

        if (input.containsKey("fieldToBeChecked")) {
            Assert.assertTrue(dealDataField.isDefaultFieldsVisibleInSummary());
        }
    }

    @Test
    public void isDefaultFieldsVisibleInColumnSettings() {
        homePage.switchToDeal().switchToColumnSettings();
        Assert.assertTrue(dealDataField.isDefaultFieldsVisibleInListColumnSettings());
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

        dealDataField.checkIfDisplayed(fieldStatus);
        isVisibleInSummary(fieldStatus.getName());
        isVisibleInColumnSettings(fieldStatus.getName());

        if (fieldStatus.isAddView()) {
            isVisibleInAddForm(fieldStatus.getName());
        }

    }
}
