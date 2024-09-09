package com.twozo.test.currency;

import com.twozo.page.JsonFields;
import com.twozo.page.currency.DecimalOption;
import com.twozo.page.currency.TestCase;
import com.twozo.test.BaseTest;
import com.twozo.test.MyFunctionTest;
import com.twozo.web.driver.service.WebAutomationDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Contains test cases for validating various aspects of currency management within the application.
 * <p>
 * Utilizes data-driven testing by providing multiple DataProviders for different currency-related test scenarios.
 * Each test case verifies specific functionality related to currency management and interacts with the currency object
 * to perform actions and assert expected outcomes.
 * </p>
 *
 * @author Navin Jones
 * @version 1.0
 * @see BaseTest
 */
public class CurrencyTest extends BaseTest {

    public WebAutomationDriver webAutomationDriver;

    /**
     * Provides test data for base currency verification.
     *
     * @return A 2D array of {@link TestCase} containing data for base currency tests.
     */
    @DataProvider(name = "currency")
    public static TestCase[][] checkBase() {
        return new MyFunctionTest().getTestCases(JsonFields.BASE_CURRENCY);
    }

    /**
     * Provides test data for decimal value verification.
     *
     * @return A 2D array of {@link TestCase} containing data for decimal value tests.
     */
    @DataProvider(name = "decimal")
    public static TestCase[][] checkDecimal() {
        return new MyFunctionTest().getTestCases(JsonFields.DECIMAL);
    }

    /**
     * Provides test data for adding new currencies.
     *
     * @return A 2D array of {@link TestCase} containing data for adding currencies.
     */
    @DataProvider(name = "addCurrency")
    public static TestCase[][] CheckCurrency() {
        return new MyFunctionTest().getTestCases(JsonFields.ADD_CURRENCY);
    }

    /**
     * Provides test data for adding currencies and verifying their presence.
     *
     * @return A 2D array of {@link TestCase} containing data for adding and verifying currencies.
     */
    @DataProvider(name = "addCurrencyAndVerify")
    public static TestCase[][] addCurrencyAndVerify() {
        return new MyFunctionTest().getTestCases(JsonFields.ADD_CURRENCY_VERIFY);
    }

    /**
     * Provides test data for adding currencies and checking their properties.
     *
     * @return A 2D array of {@link TestCase} containing data for adding and checking currencies.
     */
    @DataProvider(name = "addCurrencyAndCheck")
    public static TestCase[][] addCurrencyAndCheck() {
        return new MyFunctionTest().getTestCases(JsonFields.ADD_CURRENCY_CHECK);
    }

    /**
     * Provides test data for disabling currencies.
     *
     * @return A 2D array of {@link TestCase} containing data for disabling currencies.
     */
    @DataProvider(name = "disableCurrency")
    public static TestCase[][] disableCurrency() {
        return new MyFunctionTest().getTestCases(JsonFields.DISABLE_CURRENCY);
    }

    /**
     * Verifies that the base currency is set to USD by default.
     * Ensures that the default base currency is correctly configured in the application.
     */
    @Test
    public void checkBaseCurrency() {
        Assert.assertTrue(currency.isBaseCurrencyUSD(), "Base currency should be USD by default.");
    }

    /**
     * Verifies that the base decimal value is set to 2 by default.
     * Checks the default decimal precision setting for the base currency.
     */
    @Test(priority = 1)
    public void checkBaseDecimal() {
        Assert.assertTrue(currency.isBaseDecimal(), "Base decimal value should be 2 by default.");
    }

    /**
     * Adds a base currency and verifies that it has been correctly set.
     * Uses the data from the {@code checkBase} DataProvider to add a base currency and checks
     * if the value is set correctly.
     *
     * @param testCase The {@link TestCase} containing test data for adding the base currency.
     */
    @Test(dataProvider = "currency", priority = 2)
    public void addBaseCurrency(final TestCase testCase) {
        if (testCase.input.containsKey("currency")) {
            testCase.input.getString("currency"); // Extract currency if needed
        }
        currency.baseCurrency(testCase);
        Assert.assertTrue(currency.checkTheBaseCurrencyValue(testCase),
                "The base currency value was not set correctly.");
    }

    /**
     * Verifies that the base currency is searchable after it has been added.
     * Checks the functionality of searching for the base currency in the application.
     */
    @Test(priority = 3)
    public void AddBaseCurrencyInSearch() {
        Assert.assertTrue(currency.searchBase(), "Base currency should be searchable.");
    }

    /**
     * Verifies that a popup is visible after clicking the "Add Currency" button.
     * Ensures that the user interface correctly displays a popup for adding new currencies.
     */
    @Test(priority = 4)
    public void hasPopUpVisibleToAddCurrency() {
        Assert.assertTrue(currency.isPopUpVisible(), "Popup should be visible to add currency.");
    }

