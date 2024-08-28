package com.twozo.test;

import com.twozo.commons.cookie.BrowserCookie;
import com.twozo.page.BasePage;
import com.twozo.page.sign.SignIn;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Set;

public class BaseTest {

    private BasePage basePage;
    protected SignIn signIn;
    protected Set<BrowserCookie> cookies;

    @BeforeClass
    public void setUp() {
        basePage = BasePage.getInstance(WebAutomationDriver.get());

        basePage.webNavigator.to("https://app.thelaunchclub.in/");
        basePage.implicitWaitHandler.implicitWait(Duration.ofSeconds(10));
        SignIn.getInstance().signIn("b6@gmail.com", "A$12345a");

        try {
            Thread.sleep(2000);
        } catch (Exception exception) {
        }
        cookies=basePage.sessionCookie.getCookies();

        basePage.close();
    }
}
