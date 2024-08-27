package com.twozo.test;

import com.twozo.commons.cookie.HttpCookie;
import com.twozo.page.sign.in.SignIn;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Set;

public class BaseTest {
    protected WebAutomationDriver webAutomationDriver;
    protected SignIn signIn;
    protected Set<HttpCookie> cookies;

    @BeforeClass
    public void setUp() {
        webAutomationDriver = WebAutomationDriver.get();

        webAutomationDriver.getWebNavigator().to("https://app.thelaunchclub.in/");
        webAutomationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
        SignIn.getInstance(webAutomationDriver).signIn("b1@gmail.com", "A$12345a");
        try {
            Thread.sleep(2000);
        } catch (Exception exception) {
        }
        cookies = webAutomationDriver.getSessionCookie().getCookies();

        webAutomationDriver.close();
    }
}
