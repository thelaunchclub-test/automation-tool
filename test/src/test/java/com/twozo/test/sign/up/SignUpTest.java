package com.twozo.test.sign.up;

import com.twozo.page.sign.in.SignIn;
import com.twozo.test.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.Test;

public final class SignUpTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(SignUpTest.class);

    @Test(enabled = true)
    public void signUpWithValidDetails() {
        final SignIn signIn = SignIn.getInstance(webAutomationDriver);

        signIn.switchToSignUp().signUp("spo@gmail.com", "New User", "A$12345a",
                "A$12345a", "spo", "Marketing");
        LOG.info("Signed up successfully");
    }
}