    /**
     * Adds a decimal value and verifies the change.
     * This test uses the data from the "decimal" DataProvider to set and check the decimal value.
     *
     * @param testCase The {@link TestCase} object containing test data for setting the decimal value.
     */
    @Test(dataProvider = "decimal", priority = 5)
    public void addDecimal(final TestCase testCase) {
        if (testCase.input.containsKey("decimal")) {
            final DecimalOption decimalOption = DecimalOption.fromValue(testCase.input.getInt("decimal"));

            currency.getDecimal(testCase);
            Assert.assertTrue(currency.checkTheDecimalValue(testCase),
                    "The decimal value was not changed as expected. Expected: " + decimalOption);
        }
    }

    /**
     * Adds a new currency and verifies it is added successfully.
     * This test uses the data from the "addCurrency" DataProvider to add a new currency and checks
     * if it was successfully added.
     *
     * @param testCase The {@link TestCase} containing test data for adding the new currency.
     */
    @Test(dataProvider = "addCurrency", priority = 6)
    public void addCurrency(final TestCase testCase) {
        if (testCase.input.containsKey("currency")) {
            testCase.input.getString("currency"); // Extract currency if needed
        }
        currency.addCurrency(testCase);
        Assert.assertTrue(currency.isAddCurrency(), "Currency was not added successfully.");
    }

    /**
     * Verifies that the base currency button is enabled after adding a new currency.
     * Ensures that the button used to manage base currency remains enabled as expected.
     */
    @Test(priority = 7)
    public void baseCurrencyButtonStatusAfterAddingCurrency() {
        Assert.assertTrue(currency.isEnabled(), "Base currency button should be enabled after adding a currency.");
    }

    /**
     * Disables a currency and verifies that it has been disabled.
     * Uses the data from the "disableCurrency" DataProvider to disable a currency and checks
     * if the currency is correctly marked as disabled.
     *
     * @param testCase The {@link TestCase} containing test data for disabling the currency.
     */
    @Test(dataProvider = "disableCurrency", priority = 8)
    public void disAbleCurrency(final TestCase testCase) {
        if (testCase.input.containsKey("makeItDisable")) {
            testCase.input.optBoolean("makeItDisable", false); // Extract disable flag if needed
        }

        currency.isDisabledCurrencySwitch(testCase);
        Assert.assertTrue(currency.isDisableCurrency(), "Currency should be disabled as expected.");
    }

    /**
     * Enables a previously disabled currency and verifies that it has been enabled.
     * Uses the data from the "disableCurrency" DataProvider to enable a currency and checks
     * if the currency is correctly marked as enabled.
     *
     * @param testCase The {@link TestCase} object containing test data for enabling the currency.
     */
    @Test(dataProvider = "disableCurrency", priority = 9)
    public void enableCurrency(final TestCase testCase) {
        if (testCase.input.containsKey("makeItEnable")) {
            testCase.input.optBoolean("makeItEnable", false); // Extract enable flag if needed
        }

        currency.isEnabledCurrency(testCase);
        Assert.assertTrue(currency.isEnableCurrency(), "Currency should be enabled as expected.");
    }

    /**
     * Adds a currency and verifies that it is no longer available in the Add Currency form.
     * Uses the data from the "addCurrencyAndVerify" DataProvider to add a currency and checks
     * if it correctly disappears from the Add Currency form.
     *
     * @param testCase The {@link TestCase} containing test data for adding and verifying the currency.
     */
    @Test(dataProvider = "addCurrencyAndVerify", priority = 10)
    public void addCurrencyAndVerify(final TestCase testCase) {
        final String currencyToAdd = testCase.input.getString("currency");
        currency.addCurrency(testCase);

        Assert.assertFalse(currency.isCurrencyAvailableInAddForm(currencyToAdd),
                "Currency should not be available in the Add Currency form after adding it.");
    }

    /**
     * Tests if a newly added currency appears in the dropdown list.
     * Uses the data from the "addCurrencyAndCheck" DataProvider to add a currency and checks
     * if it appears in the dropdown list for currency selection.
     *
     * @param testCase The {@link TestCase} object containing test data for adding and checking the currency.
     */
    @Test(dataProvider = "addCurrencyAndCheck", priority = 11)
    public void testCurrencySelection(final TestCase testCase) {
        final String currencyToCheck = testCase.input.getString("currency");

        currency.addCurrency(testCase);
        final boolean isPresent = currency.isCurrencyPresentInDropdown(currencyToCheck);
        Assert.assertTrue(isPresent, "The currency " + currencyToCheck + " should be present in the dropdown.");
    }

    /**
     * Verifies that the newly added currency can be searched.
     * Checks if the search functionality for newly added currencies works as expected.
     */
    @Test(priority = 12)
    public void searchAddCurrency() {
        Assert.assertTrue(currency.searchAddCurrency(), "The added currency should be searchable.");
    }
}