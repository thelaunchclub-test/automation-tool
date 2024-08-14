package com.twozo.test.settings.data.fields;

import com.twozo.commons.exception.provider.PrefixProvider;
import com.twozo.commons.json.JsonObject;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.test.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CompanyDataFieldTest extends DataFieldTest {

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(companyDataField.verifyDefaultSystemFields());
    }
    
    @Test(dataProvider = "companySystemFields")
    public void addSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));

        Assert.assertTrue(companyDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(companyDataField.addCustomField(input.getString("fieldName"), input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        final String append = input.getString("append");
        final String newFieldName = String.format("%s%s", name, append);

        companyDataField.editCustomField(name, append);
        companyDataField.isVisibleInDataFields(newFieldName);
        Assert.assertTrue(isVisibleInSummary(newFieldName));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        companyDataField.hideField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        companyDataField.deleteField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }


    @Test(dataProvider = "companySystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));

        Assert.assertTrue(companyDataField.enableAddView(fieldStatus));
    }
//
//    @Test(dataProvider = "companySystemFields")
//    public void checkAddForm(final Object object) {
//        final TestCase testCase = (TestCase) object;
//        final JsonObject input = testCase.input;
//        final FieldStatus fieldStatus = new FieldStatus();
//
//        fieldStatus.setName(input.getString("name"));
//        fieldStatus.setAddView(input.getBoolean("isAddView"));
//        companyDataField.addSystemField(fieldStatus);
//        companyDataField.checkAddView(fieldStatus);
//        final String name = fieldStatus.getName();
//
//        if (fieldStatus.isAddView()) {
//            Assert.assertTrue(isVisibleInAddForm(name));
//        } else {
//            Assert.assertFalse(isVisibleInAddForm(name));
//        }
//    }

    @Test
    public void checkOrganizationStatus() {
        companyDataField.checkOrganizationStatus();
    }

    @Test
    public void checkIndustryType() {
        companyDataField.checkIndustryType();
    }

    @Test
    public void checkBusinessType() {
        companyDataField.checkIndustryType();
    }

    @Override
    public boolean isVisibleInSummary(String fieldName) {
        HomePage.getInstance(webAutomationDriver).switchToCompany();
        companyDataField.switchToSummary();
        return companyDataField.isVisibleInSummary(fieldName);
    }

    @Override
    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToCompany();
        companyDataField.switchToAddCompanyForm();
        Assert.assertTrue(companyDataField.isDefaultFieldsVisibleInAddView());
    }

    @Override
    public boolean isVisibleInAddForm(String fieldName) {
        homePage.switchToCompany();
        companyDataField.switchToAddCompanyForm();
        return companyDataField.isVisibleInAddForm(fieldName);    }

    @Override
    public boolean isVisibleInAddFormAsRequired(String fieldName) {
        homePage.switchToCompany();
        companyDataField.switchToAddCompanyForm();
        return companyDataField.isVisibleInAddFormAsRequired(fieldName);
    }

    @Override
    public boolean isVisibleInColumnSettings(String fieldName) {
        homePage.switchToCompany().switchToColumnSettings();
        homePage.switchToCompany();
        return companyDataField.isVisibleInColumnSettings(fieldName);
    }

    @AfterMethod
    public void goToSettings(){
        companyDataField.refresh();
        HomePage.getInstance(webAutomationDriver).switchToSettings().switchToCompanyDataFields();
    }
}
