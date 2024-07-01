package com.twozo.test.sign.up;

import com.twozo.page.sign.in.SignIn;
import com.twozo.test.BaseTest;

import org.testng.annotations.Test;

public final class SignUpTest extends BaseTest {

    @Test(enabled = true)
    public void signUpWithValidDetails() {
        SignIn signIn = SignIn.getInstance(webAutomationDriver);

        signIn.switchToSignUp().signUp("popo@gmail.com", "New User", "A$12345a",
                "A$12345a", "pop", "Marketing");

        //assertTrue(signUp.switchToDeal().isDealPageDisplayed());
    }
}
