package com.twozo.test;

import com.twozo.commons.cookie.HttpCookie;
import com.twozo.page.sign.in.SignIn;
import com.twozo.page.sign.up.SignUp;
import com.twozo.web.driver.service.WebAutomationDriver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class BaseTest {

    //    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
//    private static final Map<String, String> MAP = ConfigFileReader.get("Config.Properties");
//
    protected WebAutomationDriver webAutomationDriver = WebAutomationDriver.get();
    protected SignIn signIn;
    protected SignUp signUp;
    Set<HttpCookie> cookies;

    //WebDriver webDriver;

    @BeforeClass
    public void setUp() {

        webAutomationDriver.getWebNavigator().to("https://app.thelaunchclub.in/");
        signIn = SignIn.getInstance(webAutomationDriver);

        signIn.signIn("ravi@gmail.com", "Ravi$123");
        cookies = signIn.getCookies();


        webAutomationDriver = WebAutomationDriver.get();
        //LOG.info("Browser initialize");
        webAutomationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
        webAutomationDriver.getWebNavigator().to("https://www.facebook.com/");
        signIn = SignIn.getInstance(webAutomationDriver);
        signIn.facebookLogin();
        cookies = signIn.getCookies();

        for (final HttpCookie cookie : cookies) {
            System.out.println(cookie);
        }

        signIn.addCookies(cookies);
        webAutomationDriver.getWebNavigator().to("https://app.thelaunchclub.in/deals");
        webAutomationDriver.getWebNavigator().to("https://dev.twozo.live/settings");

        //LOG.info("Navigated to Twozo website");
        webAutomationDriver.getWebWindowHandler().maximize();
        //LOG.info("Browser window maximized");
        signIn = SignIn.getInstance(webAutomationDriver);
        signIn.addCookies(cookies);
        signUp = signIn.switchToSignUp();
    }

//    @AfterMethod
//    public void tearDown() {
//        webAutomationDriver.quit();
//    }

}
