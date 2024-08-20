package com.twozo.test;

import com.twozo.page.sign.in.SignIn;
import com.twozo.page.sign.up.SignUp;
import com.twozo.web.driver.service.WebAutomationDriver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class BaseTest {

    //    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
//    private static final Map<String, String> MAP = ConfigFileReader.get("Config.Properties");
//
    protected WebAutomationDriver webAutomationDriver = WebAutomationDriver.get();
    protected SignIn signIn;
    protected SignUp signUp;
    Set<Cookie> cookies;

    //WebDriver webDriver;

    @Test(priority = 1)
    public void setUp() {

        webAutomationDriver.getWebNavigator().to("https://www.facebook.com/");
        signIn = SignIn.getInstance(webAutomationDriver);

        signIn.facebookLogin();

        cookies = signIn.getCookies();


//        webAutomationDriver = WebAutomationDriver.get();
//        LOG.info("Browser initialize");
//        webAutomationDriver.getImplicitWaitHandler().implicitWait(Duration.ofSeconds(10));
//        webAutomationDriver.getWebNavigator().to("https://www.facebook.com/");
//        signIn = SignIn.getInstance(webAutomationDriver);
//        signIn.facebookLogin();
//       cookies = signIn.getCookies();
//
//        for (final Cookie cookie : cookies) {
//            System.out.println(cookie);
//        }


        //   signIn.addCookies();
        //webAutomationDriver.getWebNavigator().to("https://app.thelaunchclub.in/deals");
        // webAutomationDriver.getWebNavigator().to("https://dev.twozo.live/settings");

//        LOG.info("Navigated to Twozo website");
//        webAutomationDriver.getWebWindowHandler().maximize();
//        LOG.info("Browser window maximized");
//        signIn = SignIn.getInstance(webAutomationDriver);
//        signIn.addCookies();
        //signUp = signIn.switchToSignUp();
    }

//    @AfterMethod
//    public void tearDown() {
//        webAutomationDriver.quit();
//    }

    @Test(priority = 2)
    public void check() {

        webAutomationDriver.getWebNavigator().to("https://www.facebook.com/");
        signIn.addCookies(cookies);
        webAutomationDriver.getWebNavigator().to("https://www.facebook.com/friends/suggestions");

    }
}
