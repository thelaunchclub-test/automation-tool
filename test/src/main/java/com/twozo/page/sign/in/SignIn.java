package com.twozo.page.sign.in;

import com.twozo.page.BasePage;
import com.twozo.page.deal.DealPage;
import com.twozo.page.sign.up.SignUp;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class SignIn extends BasePage {

    private static final String TWOZO_LINK = "https://app.thelaunchclub.in/";
    private static SignIn signIn;

    private WebPageElement emailField;
    private WebPageElement passwordField;
    private WebPageElement forgotPassword;
    private WebPageElement rememberMeCheckBox;
    private WebPageElement signInButton;
    private WebPageElement signUpButton;

    private SignIn(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
        webNavigator.to(TWOZO_LINK);
//        if (!isDisplayed(findElement(new Finder(LocatorType.XPATH, "//p[contains(text(), 'Welcome')]", true)))) {
//            throw TestException.get(WebDriverStatusCode.EXPECTED_PAGE_NOT_FOUND);
//        }
    }

    public static synchronized SignIn getInstance(final WebAutomationDriver webAutomationDriver) {
        if (Objects.isNull(signIn)) {
            signIn = new SignIn(webAutomationDriver);
        }
        return signIn;
    }

    public WebPageElement getEmailField() {
        if (Objects.isNull(emailField)) {
            emailField = findElement(new Finder(LocatorType.NAME, "email", true));
        }
        return emailField;
    }

    public WebPageElement getPasswordField() {
        if (Objects.isNull(passwordField)) {
            passwordField = findElement(new Finder(LocatorType.NAME, "password", true));
        }
        return passwordField;
    }

    public WebPageElement getForgotPassword() {
        if (Objects.isNull(forgotPassword)) {
            forgotPassword = findElement(new Finder(LocatorType.XPATH, "//*[text()='Forgot Password?']", true));
        }
        return forgotPassword;
    }

    public WebPageElement getRememberMeCheckBox() {
        if (Objects.isNull(rememberMeCheckBox)) {
            rememberMeCheckBox = findElement(new Finder(LocatorType.XPATH, "//*[@type='checkbox']", true));
        }
        return rememberMeCheckBox;
    }

    public WebPageElement getSignInButton() {
        if (Objects.isNull(signInButton)) {
            signInButton = findElement(new Finder(LocatorType.XPATH, "//*[text()='Sign In']", true));
        }
        return signInButton;
    }

    public WebPageElement getSignUpButton() {
        if (Objects.isNull(signUpButton)) {
            signUpButton = findElement(new Finder(LocatorType.XPATH, "//*[text()='Sign Up']", true));
        }
        return signUpButton;
    }

    public DealPage signIn(String email, String password) {
        send(getEmailField(), email);
        send(getPasswordField(), password);
        click(getSignInButton());
        return DealPage.getInstance(webAutomationDriver);
    }

    public DealPage switchToDeal() {
        return DealPage.getInstance(webAutomationDriver);
    }

    public SignUp switchToSignUp() {
        return SignUp.getInstance(webAutomationDriver);
    }
}
