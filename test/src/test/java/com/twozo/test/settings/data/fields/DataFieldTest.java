package com.twozo.test.settings.data.fields;

import com.twozo.test.TestDataProvider;
import com.twozo.test.settings.SettingsTest;

import org.openqa.selenium.devtools.v122.preload.model.PrerenderFinalStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @DataProvider(name = "addView")
    public static Object[][] getAddViewData() {
        return new TestDataProvider().getTestCases("AddView.json");
    }

    @DataProvider(name = "data")
    public static Object[][] getData() {
        return new TestDataProvider().getTestCases("Data.json");
    }

    @DataProvider(name = "editData")
    public static Object[][] getEditData() {
        return new TestDataProvider().getTestCases("EditFieldName.json");
    }

    public void isVisibleInSummary(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToSummary();
        Assert.assertTrue(contactDataField.isVisibleInSummary(fieldName));
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

    public void isVisibleInColumnSettings(final String fieldName) {
        homePage.switchToContact().switchToColumnSettings();
        homePage.switchToContact();
        Assert.assertTrue(contactDataField.isVisibleInColumnSettings(fieldName));
    }
}
