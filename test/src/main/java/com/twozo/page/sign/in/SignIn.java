package com.twozo.page.sign.in;

import com.twozo.commons.exception.TestException;
import com.twozo.page.BasePage;
import com.twozo.page.deal.Deal;
import com.twozo.page.sign.up.SignUp;
import com.twozo.web.driver.service.WebAutomationDriver;
import com.twozo.web.element.finder.Finder;
import com.twozo.web.element.locator.LocatorType;
import com.twozo.web.element.service.WebPageElement;
import com.twozo.web.status.WebDriverStatusCode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SignIn extends BasePage {

    private static final String TWOZO_LINK = "https://app.thelaunchclub.in/";
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
        //webNavigator.to(TWOZO_LINK);
        //this.signUp = SignUp.getInstance(webAutomationDriver);
        //this.deal = HomePage.getInstance(webAutomationDriver).switchToDeal();

        if (!pageInformationProvider.getCurrentUrl().equals("https://app.thelaunchclub.in/")) {
            throw TestException.get(WebDriverStatusCode.EXPECTED_PAGE_NOT_FOUND, "exp page not found");
        }
    }

    public static SignIn getInstance(final WebAutomationDriver webAutomationDriver) {

        //if (Objects.isNull(signIn)) {
        signIn = new SignIn(webAutomationDriver);
        //}

        return signIn;
    }

    public Deal getDeal() {

        if (Objects.isNull(deal)) {
            deal = Deal.getInstance(webAutomationDriver);
        }

        return deal;
    }

    public SignUp getSignUp() {

        if (Objects.isNull(signUp)) {
            signUp = SignUp.getInstance(webAutomationDriver);
        }

        return signUp;
    }

    public WebPageElement getTwozoLogo() {

        if (Objects.isNull(twozoLogo)) {
            twozoLogo = findByXpath("//*[@alt='twozo']");
        }
        return twozoLogo;
    }

    public WebPageElement getGreetingText() {

        if (Objects.isNull(greetingText)) {
            greetingText = findByText("Welcome Back!");
        }

        return greetingText;
    }

    public WebPageElement getWorkEmailIdText() {

        if (Objects.isNull(workEmailIdText)) {
            workEmailIdText = findByText("Work Email Id");
        }

        return workEmailIdText;
    }

    public WebPageElement getPasswordText() {

        if (Objects.isNull(passwordText)) {
            passwordText = findByText("Password");
        }

        return passwordText;
    }

    public WebPageElement getRememberMeCheckBox() {

        if (Objects.isNull(rememberMeCheckBox)) {
            rememberMeCheckBox = findByText("//*[@type='checkbox']");

        }

        return rememberMeCheckBox;
    }

    public WebPageElement getRememberMeCheckBoxToCheckIfDisplayed() {

        if (Objects.isNull(rememberMeCheckBoxToCheckIfDisplayed)) {
            //rememberMeCheckBoxToCheckIfDisplayed = findByText("//*[@type='checkbox']");
            rememberMeCheckBoxToCheckIfDisplayed = findLeftElement(List.of(new Finder(LocatorType.XPATH, "//*[text()='Remember Me']"
                    , true), new Finder(LocatorType.TAG_NAME, "svg", false)));
        }

        return rememberMeCheckBoxToCheckIfDisplayed;
    }

    public WebPageElement getSignInButton() {

        if (Objects.isNull(signInButton)) {
            signInButton = findByText("Sign In");
        }

        return signInButton;
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

    public WebPageElement getForgotPasswordButton() {

        if (Objects.isNull(forgotPasswordButton)) {
            forgotPasswordButton = findByText("Forgot Password?");
        }

        return forgotPasswordButton;
    }

    public WebPageElement getResetPasswordButton() {

        if (Objects.isNull(resetPasswordButton)) {
            resetPasswordButton = findByText("Reset Password");
        }

        return resetPasswordButton;
    }

    public WebPageElement getForgotPasswordPageStatement() {

        if (Objects.isNull(forgotPasswordPageStatement)) {
            forgotPasswordPageStatement = findByXpath("//*[contains(text(),'worries')]");
        }

        return forgotPasswordPageStatement;
    }

    public WebPageElement getSignUpButton() {

        if (Objects.isNull(signUpButton)) {
            signUpButton = findByText("Sign Up");
        }

        return signUpButton;
    }

    public WebPageElement getEmailIdPlaceholder() {

        if (Objects.isNull(emailIdPlaceholder)) {
            emailIdPlaceholder = findByXpath("//*[@placeholder='Enter your work email id']");
        }

        return emailIdPlaceholder;
    }

    public WebPageElement getPasswordPlaceholder() {

        if (Objects.isNull(passwordPlaceholder)) {
            passwordPlaceholder = findByXpath("//*[@placeholder='Enter password']");
        }

        return passwordPlaceholder;
    }

    public Deal signIn(final String email, final String password) {
        send(getEmailField(), email);
        send(getPasswordField(), password);
        click(getSignInButton());

        return getDeal();
    }

    public WebPageElement getEmailValidationText() {

        if (Objects.isNull(emailValidationText)) {
            emailValidationText = findByText("Please enter a valid work email id");
        }

        return emailValidationText;
    }

    public WebPageElement getForgotPasswordPageInvalidEmailIdValidationText() {

        if (Objects.isNull(forgotPasswordPageInvalidEmailIdValidationText)) {
            forgotPasswordPageInvalidEmailIdValidationText = findByText("Please enter a valid email id");
        }

        return forgotPasswordPageInvalidEmailIdValidationText;
    }

    public WebPageElement getForgotPasswordPageNoEmailIdValidationText() {

        if (Objects.isNull(forgotPasswordPageNoEmailIdValidationText)) {
            forgotPasswordPageNoEmailIdValidationText = findByText("Please enter your email address");
        }

        return forgotPasswordPageNoEmailIdValidationText;
    }

    public WebPageElement getPasswordValidationText() {

        if (Objects.isNull(passwordValidationText)) {
            passwordValidationText = findByText("Invalid Username / Password");
        }

        return passwordValidationText;
    }

    public WebPageElement getEyeIcon() {

        if (Objects.isNull(eyeIcon)) {
            eyeIcon = findByXpath("//*[@aria-label='toggle password visibility']");
        }

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
                getRememberMeCheckBox(),
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
}
