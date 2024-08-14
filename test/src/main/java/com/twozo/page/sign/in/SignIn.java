package com.twozo.page.sign.in;

import com.twozo.commons.exception.ErrorCode;
import com.twozo.page.url.URL;
import com.twozo.page.xpath.AttributeName;
import com.twozo.page.BasePage;
import com.twozo.page.xpath.TagName;
import com.twozo.page.xpath.XPath;
import com.twozo.page.deal.Deal;
import com.twozo.page.homepage.HomePage;
import com.twozo.page.sign.up.SignUp;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.model.Element;
import com.twozo.web.element.model.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SignIn extends BasePage {

    private static SignIn signIn;

    private Deal deal;
    private SignUp signUp;
    private WebPageElement greetingText;
    private WebPageElement passwordText;
    private WebPageElement workEmailIdText;
    private WebPageElement rememberMeCheckBoxToCheckIfDisplayed;
    private WebPageElement rememberMeCheckBox;
    private WebPageElement signInButton;
    private WebPageElement emailField;
    private WebPageElement passwordField;
    private WebPageElement forgotPasswordButton;
    private WebPageElement signUpButton;
    private WebPageElement emailIdPlaceholder;
    private WebPageElement passwordPlaceholder;
    private WebPageElement emailValidationText;
    private WebPageElement passwordValidationText;
    private WebPageElement eyeIcon;
    private WebPageElement resetPasswordButton;
    private WebPageElement twozoLogo;
    private WebPageElement forgotPasswordPageStatement;
    private WebPageElement forgotPasswordPageInvalidEmailIdValidationText;
    private WebPageElement forgotPasswordPageNoEmailIdValidationText;

    private SignIn(final WebAutomationDriver webAutomationDriver) {
        super(webAutomationDriver);

        if (!getURL().equals(URL.LOG_IN)) {
            throw ErrorCode.get(WebDriverErrorCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static SignIn getInstance(final WebAutomationDriver webAutomationDriver) {
        return new SignIn(webAutomationDriver);
    }

    public Deal getDeal() {
        deal = initializeElement(deal, () -> Deal.getInstance(webAutomationDriver));

        return deal;
    }

    public SignUp getSignUp() {
        //signUp = initializeElement(signUp, () -> SignUp.getInstance(webAutomationDriver));

        return SignUp.getInstance(webAutomationDriver);
    }

    public WebPageElement getTwozoLogo() {
        twozoLogo = initializeElement(twozoLogo, () -> findByXpath(new XPath(TagName.IMG, AttributeName.ALT, "twozo", 1)));

        return twozoLogo;
    }

    public WebPageElement getGreetingText() {
        greetingText = initializeElement(greetingText, () -> findByText("Welcome Back!"));

        return greetingText;
    }

    public WebPageElement getWorkEmailIdText() {
        workEmailIdText = initializeElement(workEmailIdText, () -> findByText("Work Email Id"));

        return workEmailIdText;
    }

    public WebPageElement getPasswordText() {
        passwordText = initializeElement(passwordText, () -> findByText("Password"));

        return passwordText;
    }

    public WebPageElement getRememberMeCheckBox() {
        rememberMeCheckBox = initializeElement(rememberMeCheckBox, () -> findByXpath("//*[@type='checkbox']"));

        return rememberMeCheckBox;
    }

    public WebPageElement getRememberMeCheckBoxToCheckIfDisplayed() {
        rememberMeCheckBoxToCheckIfDisplayed = initializeElement(rememberMeCheckBox, () -> findLeftElement(List.of(new Element(LocatorType.XPATH, "//*[text()='Remember Me']"
                , true), new Element(LocatorType.TAG_NAME, "svg", false))));

        return rememberMeCheckBoxToCheckIfDisplayed;
    }

    public WebPageElement getSignInButton() {
        signInButton = initializeElement(signInButton, () -> findByText("Sign In"));
        return signInButton;
    }

    public WebPageElement getEmailField() {
        emailField = initializeElement(emailField, () -> findByXpath("//input[@name='email']"));

        return emailField;
    }

    public WebPageElement getPasswordField() {
        passwordField = initializeElement(passwordField, () -> findByXpath("//input[@name='password']"));

        return passwordField;
    }

    public WebPageElement getForgotPasswordButton() {
        forgotPasswordButton = initializeElement(forgotPasswordButton, () -> findByText("Forgot Password?"));

        return forgotPasswordButton;
    }

    public WebPageElement getResetPasswordButton() {
        resetPasswordButton = initializeElement(resetPasswordButton, () -> findByText("Reset Password"));

        return resetPasswordButton;
    }

    public WebPageElement getForgotPasswordPageStatement() {
        forgotPasswordPageStatement = initializeElement(forgotPasswordPageStatement, () -> findByXpath("//*[contains(text(),'worries')]"));

        return forgotPasswordPageStatement;
    }

    public WebPageElement getSignUpButton() {
        signUpButton = initializeElement(signUpButton, () -> findByText("Sign Up"));

        return signUpButton;
    }

    public WebPageElement getEmailIdPlaceholder() {
        emailIdPlaceholder = initializeElement(emailIdPlaceholder, () -> findByXpath("//*[@placeholder='Enter your work email id']"));

        return emailIdPlaceholder;
    }

    public WebPageElement getPasswordPlaceholder() {
        passwordPlaceholder = initializeElement(passwordPlaceholder, () -> findByXpath("//*[@placeholder='Enter password']"));
        return passwordPlaceholder;
    }

    public HomePage signIn(final String email, final String password) {
        send(getEmailField(), email);
        send(getPasswordField(), password);
        click(getSignInButton());
        return HomePage.getInstance(webAutomationDriver);
    }

    public WebPageElement getEmailValidationText() {
        emailValidationText = initializeElement(emailValidationText, () -> findByText("Please enter a valid work email id"));
        return emailValidationText;
    }

    public WebPageElement getForgotPasswordPageInvalidEmailIdValidationText() {
        forgotPasswordPageInvalidEmailIdValidationText = initializeElement(forgotPasswordPageInvalidEmailIdValidationText, () -> findByText("Please enter a valid email id"));
        return forgotPasswordPageInvalidEmailIdValidationText;
    }

    public WebPageElement getForgotPasswordPageNoEmailIdValidationText() {
        forgotPasswordPageNoEmailIdValidationText = initializeElement(forgotPasswordPageNoEmailIdValidationText, () -> findByText("Please enter your email address"));
        return forgotPasswordPageNoEmailIdValidationText;
    }

    public WebPageElement getPasswordValidationText() {
        passwordValidationText = initializeElement(passwordValidationText, () -> findByText("Invalid Username / Password"));
        return passwordValidationText;
    }

    public WebPageElement getEyeIcon() {
        // EyeIcon initialization logic
        return eyeIcon;
    }

    public SignUp switchToSignUp() {
        return getSignUp();
    }

    public boolean isLogInPageDetailsDisplayed() {
        final List<WebPageElement> elementsToCheck = Arrays.asList(
                getGreetingText(),
                getWorkEmailIdText(),
                getPasswordText(),
                getRememberMeCheckBoxToCheckIfDisplayed(),
                getSignInButton()
        );

        for (final WebPageElement element : elementsToCheck) {

            if (!isDisplayed(element)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPlaceholderForWorkEmailIdDisplayed() {
        return isDisplayed(getEmailIdPlaceholder());
    }

    public void isEmailValidationDisplayed(final String invalidEmailId) {
        send(getEmailField(), invalidEmailId);
        click(getSignInButton());
    }

    public boolean isPlaceholderForPasswordDisplayed() {
        return isDisplayed(getPasswordPlaceholder());
    }

    public boolean isEyeIconDisplayed() {
        return isDisplayed(getEyeIcon());
    }

    public boolean isPasswordHidden(final String password) {
        send(getPasswordField(), password);
        return getAttribute(getPasswordField(), "type").equals("password");
    }

    public boolean isPasswordUnhidden(final String password) {
        send(getPasswordField(), password);
        click(getEyeIcon());
        return getAttribute(getPasswordField(), "type").equals("text");
    }

    public boolean isPasswordHiddenAgain(final String password) {
        send(getPasswordField(), password);
        click(getEyeIcon());
        click(getEyeIcon());
        return getAttribute(getPasswordField(), "type").equals("password");
    }

    public boolean isForgotPasswordButtonDisplayed() {
        return isDisplayed(getForgotPasswordButton());
    }

    public boolean isResetPasswordPageDisplayed() {
        click(getForgotPasswordButton());
        return isDisplayed(getForgotPasswordPageStatement());
    }

    public boolean isResetPasswordPageDetailsDisplayed() {
        click(getForgotPasswordButton());
        isDisplayed(getTwozoLogo());
        isDisplayed(getWorkEmailIdText());
        isDisplayed(getEmailField());
        return isDisplayed(getResetPasswordButton());
    }

    public boolean isForgotPasswordPageStatementDisplayed() {
        click(getForgotPasswordButton());
        return isDisplayed(getForgotPasswordPageStatement());
    }

    public void resetPassword(final String emailId) {
        click(getForgotPasswordButton());
        send(getEmailField(), emailId);
        click(getResetPasswordButton());
    }

    public void isResetLinkReceivedIfDifferentEmailIdProvided(final String emailId, final String differentEmailId) {
        send(getEmailField(), emailId);
        click(getForgotPasswordButton());
        send(getEmailField(), differentEmailId);
        click(getResetPasswordButton());  //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    public boolean isRememberMeCheckBoxDisplayed() {
        return isDisplayed(getRememberMeCheckBoxToCheckIfDisplayed());
    }

    public boolean isCheckboxIsUncheckedByDefault() {
        return getAttribute(getRememberMeCheckBoxToCheckIfDisplayed(), "style").equals("fill: none;");
    }

    public void check() {
        hover(new Element(LocatorType.XPATH, "//*[text()='Sign In']", true));
    }
}
