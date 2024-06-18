package com.twozo.test.sign.in;

import com.twozo.page.sign.in.SignIn;
import com.twozo.test.BaseTest;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test
    public void signInWithValidCredential() {
        final SignIn signIn = SignIn.getInstance(webAutomationDriver);
        signIn.signIn("abcd@gmail.com", "New$Password123");

    }

    @Test
    public void signInWithInValidCredential() {
        final SignIn signIn = SignIn.getInstance(webAutomationDriver);
        signIn.signIn("in@gmail.com", "New$Password123");
    }


}
