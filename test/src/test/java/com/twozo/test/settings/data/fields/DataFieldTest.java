package com.twozo.test.settings.data.fields;

import com.twozo.test.TestDataProvider;
import com.twozo.test.settings.SettingsTest;

import com.twozo.web.driver.service.WebNavigator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public abstract class DataFieldTest extends SettingsTest {
    WebNavigator webNavigator;

    @DataProvider(name = "searchData")
    public static Object[][] getSearchData() {
        return new TestDataProvider().getTestCases("SearchData.json");
    }

    @DataProvider(name = "customField")
    public static Object[][] getCustomField() {
        return new TestDataProvider().getTestCases("CustomField.json");
    }

    @DataProvider(name = "SystemField")
    public static Object[][] getSystemField() {
        return new TestDataProvider().getTestCases("SystemField.json");
    }

    @DataProvider(name = "maxLimit")
    public static Object[][] getDataForMaxLimit() {
        return new TestDataProvider().getTestCases("MaxLimit.json");
    }

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

    public abstract boolean isVisibleInSummary(final String fieldName);

    public abstract void isDefaultFieldsVisibleInAddView();

    public abstract boolean isVisibleInAddForm(final String fieldName);

    public abstract boolean isVisibleInAddFormAsRequired(final String fieldName);

    public abstract boolean isVisibleInColumnSettings(final String fieldName);
}
