package com.twozo.page.sign.up;

import com.twozo.commons.exception.TestException;
import com.twozo.page.BasePage;
import com.twozo.page.deal.DealPage;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverStatusCode;

import java.util.Collection;
import java.util.Objects;

public class SignUp extends BasePage {

    private static SignUp signUp;

    private WebPageElement signUpButton;
    private WebPageElement emailField;
    private WebPageElement nextButton;
    private WebPageElement signInButton;
    private WebPageElement nameField;
    private WebPageElement passwordField;
    private WebPageElement confirmPasswordField;
    private WebPageElement companyField;
    private WebPageElement createAccountButton;
    private WebPageElement jobRoleDropDown;
    private Collection<WebPageElement> jobRoles;
    private WebPageElement completeSignUpButton;

    private SignUp(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
        click(getSignUpButton());

        if (!isDisplayed(findElement(new Finder(LocatorType.XPATH, "//p[contains(text(), 'Create')]", true)))) {
            throw TestException.get(WebDriverStatusCode.EXPECTED_PAGE_NOT_FOUND);
        }
    }

    public static SignUp getInstance(final WebAutomationDriver webAutomationDriver) {
        if (Objects.isNull(signUp)) {
            signUp = new SignUp(webAutomationDriver);
        }
        return signUp;
    }

    public WebPageElement getSignUpButton() {
        if (Objects.isNull(signUpButton)) {
            signUpButton = findElement(new Finder(LocatorType.XPATH, "//*[text()='Sign Up']", true));
        }
        return signUpButton;
    }

    public WebPageElement getEmailField() {
        if (Objects.isNull(emailField)) {
            emailField = findElement(new Finder(LocatorType.NAME, "email", true));
        }
        return emailField;
    }

    public WebPageElement getNextButton() {
        if (Objects.isNull(nextButton)) {
            nextButton = findElement(new Finder(LocatorType.XPATH, "//*[text()='Next']", true));
        }
        return nextButton;
    }

    public WebPageElement getSignInButton() {
        if (Objects.isNull(signInButton)) {
            signInButton = findElement(new Finder(LocatorType.XPATH, "//*[text()='Sign In']", true));
        }
        return signInButton;
    }

    public WebPageElement getNameField() {
        if (Objects.isNull(nameField)) {
            nameField = findElement(new Finder(LocatorType.XPATH, "//*[contains(@placeholder,'name')]", true));
        }
        return nameField;
    }

    public WebPageElement getPasswordField() {
        if (Objects.isNull(passwordField)) {
            passwordField = findElement(new Finder(LocatorType.NAME, "password", true));
        }
        return passwordField;
    }

    public WebPageElement getConfirmPasswordField() {
        if (Objects.isNull(confirmPasswordField)) {
            confirmPasswordField = findElement(new Finder(LocatorType.NAME, "confirmPassword", true));
        }
        return confirmPasswordField;
    }

    public WebPageElement getCreateAccountButton() {
        if (Objects.isNull(createAccountButton)) {
            createAccountButton = findElement(new Finder(LocatorType.XPATH, "//*[text()='Create Account']", true));
        }
        return createAccountButton;
    }

    public WebPageElement getCompanyField() {
        if (Objects.isNull(companyField)) {
            companyField = findElement(new Finder(LocatorType.XPATH, "//*[contains(@placeholder,'company')]", true));
        }
        return companyField;
    }

    public WebPageElement getJobRoleDropDown() {
        if (Objects.isNull(jobRoleDropDown)) {
            jobRoleDropDown = findElement(new Finder(LocatorType.XPATH, "//*[text()='Select']", true));
        }
        return jobRoleDropDown;
    }

    public Collection<WebPageElement> getJobRoles() {
        if (Objects.isNull(jobRoles)) {
            jobRoles = findElements(new Finder(LocatorType.TAG_NAME, "li", true));
        }
        return jobRoles;
    }

    public WebPageElement getCompleteSignUpButton() {
        if (Objects.isNull(completeSignUpButton)) {
            completeSignUpButton = findElement(new Finder(LocatorType.XPATH, "//*[text()='Complete Signup']", true));
        }
        return completeSignUpButton;
    }

    public DealPage signUp(final String email, final String name, final String password, final String confirmPassword,
                           final String company, final String jobRole) {
        send(getEmailField(), email);
        click(getNextButton());
        send(getNameField(), name);
        send(getPasswordField(), password);
        send(getConfirmPasswordField(), confirmPassword);
        click(getCreateAccountButton());
        send(getCompanyField(), company);
        click(getJobRoleDropDown());
        select(jobRole);
        click(getCompleteSignUpButton());

        return DealPage.getInstance(webAutomationDriver);
    }
}
