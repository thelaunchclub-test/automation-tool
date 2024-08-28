package com.twozo.test.settings.data.fields;

import com.twozo.commons.cookie.BrowserCookie;
import com.twozo.commons.json.JsonObject;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.product.Product;
import com.twozo.page.settings.data.fields.FieldStatus;
import com.twozo.page.settings.data.fields.product.ProductDataField;
import com.twozo.test.TestCase;
import com.twozo.web.driver.service.WebAutomationDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductDataFieldTest extends DataFieldTest {

    ProductDataField productDataField;
    HomePage homePage;
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
        automationDriver.getWebNavigator().to("https://app.thelaunchclub.in/settings/datafields?type=Product");
        automationDriver.getWebWindowHandler().maximize();

        homePage = HomePage.getInstance();
        productDataField = ProductDataField.getInstance();

    }

    @AfterMethod
    public void after() {
        automationDriver.close();
    }

    @Test
    public void verifyDefaultSystemFields() {
        Assert.assertTrue(productDataField.verifyDefaultSystemFields());
    }

    @Test(dataProvider = "maxLimit")
    public void checkMaxLimit(final Object object) {
       addCustomFieldsWithAllFieldType(object);
    }

    @Test(dataProvider = "productSystemFields")
    public void addSystemFields(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(productDataField.addSystemField(fieldStatus));
    }

    @Test(dataProvider = "customField")
    public void addCustomFieldsWithAllFieldType(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;

        if (input.containsKey("fieldName") && input.containsKey("fieldType")) {
            Assert.assertTrue(productDataField.addCustomField(input.getString("fieldName"),
                    input.getString("fieldType")));
        }
    }

    @Test(dataProvider = "editData")
    public void editFieldName(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");
        final String append = input.getString("append");

        Assert.assertTrue(productDataField.editCustomField(name, append));
    }

    @Test(dataProvider = "hideField")
    public void hideField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        Assert.assertTrue(productDataField.hideField(name));
    }

    @Test(dataProvider = "deleteField")
    public void deleteField(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final String name = input.getString("name");

        productDataField.deleteField(name);
        Assert.assertFalse(isVisibleInSummary(name));
    }

    @Test(dataProvider = "productSystemFields")
    public void enableAddView(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(productDataField.enableAddView(fieldStatus));
    }

    @Test(dataProvider = "productSystemFields")
    public void enableRequired(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setFieldType(input.getString("fieldType"));
        Assert.assertTrue(productDataField.enableRequired(fieldStatus));
    }

    @Test(dataProvider = "productSystemFields")
    public void checkAddForm(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        fieldStatus.setAddView(input.getBoolean("isAddView"));
        productDataField.addSystemField(fieldStatus);
        productDataField.checkAddView(fieldStatus);
        final String name = fieldStatus.getName();

        if (fieldStatus.isAddView()) {
            Assert.assertTrue(isVisibleInAddForm(name));
        } else {
            Assert.assertFalse(isVisibleInAddForm(name));
        }
    }

    @Test(dataProvider = "productSystemFields")
    public void checkColumnSettings(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        productDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInColumnSettings(name));
    }

    @Test(dataProvider = "productSystemFields")
    public void checkSummary(final Object object) {
        final TestCase testCase = (TestCase) object;
        final JsonObject input = testCase.input;
        final FieldStatus fieldStatus = new FieldStatus();

        fieldStatus.setName(input.getString("name"));
        productDataField.addSystemField(fieldStatus);
        final String name = fieldStatus.getName();

        Assert.assertTrue(isVisibleInSummary(name));
    }

    @Override
    public boolean isVisibleInSummary(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/products");
        productDataField.switchToSummary();

        return productDataField.isVisibleInSummary(fieldName);
    }

    @Override
    public void isDefaultFieldsVisibleInAddView() {
        webNavigator.to("https://app.thelaunchclub.in/products");
        productDataField.switchToAddProductForm();
        Assert.assertTrue(productDataField.isDefaultFieldsVisibleInAddView());
    }

    @Override
    public boolean isVisibleInAddForm(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/products");
        productDataField.switchToAddProductForm();

        return productDataField.isVisibleInAddForm(fieldName);
    }

    @Override
    public boolean isVisibleInAddFormAsRequired(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/products");
        productDataField.switchToAddProductForm();

        return productDataField.isVisibleInAddFormAsRequired(fieldName);
    }

    @Override
    public boolean isVisibleInColumnSettings(final String fieldName) {
        webNavigator.to("https://app.thelaunchclub.in/products");
        Product.getInstance().switchToColumnSettings();

        return productDataField.isVisibleInColumnSettings(fieldName);
    }
}
