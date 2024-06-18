package com.twozo.test.sign.up;

import com.twozo.page.sign.in.SignIn;
import com.twozo.test.BaseTest;

import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpWithValidDetails() {
        SignIn signIn = SignIn.getInstance(webAutomationDriver);

        signIn.switchToSignUp().signUp("abcde@gmail.com", "New User", "New$Password123",
                "New$Password123", "abcde", "Marketing");

        //assertTrue(signUp.switchToDeal().isDealPageDisplayed());
    }
}
