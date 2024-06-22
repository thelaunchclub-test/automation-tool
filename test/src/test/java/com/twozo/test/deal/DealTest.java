package com.twozo.test.deal;

import com.twozo.page.deal.Deal;
import com.twozo.page.sign.in.SignIn;
import com.twozo.test.BaseTest;
import org.testng.annotations.Test;

public final class DealTest extends BaseTest {

    @Test
    public void addDeal() {
        final SignIn signIn = SignIn.getInstance(webAutomationDriver);
        final Deal deal = signIn.signIn("aei@gmail.com", "New$Password123");

        deal.switchToAddDeal().addDeal();
    }
}
