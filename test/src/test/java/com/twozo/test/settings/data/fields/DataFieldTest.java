package com.twozo.test.settings.data.fields;

import com.twozo.test.TestDataProvider;
import com.twozo.test.settings.SettingsTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class DataFieldTest extends SettingsTest {

    @DataProvider(name = "searchData")
    public static Object[][] getSearchData() {
        return new TestDataProvider().getTestCases("SearchData.json");
    }

    @DataProvider(name = "SystemField")
    public static Object[][] getSystemField() {
        return new TestDataProvider().getTestCases("SystemField.json");
    }

//    @DataProvider(name = "testCase")
//    public static Object[][] getData() {
//        return new TestDataProvider().getTestCases("TestCase.json");
//    }

    @DataProvider(name = "contactSystemFields")
    public static Object[][] getContactSystemFieldData() {
        return new TestDataProvider().getTestCases("ContactSystemFields.json");
    }

    @DataProvider(name = "companySystemFields")
    public static Object[][] getCompanySystemFieldData() {
        return new TestDataProvider().getTestCases("CompanySystemFields.json");
    }

    @DataProvider(name = "dealSystemFields")
    public static Object[][] getDealSystemFieldData() {
        return new TestDataProvider().getTestCases("DealSystemFields.json");
    }

    @DataProvider(name = "productSystemFields")
    public static Object[][] getProductSystemFieldData() {
        return new TestDataProvider().getTestCases("ProductSystemFields.json");
    }

    @DataProvider(name = "data")
    public static Object[][] getData() {
        return new TestDataProvider().getTestCases("Data.json");
    }

    @DataProvider(name = "editData")
    public static Object[][] getEditData() {
        return new TestDataProvider().getTestCases("EditFieldName.json");
    }

    @DataProvider(name = "hideField")
    public static Object[][] getHideFieldData() {
        return new TestDataProvider().getTestCases("HideField.json");
    }

    @DataProvider(name = "deleteField")
    public static Object[][] getDeleteFieldData() {
        return new TestDataProvider().getTestCases("DeleteField.json");
    }

    public boolean isVisibleInSummary(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToSummary();
        return contactDataField.isVisibleInSummary(fieldName);
    }

    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInAddView());
    }

    public boolean isVisibleInAddForm(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        return contactDataField.isVisibleInAddForm(fieldName);
    }

    public boolean isVisibleInAddFormAsRequired(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        return contactDataField.isVisibleInAddFormAsRequired(fieldName);
    }

    public boolean isVisibleInColumnSettings(final String fieldName) {
        homePage.switchToContact().switchToColumnSettings();
        homePage.switchToContact();
        return contactDataField.isVisibleInColumnSettings(fieldName);
    }
}
