package com.twozo.test;

import com.twozo.page.sign.in.SignIn;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    protected WebAutomationDriver webAutomationDriver;
    protected SignIn signIn;

    @BeforeMethod
    public void setUp() {
        webAutomationDriver = WebAutomationDriver.get();
        LOG.info("Browser initialize");
        webAutomationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
        webAutomationDriver.getWebNavigator().to("https://app.thelaunchclub.in/");
        LOG.info("Navigated to Twozo website");
        webAutomationDriver.getWebWindowHandler().maximize();
        LOG.info("Browser window maximized");
        signIn = SignIn.getInstance(webAutomationDriver);
    }

//    @AfterMethod
//    public void tearDown() {
//        webAutomationDriver.quit();
//    }
}
