package com.twozo.test.settings.data.fields;

import com.twozo.commons.cookie.BrowserCookie;
import com.twozo.commons.json.JsonObject;
import com.twozo.page.deal.Deal;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.deal.DealDataField;
import com.twozo.test.TestCase;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DealDataFieldTest extends DataFieldTest {

    private DealDataField dealDataField;
    private HomePage homePage;

    private WebAutomationDriver automationDriver;

    @BeforeMethod
    public void before() {
        automationDriver = WebAutomationDriver.get();
        webNavigator = automationDriver.getWebNavigator();
        webNavigator.to("https://app.thelaunchclub.in");

        for (final BrowserCookie cookie : cookies) {
            automationDriver.getSessionCookie().addCookie(cookie);
        }

        automationDriver.getWebWindowHandler().maximize();
        automationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
        automationDriver.getWebNavigator().to("https://app.thelaunchclub.in/settings/datafields?type=Deal");
        automationDriver.getWebWindowHandler().maximize();

        homePage = HomePage.getInstance();
        dealDataField = DealDataField.getInstance();
    }

    @AfterMethod
    public void after() {
        automationDriver.close();
    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(dealDataField.verifyDefaultSystemFields());
    }

    @Test(dataProvider = "dealSystemFields")
    public void addSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(dealDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {

        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(dealDataField.addCustomField(input.getString("fieldName"),
                    input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        final String append = input.getString("append");

        Assert.assertTrue(dealDataField.editCustomField(name, append));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertTrue(dealDataField.hideField(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertTrue(dealDataField.deleteField(name));
    }

    @Test(dataProvider = "dealSystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(dealDataField.enableAddView(fieldStatus));
    }

    @Test(dataProvider = "dealSystemFields")
    public void enableRequired(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(dealDataField.enableRequired(fieldStatus));
    }


    @Test(dataProvider = "dealSystemFields")
    public void checkAddForm(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setAddView(input.getBoolean("isAddView"));
        dealDataField.addSystemField(fieldStatus);
        dealDataField.checkAddView(fieldStatus);
        final String name = fieldStatus.getName();

        if (fieldStatus.isAddView()) {
            Assert.assertTrue(isVisibleInAddForm(name));
        } else {
            Assert.assertFalse(isVisibleInAddForm(name));
        }
    }

    @Test(dataProvider = "dealSystemFields")
    public void checkColumnSettings(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        dealDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInColumnSettings(name));
    }

    @Test(dataProvider = "dealSystemFields")
    public void checkSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        dealDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInSummary(name));
    }

    @Test
    public void checkPipeline() {
        dealDataField.checkPipeline();
    }

    @Override
    public boolean isVisibleInSummary(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/deals");
        dealDataField.switchToSummary();
        return dealDataField.isVisibleInSummary(fieldName);
    }

    @Override
    public void isDefaultFieldsVisibleInAddView() {
        webNavigator.to("https://app.thelaunchclub.in/deals");
        dealDataField.switchToAddDealForm();
        Assert.assertTrue(dealDataField.isDefaultFieldsVisibleInAddView());
    }

    @Override
    public boolean isVisibleInAddForm(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/deals");
        dealDataField.switchToAddDealForm();
        return dealDataField.isVisibleInAddForm(fieldName);
    }

    @Override
    public boolean isVisibleInAddFormAsRequired(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/deals");
        dealDataField.switchToAddDealForm();

        return dealDataField.isVisibleInAddFormAsRequired(fieldName);
    }

    @Override
    public boolean isVisibleInColumnSettings(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/deals");
        Deal.getInstance().switchToColumnSettings();

        return dealDataField.isVisibleInColumnSettings(fieldName);
    }
}
