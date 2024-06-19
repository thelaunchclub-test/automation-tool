package com.twozo.page.sign.in;

import com.twozo.page.BasePage;
import com.twozo.page.deal.Deal;
import com.twozo.page.sign.up.SignUp;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.service.WebPageElement;

import java.util.Objects;

public class SignIn extends BasePage {

    private static final String TWOZO_LINK = "https://app.thelaunchclub.in/";
    private static SignIn signIn;

    private Deal deal;
    private SignUp signUp;
    private WebPageElement emailField;
    private WebPageElement passwordField;
    private WebPageElement forgotPassword;
    private WebPageElement rememberMeCheckBox;
    private WebPageElement signInButton;
    private WebPageElement signUpButton;

    private SignIn(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);
        webNavigator.to(TWOZO_LINK);
        //this.signUp = SignUp.getInstance(webAutomationDriver);
        //this.deal = HomePage.getInstance(webAutomationDriver).switchToDeal();
    }

    public static SignIn getInstance(final WebAutomationDriver webAutomationDriver) {

        if (Objects.isNull(signIn)) {
            signIn = new SignIn(webAutomationDriver);
        }

        return signIn;
    }

    public SignUp getSignUp() {

        if (Objects.isNull(signUp)) {
            signUp = SignUp.getInstance(webAutomationDriver);
        }

        return signUp;
    }

    public Deal getDeal() {

        if (Objects.isNull(deal)) {
            deal = Deal.getInstance(webAutomationDriver);
        }

        return deal;
    }

    public WebPageElement getEmailField() {

        if (Objects.isNull(emailField)) {
            emailField = findByXpath("//input[@name='email']");
        }

        return emailField;
    }

    public WebPageElement getPasswordField() {

        if (Objects.isNull(passwordField)) {
            passwordField = findByXpath("//input[@name='password']");
        }

        return passwordField;
    }

    public WebPageElement getForgotPassword() {

        if (Objects.isNull(forgotPassword)) {
            forgotPassword = findByText("Forgot Password?");
        }

        return forgotPassword;
    }

    public WebPageElement getRememberMeCheckBox() {

        if (Objects.isNull(rememberMeCheckBox)) {
            rememberMeCheckBox = findByXpath("//*[@type='checkbox']");
        }

        return rememberMeCheckBox;
    }

    public WebPageElement getSignInButton() {

        if (Objects.isNull(signInButton)) {
            signInButton = findByText("Sign In");
        }

        return signInButton;
    }

    public WebPageElement getSignUpButton() {

        if (Objects.isNull(signUpButton)) {
            signUpButton = findByText("Sign Up");
        }

        return signUpButton;
    }

    public Deal signIn(final String email, final String password) {
        send(getEmailField(), email);
        send(getPasswordField(), password);
        click(getSignInButton());

        return getDeal();
    }

    public SignUp switchToSignUp() {
        return getSignUp();
    }
}
