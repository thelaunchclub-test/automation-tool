package com.twozo.test;

import com.twozo.web.driver.service.Driver;
import com.twozo.web.driver.service.WebAutomationDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebAutomationDriver webAutomationDriver;

    @BeforeClass
    public void setUp() {
        webAutomationDriver = Driver.getInstance().getWebAutomationDriver();
        webAutomationDriver.getWebWindowHandler().maximize();
        webAutomationDriver.getWaitHandler().implicitWait(Duration.ofSeconds(10));
        webAutomationDriver.getWebNavigator().to("https://app.thelaunchclub.in/");
    }

    @AfterClass
    public void tearDown(){
        webAutomationDriver.quit();
    }
}
