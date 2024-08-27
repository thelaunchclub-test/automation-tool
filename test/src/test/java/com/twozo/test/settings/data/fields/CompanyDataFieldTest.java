package com.twozo.test.settings.data.fields;

import com.twozo.commons.cookie.HttpCookie;
import com.twozo.commons.json.JsonObject;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.company.CompanyDataField;
import com.twozo.test.TestCase;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CompanyDataFieldTest extends DataFieldTest {

    private CompanyDataField companyDataField;
    private HomePage homePage;
    private WebAutomationDriver automationDriver;

    @BeforeMethod
    public void before() {
        automationDriver = WebAutomationDriver.get();
        automationDriver.getWebNavigator().to("https://app.thelaunchclub.in");

        for (final HttpCookie cookie : cookies) {
            automationDriver.getSessionCookie().addCookie(cookie);
        }

        automationDriver.getWebWindowHandler().maximize();
        automationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
        automationDriver.getWebNavigator().to("https://app.thelaunchclub.in/settings/datafields?type=Company");
        automationDriver.getWebWindowHandler().maximize();

        homePage = HomePage.getInstance(automationDriver);
        companyDataField = CompanyDataField.getInstance(automationDriver);
    }

    @AfterMethod
    public void after() {
        automationDriver.close();
    }

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

    @Test(dataProvider = "maxLimit")
    public void checkMaxLimit(final Object object){
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(companyDataField.addCustomField(input.getString("fieldName"),
                    input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(companyDataField.addCustomField(input.getString("fieldName"),
                    input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        final String append = input.getString("append");

        Assert.assertTrue(companyDataField.editCustomField(name, append));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertFalse(companyDataField.hideField(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertTrue(companyDataField.deleteField(name));
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


    @Test(dataProvider = "companySystemFields")
    public void enableRequired(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(companyDataField.enableRequired(fieldStatus));
    }

    @Test(dataProvider = "companySystemFields")
    public void checkAddForm(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setAddView(input.getBoolean("isAddView"));
        companyDataField.addSystemField(fieldStatus);
        companyDataField.checkAddView(fieldStatus);
        final String name = fieldStatus.getName();

        if (fieldStatus.isAddView()) {
            Assert.assertTrue(isVisibleInAddForm(name));
        } else {
            Assert.assertFalse(isVisibleInAddForm(name));
        }
    }

    @Test(dataProvider = "companySystemFields")
    public void checkColumnSettings(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        companyDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInColumnSettings(name));
    }

    @Test(dataProvider = "companySystemFields")
    public void checkSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        companyDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInSummary(name));
    }

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
    public boolean isVisibleInSummary(final String fieldName) {
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
    public boolean isVisibleInAddForm(final String fieldName) {
        homePage.switchToCompany();
        companyDataField.switchToAddCompanyForm();
        return companyDataField.isVisibleInAddForm(fieldName);
    }

    @Override
    public boolean isVisibleInAddFormAsRequired(final String fieldName) {
        homePage.switchToCompany();
        companyDataField.switchToAddCompanyForm();
        return companyDataField.isVisibleInAddFormAsRequired(fieldName);
    }

    @Override
    public boolean isVisibleInColumnSettings(final String fieldName) {
        homePage.switchToCompany().switchToColumnSettings();
        homePage.switchToCompany();
        return companyDataField.isVisibleInColumnSettings(fieldName);
    }
}
