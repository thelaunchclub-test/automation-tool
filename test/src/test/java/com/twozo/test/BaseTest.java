package com.twozo.test;

import com.twozo.commons.util.ConfigFileReader;
import com.twozo.page.sign.in.SignIn;
import com.twozo.page.sign.up.SignUp;
import com.twozo.page.url.URL;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Map;

public class BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    private static final Map<String, String> MAP = ConfigFileReader.get("Config.Properties");

    protected WebAutomationDriver webAutomationDriver;
    protected SignIn signIn;
    protected SignUp signUp;

    @BeforeClass
    public void setUp() {
        webAutomationDriver = WebAutomationDriver.get();
        LOG.info("Browser initialize");
        webAutomationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
        webAutomationDriver.getWebNavigator().to(URL.LOG_IN);
        LOG.info("Navigated to Twozo website");
        webAutomationDriver.getWebWindowHandler().maximize();
        LOG.info("Browser window maximized");
        signIn = SignIn.getInstance(webAutomationDriver);
      //signUp = signIn.switchToSignUp();
    }

//    @AfterMethod
//    public void tearDown() {
//        webAutomationDriver.quit();
//    }
}
