package com.twozo.test.settings.data.fields;

import com.twozo.commons.cookie.HttpCookie;
import com.twozo.commons.json.JsonObject;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.contact.ContactDataField;
import com.twozo.test.TestCase;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactDataFieldTest extends DataFieldTest {

    private ContactDataField contactDataField;
    private HomePage homePage;
    private WebAutomationDriver automationDriver;

    @BeforeMethod
    public void before() {
        automationDriver = WebAutomationDriver.get();
        automationDriver.getWebNavigator().to("https://app.thelaunchclub.in/");

        for (final HttpCookie cookie : cookies) {
            automationDriver.getSessionCookie().addCookie(cookie);
        }

        automationDriver.getWebWindowHandler().maximize();
        automationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
        automationDriver.getWebNavigator().to("https://app.thelaunchclub.in/settings/datafields?type=Contact");
        automationDriver.getWebWindowHandler().maximize();

        homePage = HomePage.getInstance(automationDriver);
        contactDataField = ContactDataField.getInstance(automationDriver);
    }
//
//    @AfterMethod
//    public void after() {
//        automationDriver.close();
//    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(contactDataField.verifyDefaultSystemFields());
    }

    @Test(dataProvider = "maxLimit")
    public void checkMaxLimit(final Object object){
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(contactDataField.addCustomField(input.getString("fieldName"),
                    input.getString("fieldType")));
        }
    }


    @Test(dataProvider = "contactSystemFields")
    public void addSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(contactDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            contactDataField.addCustomField(input.getString("fieldName"),
                    input.getString("fieldType"));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("fieldName");
        final String append = input.getString("append");

        Assert.assertTrue(contactDataField.editCustomField(name, append));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertTrue(contactDataField.hideField(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertTrue(contactDataField.deleteField(name));
    }

    @Test(dataProvider = "contactSystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(contactDataField.enableAddView(fieldStatus));
    }

    @Test(dataProvider = "contactSystemFields")
    public void enableRequired(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(contactDataField.enableRequired(fieldStatus));
    }

    @Test(dataProvider = "contactSystemFields")
    public void checkAddForm(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setAddView(input.getBoolean("isAddView"));
        contactDataField.addSystemField(fieldStatus);
        contactDataField.checkAddView(fieldStatus);
        final String name = fieldStatus.getName();

        if (fieldStatus.isAddView()) {
            Assert.assertTrue(isVisibleInAddForm(name));
        } else {
            Assert.assertFalse(isVisibleInAddForm(name));
        }
    }

    @Test(dataProvider = "contactSystemFields")
    public void checkColumnSettings(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        contactDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInColumnSettings(name));
    }

    @Test(dataProvider = "contactSystemFields")
    public void checkSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        contactDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInSummary(name));
    }

    @Test
    public void checkSubscriptionStatus() {
        contactDataField.checkSubscriptionStatus();
    }

    @Test
    public void checkLifecycleStage() {
        contactDataField.checkLifecycleStage();
    }

    @Test
    public void checkTimeZone() {
        contactDataField.checkTimezone();
    }

    @Override
    public boolean isVisibleInSummary(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToSummary();
        return contactDataField.isVisibleInSummary(fieldName);
    }

    @Override
    public void isDefaultFieldsVisibleInAddView() {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        Assert.assertTrue(contactDataField.isDefaultFieldsVisibleInAddView());
    }

    @Override
    public boolean isVisibleInAddForm(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        return contactDataField.isVisibleInAddForm(fieldName);
    }

    @Override
    public boolean isVisibleInAddFormAsRequired(final String fieldName) {
        homePage.switchToContact();
        contactDataField.switchToAddContactForm();
        return contactDataField.isVisibleInAddFormAsRequired(fieldName);
    }

    @Override
    public boolean isVisibleInColumnSettings(final String fieldName) {
        homePage.switchToContact().switchToColumnSettings();
        homePage.switchToContact();
        return contactDataField.isVisibleInColumnSettings(fieldName);
    }
}
