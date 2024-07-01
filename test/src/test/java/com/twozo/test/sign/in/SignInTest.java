package com.twozo.test.sign.in;

import com.twozo.page.deal.Deal;
import com.twozo.page.settings.Source;
import com.twozo.test.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public final class SignInTest extends BaseTest {

    @Test
    public void isLogInPageDetailsDisplayed() {
        Assert.assertTrue(signIn.isLogInPageDetailsDisplayed());
    }

    @Test
    public void isPlaceholderForWorkEmailIdDisplayed() {
        Assert.assertTrue(signIn.isPlaceholderForWorkEmailIdDisplayed());
    }

    @Test
    public void checkEmailValidation() {
        signIn.isEmailValidationDisplayed("ravi");
        Assert.assertTrue(signIn.isDisplayed(signIn.getEmailValidationText()));
    }

    @Test
    public void isPlaceholderForPasswordDisplayed() {
        Assert.assertTrue(signIn.isPlaceholderForPasswordDisplayed());
    }

    @Test
    public void isEyeIconDisplayed() {
        Assert.assertTrue(signIn.isEyeIconDisplayed());
    }

    @Test
    public void isPasswordHidden() {
        Assert.assertTrue(signIn.isPasswordHidden("wert"));
    }

    @Test
    public void isPasswordUnhidden() {
        Assert.assertTrue(signIn.isPasswordUnhidden("wert"));
    }

    @Test
    public void isPasswordHiddenAgain() {
        Assert.assertTrue(signIn.isPasswordHiddenAgain("wert"));
    }

    @Test
    public void isForgotPasswordTextDisplayed() {
        Assert.assertTrue(signIn.isForgotPasswordButtonDisplayed());
    }

    @Test
    public void isForgotPasswordPageDisplayed() {
        Assert.assertTrue(signIn.isResetPasswordPageDisplayed());
    }

    @Test
    public void isForgotPasswordPageDetailsDisplayed() {
        Assert.assertTrue(signIn.isResetPasswordPageDetailsDisplayed());
    }

    @Test
    public void isForgotPasswordPageStatementDisplayed() {
        Assert.assertTrue(signIn.isForgotPasswordPageStatementDisplayed());
    }

    @Test
    public void verifyResetPageValidationWithInvalidData() {
        signIn.resetPassword("677");
        Assert.assertTrue(signIn.isDisplayed(signIn.getForgotPasswordPageInvalidEmailIdValidationText()));
    }

    @Test
    public void verifyResetPageValidationWithNoData() {
        signIn.resetPassword("");
        Assert.assertTrue(signIn.isDisplayed(signIn.getForgotPasswordPageNoEmailIdValidationText()));
    }

    @Test
    public void verifyResetPageValidationWithValidData() {
        signIn.resetPassword("ravi@gmail.com"); //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyInbox() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyTemplateOfTheInbox() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyTheCopyRightInfo() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyLogoInTheMail() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyInvalidLink() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyRequestNewLink() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyNewRequestedLink() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyPlaceholderOfNewPasswordAndConfirmPassword() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyToolTipOfNewPassword() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyEyeIconOnBothFields() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void verifyInvalidPassword() {
        //TODO: Implement the code after the functionality for the sign-in page is completed.
    }

    @Test
    public void isRememberMeCheckBoxDisplayed() {
        Assert.assertTrue(signIn.isRememberMeCheckBoxDisplayed());
    }

    @Test
    public void isCheckboxIsUncheckedByDefault() {
        Assert.assertTrue(signIn.isCheckboxIsUncheckedByDefault());
    }

    @Test
    public void signIn() {
         signIn.signIn("p@gmail.com", "A$12345a").switchToSettings();

        //ravi$123.stream().collect(Coll).filter(Deal::isDisplayed).map()forEach(System.out::println);

    }
}

