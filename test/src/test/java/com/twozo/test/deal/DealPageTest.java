package com.twozo.test.deal;

import com.twozo.page.deal.DealPage;
import com.twozo.page.sign.in.SignIn;
import com.twozo.test.BaseTest;
import org.testng.annotations.Test;


public class DealPageTest extends BaseTest {

    @Test
    public void addDeal() {
        final SignIn signIn = SignIn.getInstance(webAutomationDriver);
        final DealPage deal = signIn.signIn("abcde@gmail.com", "New$Password123");

        deal.clickAddDeal().addDeal();
    }
}
